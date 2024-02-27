package com.bigode.testecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bigode.testecomerce.dto.OrderDTO;
import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.exceptions.DataBaseException;
import com.bigode.testecomerce.exceptions.ResourceNotFoundException;
import com.bigode.testecomerce.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository; 
	
	public List<Order> findAll(){
        return orderRepository.findAll(); 
    }

    public Order findById(int id){
        Optional<Order> obj = orderRepository.findById(id); 
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
    }

    public List<Order> findOrdersByUserClient(int id){
        return orderRepository.findOrdersByUserId(id); 
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

    private void updateData(Order entity, Order order) {
        entity.setDateTime(order.getDateTime());
        entity.setDestinatario(order.getDestinatario());
        entity.setListProdutos(order.getListProdutos());
        entity.setTotalValue(order.getTotalValue());
    }
    
    public Order toOrder(OrderDTO orderDTO) {
	    Order order = new Order();
	    order.setId(orderDTO.getId());
	    order.setDateTime(orderDTO.getDateTime());
	    order.setTotalValue(orderDTO.getTotalValue());
	    order.setListProdutos(orderDTO.getListProdutos());
	    order.setDestinatario(orderDTO.getDestinatario());
	    return order;
	}
}

