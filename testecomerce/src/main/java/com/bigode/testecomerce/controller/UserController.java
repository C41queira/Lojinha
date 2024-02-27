package com.bigode.testecomerce.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigode.testecomerce.entity.User;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.exceptions.ServiceExcp;
import com.bigode.testecomerce.service.UserService;
import com.bigode.testecomerce.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService service; 
	
	@GetMapping(value = "/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("login/cadastro");
		mv.addObject("newClient", new UserClient()); 
		mv.addObject("loginUser", new User());
		return mv; 
	}
	
	@PostMapping("/salvarClient")
	public ModelAndView cadastrar(UserClient client) throws Exception {
		ModelAndView mv = new ModelAndView(); 
		service.saveClient(client);
		mv.setViewName("redirect:/");
		return mv;
		
	}
	
	@PostMapping("/singIn")
	public ModelAndView login(User user, BindingResult br, HttpSession session) throws ServiceExcp, NoSuchAlgorithmException{
		
		ModelAndView mv = new ModelAndView(); 
		
		if(br.hasErrors()) {
			mv.setViewName("login/cadastro");
		}
		
		User userLogin = service.loginUser(user.getName(), Util.md5(user.getSenha()));
		
		if(userLogin == null) {
			mv.addObject("msg", "Usuario não encontrado. Tente novamente"); 
		}else {
			session.setAttribute("usuarioLogin", userLogin);
			mv.setViewName("redirect:/carrinho");	
		}
		
		return mv; 
	}

}
