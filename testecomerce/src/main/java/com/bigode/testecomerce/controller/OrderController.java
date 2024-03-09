package com.bigode.testecomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.dto.CartDTO;
import com.bigode.testecomerce.dto.OrderDTO;
import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.service.OrderService;
import com.bigode.testecomerce.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	
	@Autowired
	private OrderService orderService; 
	
	@GetMapping("/orders")
	public ModelAndView ordersByClient(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menu/listOrders");
		
		UserClient client = (UserClient) session.getAttribute("usuarioLogin");
		
		if(client == null) {
			
			mv.setViewName("redirect:/cadastro"); 
			
		} else {
			List<OrderDTO> listOrders = orderService.findOrdersByUserClient(client.getId()); 
			mv.addObject("listaPedidos", listOrders); 
			mv.addObject("msg", "Você ainda não realizou nenhuma compra conosco");
			
			if(listOrders.isEmpty()) {
				mv.addObject("orderCheck", false);
			}else {
				mv.addObject("orderCheck", true);
			}
		} 
		
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
