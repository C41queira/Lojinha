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
	
	@GetMapping("/gamer")
	public ModelAndView pageGamer() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/gamer");
		
		if(repository.findByCategoriEletronicos().isEmpty()) {
			mv.addObject("msg", "Não a mais produtos no estoque");
		}else {
			mv.addObject("filter", repository.findByCategoriGamer());
		}
		return mv; 
	}
	
	@GetMapping("/informatica")
	public ModelAndView pageInformatica() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/informatica");
		
		if(repository.findByCategoriEletronicos().isEmpty()) {
			mv.addObject("msg", "Não a mais produtos no estoque");
		}else {
			mv.addObject("filter", repository.findByCategoriInformatica());
		}
		return mv; 
	}
	@GetMapping("/moveis")
	public ModelAndView pageMoveis() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/moveis");
		
		if(repository.findByCategoriEletronicos().isEmpty()) {
			mv.addObject("msg", "Não a mais produtos no estoque");
		}else {
			mv.addObject("filter", repository.findByCategoriMoveis());
		}
		return mv; 
	}

}
