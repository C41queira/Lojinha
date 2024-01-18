package com.bigode.testecomerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("index");
		
		
		
		return mv; 
	}
}
