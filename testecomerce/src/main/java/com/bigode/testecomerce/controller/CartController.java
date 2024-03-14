package com.bigode.testecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.dto.CartDTO;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	private CartService service; 
	
	@GetMapping("/carrinho")
	public ModelAndView pageCarrinho(HttpSession session) {
		ModelAndView mv = new ModelAndView(); 
		
		UserClient client = (UserClient) session.getAttribute("usuarioLogin");
		
		mv.setViewName("pages/carrinho");
		
		if(client == null) {
			
			mv.setViewName("redirect:/cadastro"); 
			
		} else {
			CartDTO cart = service.findCartByUserClient(client.getId());
			mv.addObject("cart", cart);
			mv.addObject("msg", "Sem produtos no momento");
			
			if(cart.getProdutos().isEmpty()) {
				mv.addObject("cartCheck", false);
			}else {
				mv.addObject("cartCheck", true);
			}
		} 
		
		return mv; 
	}
	
	@PostMapping("/removeProduct/{productId}")
	public String removeCart(HttpSession session, @PathVariable Integer productId) {
		
		UserClient client = (UserClient) session.getAttribute("usuarioLogin");
		
		service.removeProductOnCart(client.getId(), productId);
		
		return "redirect:/carrinho";
	}
	

	@PostMapping("/addOnCart/{productId}")
	public ModelAndView addOnCart(HttpSession session, @PathVariable Integer productId) {
		ModelAndView mv = new ModelAndView(); 
		UserClient client = (UserClient) session.getAttribute("usuarioLogin");
		
		if(client != null) {
			service.addOnCart(client.getId(), productId);
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/cadastro");
		}
		
		return mv; 
	}
	
	@PostMapping("/addAndGoCart/{productId}")
	public ModelAndView addAndGoCart(HttpSession session, @PathVariable Integer productId) {
		ModelAndView mv = new ModelAndView(); 
		UserClient client = (UserClient) session.getAttribute("usuarioLogin");
		
		if(client != null) {
			service.addOnCart(client.getId(), productId);
			mv.setViewName("redirect:/carrinho");
		}else {
			mv.setViewName("redirect:/cadastro");
		}
		
		return mv; 
	}
}
