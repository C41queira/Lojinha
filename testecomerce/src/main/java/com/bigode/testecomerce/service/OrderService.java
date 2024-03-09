package com.bigode.testecomerce.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bigode.testecomerce.dto.CartDTO;
import com.bigode.testecomerce.dto.OrderDTO;
import com.bigode.testecomerce.entity.Cart;
import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.exceptions.DataBaseException;
import com.bigode.testecomerce.exceptions.ResourceNotFoundException;
import com.bigode.testecomerce.repository.CartRepository;
import com.bigode.testecomerce.repository.OrderRepository;
import com.bigode.testecomerce.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository; 
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Order> findAll(){
        return orderRepository.findAll(); 
    }

    public Order findById(int id){
        Optional<Order> obj = orderRepository.findById(id); 
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
    }

    public List<OrderDTO> findOrdersByUserClient(int id){
    	List<Order> listOrder = orderRepository.findOrdersByUserId(id);
    	List<OrderDTO> listDTO = new ArrayList<OrderDTO>();
    	
    	for(Order order: listOrder) {
    		OrderDTO dto = new OrderDTO(order);
    		listDTO.add(dto);
    	}
    	
    	return listDTO; 
    }

    public Order insert(Order obj){
        return orderRepository.save(obj);
    }

    public void delete(int id){
        try {
            orderRepository.deleteById(id);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id); 
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
        
    }

    public Order update(int id, Order Order){
        try {
            Order entity = orderRepository.getReferenceById(id); 
            updateData(entity, Order); 
            return orderRepository.save(entity); 
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id); 
        }
        
    }
    
    public void cartFromOrder(Integer userId, Order obj) {
    	Cart cart = cartRepository.findCartByUserId(userId); 
    	
    	OrderDTO dto = new OrderDTO(null, cart.getProdutos(), cart.getClientCarrinho());
    	
    	//Conversão de OrderDTO para Order
    	obj = toOrder(dto);
    	
    	orderRepository.save(obj);
    	
    	//Atualizar os produtos Cart -> Order
    	for(Product produto: dto.getListProdutos()) {
    		produto.setCart(null);
    		produto.setPedido(obj);
    		productRepository.save(produto);
    	}
    	
    	//Limpar a lista do Carrinho
    	cart.getProdutos().clear();
    	CartDTO cartdto = new CartDTO(cart);
    	cartdto.updateValues();
    	cartRepository.save(CartService.toCart(cartdto));
    	
    }

    private void updateData(Order entity, Order order) {
        entity.setDateTime(order.getDateTime());
        entity.setDestinatario(order.getDestinatario());
        entity.setListProdutos(order.getListProdutos());
        entity.setTotalValue(order.getTotalValue());
    }
    
    public static Order toOrder(OrderDTO orderDTO) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy h:mma", new Locale("pt", "BR"));
    	
	    Order order = new Order();
	    order.setId(orderDTO.getId());
	    order.setDateTime(LocalDateTime.parse(orderDTO.getDateTime(), formatter));
	    order.setTotalValue(orderDTO.getTotalValue());
	    order.setListProdutos(orderDTO.getListProdutos());
	    order.setDestinatario(orderDTO.getDestinatario());
	    return order;
	}
}

