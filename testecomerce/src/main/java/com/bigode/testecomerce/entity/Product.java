package com.bigode.testecomerce.entity;

import java.util.Objects;

import com.bigode.testecomerce.entity.enums.CategoryProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	private Integer id;
	
	@Column(name = "productName")
	private String name; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoryProduct")
	private CategoryProduct categoryProduct;
	
	@Column(name = "price")
	private Double price; 
	
	@Column(name = "info")
	private String info;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
	private Cart productsCart; 
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
	private Order pedido; 
	
	
	public Product() {
	}

	public Product(Integer id, String name, CategoryProduct categoryProduct, Double price,
			String info) {
		super();
		this.id = id;
		this.name = name;
		this.categoryProduct = categoryProduct;
		this.price = price;
		this.info = info;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryProduct getCategotyProduct() {
		return categoryProduct;
	}
	public void setCategotyProduct(CategoryProduct categotyProduct) {
		this.categoryProduct = categotyProduct;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public CategoryProduct getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoryProduct categoryProduct) {
		this.categoryProduct = categoryProduct;
	}
	
	public Cart getCart() {
		return productsCart;
	}

	public void setCart(Cart cart) {
		this.productsCart = cart;
	}

	public Order getPedido() {
		return pedido;
	}

	public void setPedido(Order pedido) {
		this.pedido = pedido;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	} 
	
	

}
