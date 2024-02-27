package com.bigode.testecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bigode.testecomerce.dto.ProductDTO;
import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.enums.CategoryProduct;
import com.bigode.testecomerce.exceptions.DataBaseException;
import com.bigode.testecomerce.exceptions.ResourceNotFoundException;
import com.bigode.testecomerce.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository; 
	
	public List<Product> findAll(){
        return repository.findAll(); 
    }

    public Product findById(int id){
        Optional<Product> obj = repository.findById(id); 
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
    }


    public Product insert(ProductDTO obj){
    	Product c = convertProductDTOToProduct(obj);
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
	
	public List<Product> findByPriceBetween(CategoryProduct categoria ,Double min, Double max){
		return repository.findByPriceBetween(categoria, min, max); 
	}
	
	 public Product update(int id, Product product){
	        try {
	            Product entity = repository.getReferenceById(id); 
	            updateData(entity, product); 
	            return repository.save(entity); 
	        } catch (EntityNotFoundException e) {
	            throw new ResourceNotFoundException(id); 
	        }
        
    }

    private void updateData(Product entity, Product product) {
        entity.setCart(product.getCart());
        entity.setCategoryProduct(product.getCategoryProduct());
        entity.setInfo(product.getInfo());
        entity.setName(product.getName());
        entity.setPedido(product.getPedido());
        entity.setPrice(product.getPrice());
    }
    
    public Product convertProductDTOToProduct(ProductDTO productDTO) {
	    Product product = new Product();
	    
	    product.setId(productDTO.getId());
	    product.setCart(productDTO.getProductsCart());
	    product.setCategoryProduct(productDTO.getCategoryProduct());
	    product.setInfo(productDTO.getInfo());
	    product.setName(productDTO.getName());
	    product.setPedido(productDTO.getPedido());
	    product.setPrice(productDTO.getPrice());
	    
	    return product;
	}
}
