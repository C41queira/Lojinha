package com.bigode.testecomerce.entity;

import java.util.List;
import java.util.Objects;

import com.bigode.testecomerce.entity.enums.CategoryProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

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
	
	@Column(name = "quantity")
	private Integer quantity; 
	
	@Column(name = "info")
	private String info;
	
	@ManyToMany(mappedBy = "carrinho")
	private List<UserClient> userClient; 
	
	
	public Product() {
	}

	public Product(Integer id, String name, CategoryProduct categoryProduct, Double price, Integer quantity,
			String info) {
		super();
		this.id = id;
		this.name = name;
		this.categoryProduct = categoryProduct;
		this.price = price;
		this.quantity = quantity;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public List<UserClient> getUserClient() {
		return userClient;
	}

	public void setUserClient(List<UserClient> userClient) {
		this.userClient = userClient;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	} 
	
	

}
