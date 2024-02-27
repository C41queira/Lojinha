package com.bigode.testecomerce.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bigode.testecomerce.dto.CartDTO;
import com.bigode.testecomerce.entity.Cart;
import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.exceptions.DataBaseException;
import com.bigode.testecomerce.exceptions.ResourceNotFoundException;
import com.bigode.testecomerce.repository.CartRepository;
import com.bigode.testecomerce.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class CartService {
	
	@Autowired
	private CartRepository repository; 
	
	@Autowired
	private ProductRepository productRepository; 
	
	public List<Cart> findAll(){
        return repository.findAll(); 
    }

    public Cart findById(int id){
        Optional<Cart> obj = repository.findById(id); 
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
    }

    public CartDTO findCartByUserClient(int id){
    	CartDTO cartDTO = new CartDTO(repository.findCartByUserId(id));
        return cartDTO; 
    }

    public Cart insert(CartDTO obj){
    	Cart c = convertCartDTOToCart(obj);
        return repository.save(c);
    }

    public void delete(int id){
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id); 
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
        
    }

    public Cart update(int id, Cart cart){
        try {
            Cart entity = repository.getReferenceById(id); 
            updateData(entity, cart); 
            return repository.save(entity); 
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id); 
        }
        
    }

    private void updateData(Cart entity, Cart cart) {
        entity.setClientCarrinho(cart.getClientCarrinho());
        entity.setProdutos(cart.getProdutos());
        entity.setQuantityProducts(cart.getQuantityProducts());
        entity.setTotalValue(cart.getTotalValue());
    }
	
	public Cart convertCartDTOToCart(CartDTO cartDTO) {
	    Cart cart = new Cart();
	    cart.setId(cartDTO.getId());
	    cart.setTotalValue(cartDTO.getTotalValue());
	    cart.setQuantityProducts(cartDTO.getQuantityProducts());
	    cart.setClientCarrinho(cartDTO.getClientCarrinho());
	    cart.setProdutos(cartDTO.getProdutos());

	    return cart;
	}
	
	public Cart addOnCart(Integer cartId, Integer productId) {
		
    	Cart cart = repository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    	Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    	
    	CartDTO dto = new CartDTO(cart);
    	
    	List<Product> produtosAtualizados = dto.getProdutos();
    	
    	produtosAtualizados.add(product);
    	
    	dto.setProdutos(produtosAtualizados);
    	
    	product.setCart(cart);
    	productRepository.save(product);
    	
    	cart = convertCartDTOToCart(dto);
    	return repository.save(cart);
    	
    }
	
	public Cart removeProductOnCart(Integer userId, Integer productId) {
		
		Cart cart = repository.findCartByUserId(userId);
    	Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    	
    	CartDTO dto = new CartDTO(cart);
    	
    	List<Product> produtosAtualizados = dto.getProdutos();
    	
    	produtosAtualizados.remove(product);
    	
    	dto.setProdutos(produtosAtualizados);
    	
    	product.setCart(null);
    	productRepository.save(product);
    	
    	cart = convertCartDTOToCart(dto);
    	return repository.save(cart);
    	
    	
	}

}
