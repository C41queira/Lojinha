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
	
	
	@GetMapping("/eletronicos")
	public ModelAndView pageEletronicos() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/eletronicos");
		
		if(repository.findByCategoriEletronicos().isEmpty()) {
			mv.addObject("msg", "Não a mais produtos no estoque");
		}else {
			mv.addObject("filter", repository.findByCategoriEletronicos());
		}
		return mv; 
	}

}
