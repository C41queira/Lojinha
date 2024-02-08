package com.bigode.testecomerce.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	
	@ManyToMany
	@JoinTable(name = "produtos_comprados", joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Product> carrinho; 
	
	
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

	public List<Product> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Product> carrinho) {
		this.carrinho = carrinho;
	} 
	
	
	
	@Override
	public String toString() {
		return "User: name = " + getName() + "compras= " + getCarrinho();
	}
	
}