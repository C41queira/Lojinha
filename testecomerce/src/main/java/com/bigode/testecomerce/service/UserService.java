package com.bigode.testecomerce.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigode.testecomerce.entity.User;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.exceptions.CriptografiaException;
import com.bigode.testecomerce.exceptions.EmailExistException;
import com.bigode.testecomerce.exceptions.ServiceExcp;
import com.bigode.testecomerce.repository.UserClientRepository;
import com.bigode.testecomerce.repository.UserRepository;
import com.bigode.testecomerce.util.Util;

@Service
public class UserService {
	
	@Autowired
	private UserClientRepository repositoryClient;
	
	@Autowired
	private UserRepository repository;

	
	public void saveClient(UserClient client) throws Exception{
		
		try {
			if (repositoryClient.findByEmail(client.getEmail()) != null) {
				
				throw new EmailExistException(client.getEmail() + " já está cadstrado no nosso sistema"); 
			}
			
			client.setSenha(Util.md5(client.getSenha()));
			
			repositoryClient.save(client);
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new CriptografiaException("Erro na cripitografia da senha"); 
		}
		 
	}
	
	public void saveAll(List<User> listUser) throws Exception{
		for (User client : listUser) {
			client.setSenha(Util.md5(client.getSenha()));
		}
		
		repository.saveAll(listUser);
 
	}

	
	
	public User loginUser(String name, String senha) throws ServiceExcp{
		User userLogin = repository.loginUser(name, senha); 
		return userLogin; 
	}
	
	
	public UserClient findByIdWithCarrinho(Integer id) {
		UserClient user = repositoryClient.findByIdWithCarrinho(id); 
		return user; 
	}
}
