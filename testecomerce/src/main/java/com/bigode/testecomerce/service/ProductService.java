package com.bigode.testecomerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.enums.CategoryProduct;
import com.bigode.testecomerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository; 
	
	public List<Product> findByPriceBetween(CategoryProduct categoria ,Double min, Double max){
		return repository.findByPriceBetween(categoria, min, max); 
	}
}
