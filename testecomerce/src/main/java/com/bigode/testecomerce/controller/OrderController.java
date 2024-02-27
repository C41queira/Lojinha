package com.bigode.testecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.service.OrderService;
import com.bigode.testecomerce.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	
	@Autowired
	private OrderService orderService; 
	
	@Autowired
	private UserService userService; 
	
	@GetMapping("/orders")
	public ModelAndView ordersByClient() {
		ModelAndView mv = new ModelAndView(); 
		
		return mv; 
	}
	
	@PostMapping("/createOrder")
	public String createOrderFromCart(HttpSession session) {
		
		UserClient client = (UserClient) session.getAttribute("usuarioLogin");
		
		Order order = new Order();
		
		if(!client.getCarrinho().getProdutos().isEmpty()) {
			orderService.cartFromOrder(client.getId(), order);
		}
	
		return "redirect:/";
	}
	
	
}
