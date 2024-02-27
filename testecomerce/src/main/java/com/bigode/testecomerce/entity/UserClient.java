package com.bigode.testecomerce.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@DiscriminatorValue(value = "cliente")
@Table(name = "cliente")
public class UserClient extends User {
	
	@Column(name = "email")
	@Email
	private String email; 

	@Column(name = "telefone")
	private String phone; 

	@Column(name = "documentação")
	private String document;
	
	@OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders;
	
	@OneToOne(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart carrinho; 
	
	
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

	public Cart getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Cart carrinho) {
		this.carrinho = carrinho;
	} 
	
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User: name = " + getName() + "compras= " + getCarrinho();
	}
	
}
