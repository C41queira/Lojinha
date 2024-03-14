package com.bigode.testecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.repository.ProductRepository;
import com.bigode.testecomerce.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repository; 
	
	@Autowired
	private ProductService service; 
	
	
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
	
	
	@GetMapping("/produto")
	public ModelAndView pageProduto(HttpSession session) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("pages/productSolo");
		
		Product product = (Product) session.getAttribute("selectedProd"); 
		
		mv.addObject("product", product); 
		
		return mv; 
	}
	
	@PostMapping("/saveProdSession/{id}")
	public String saveProdSession(@PathVariable Integer id,HttpSession session) {
		
		Product product = service.findById(id); 
		
		session.setAttribute("selectedProd", product);
		
		return "redirect:/produto";
	}

}
