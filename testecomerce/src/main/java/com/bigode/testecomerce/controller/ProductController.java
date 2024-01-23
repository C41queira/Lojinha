package com.bigode.testecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repository; 

}
