package com.bigode.testecomerce.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Carrinho")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Integer id;
	
	@Column(name = "total_price")
	private Double totalValue = 0.0;
	
	@Column(name = "quantity_products")
	private Integer quantityProducts = 0;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proprietario")
	private UserClient proprietario; 
	
	@OneToMany(mappedBy = "productsCart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Product> produtos;

	public Cart() {
		super();
	}

	public Cart(Integer id, Double totalValue, Integer quantityProducts, UserClient clientCarrinho,
			List<Product> produtos) {
		super();
		this.id = id;
		this.quantityProducts = quantityProducts;
		this.proprietario = clientCarrinho;
		this.produtos = produtos;
		sumTotalValue(produtos);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Integer getQuantityProducts() {
		return quantityProducts;
	}

	public void setQuantityProducts(Integer quantityProducts) {
		this.quantityProducts = quantityProducts;
	}

	public UserClient getClientCarrinho() {
		return proprietario;
	}

	public void setClientCarrinho(UserClient clientCarrinho) {
		this.proprietario = clientCarrinho;
	}

	public List<Product> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Product> produtos) {
		this.produtos = produtos;
	}
	
	public void sumTotalValue(List<Product> produtos) {
		
		if(!produtos.isEmpty()|| produtos != null) {
			for(Product product: produtos) {
				this.totalValue += product.getPrice(); 
			} 
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(id, other.id);
	} 
	
	
}
