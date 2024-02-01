package com.bigode.testecomerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "cliente")
public class UserClient extends User {
	
	@Column(name = "email")
	@Email
	private String email; 

	@Column(name = "telefone")
	private String phone; 

	@Column(name = "documentação")
	private String document;
	
	
	public UserClient() {
		super();
	}

	public UserClient(Integer id, String name, String senha,String email, String phone, String document) {
		super(id, name, senha);
		this.email = email;
		this.phone = phone;
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	} 
	

}
