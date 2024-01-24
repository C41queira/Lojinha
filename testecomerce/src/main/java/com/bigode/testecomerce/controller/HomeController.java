package com.bigode.testecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.repository.ProductRepository;
	



@Controller
public class HomeController {
	
	@Autowired
	private ProductRepository repository;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("index");
		mv.addObject("eletronicos", repository.findByCategoriEletronicos());
		mv.addObject("moveis", repository.findByCategoriMoveis());
		mv.addObject("informatica", repository.findByCategoriInformatica());
		mv.addObject("gamer", repository.findByCategoriGamer());
		
		return mv; 
	}
	
	
}
