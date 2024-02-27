package com.bigode.testecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.service.OrderService;
import com.bigode.testecomerce.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	
	@Autowired
	private OrderService serviceOrder; 
	
	@Autowired
	private UserService serviceUser; 
	
	@GetMapping("/orders/{id}")
	public ModelAndView ordersByClient(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView(); 
		
		return mv; 
	}
	
	@PostMapping("/createOrder")
	public String createOrderFromCart(HttpSession session) {
		
		
		return "redirect:/";
	}
	
	
}
