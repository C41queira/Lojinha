package com.bigode.testecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository; 
	
	@GetMapping(value = "/users")
	public ModelAndView users() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("pages/users");
		
		mv.addObject("usuarios", repository.findAll()); 
		
		return mv; 
	}

}
