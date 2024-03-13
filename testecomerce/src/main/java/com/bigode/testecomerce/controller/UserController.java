package com.bigode.testecomerce.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bigode.testecomerce.entity.User;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.exceptions.EmailExistException;
import com.bigode.testecomerce.exceptions.ServiceExcp;
import com.bigode.testecomerce.service.UserService;
import com.bigode.testecomerce.util.Util;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
		mv.addObject("msgLogin");
		mv.addObject("msgCadastro");
		return mv; 
	}
	
	@PostMapping("/salvarClient")
	public ModelAndView cadastrar(@Valid UserClient client, BindingResult br, RedirectAttributes redirectAttributes) 
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			mv.setViewName("redirect:/cadastro");
			redirectAttributes.addFlashAttribute("msgCadastro", br.getFieldError().getDefaultMessage());
		}else {
			try {
				service.saveClient(client);
				mv.setViewName("redirect:/");
			}catch (EmailExistException e) {
				redirectAttributes.addFlashAttribute("msgCadastro", e.getMessage());
				mv.setViewName("redirect:/cadastro");
			}
		}
		
		
		
		return mv;
	}
	
	@PostMapping("/singIn")
	public ModelAndView login(@Valid User user, BindingResult br, HttpSession session, RedirectAttributes redirectAttributes) 
			throws ServiceExcp, NoSuchAlgorithmException{
		
		ModelAndView mv = new ModelAndView(); 
		
		if(br.hasErrors()) {
			mv.setViewName("login/cadastro");
		}
		
		User userLogin = service.loginUser(user.getName(), Util.md5(user.getSenha()));
		
		if(userLogin == null) {
			redirectAttributes.addFlashAttribute("msgLogin", "Usuario não encontrado. Tente novamente"); 
			mv.setViewName("redirect:/cadastro");
		}else {
			session.setAttribute("usuarioLogin", userLogin);
			mv.setViewName("redirect:/");	
		}
		

		return mv; 
	}

}
