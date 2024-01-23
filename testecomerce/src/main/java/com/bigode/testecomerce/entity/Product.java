package com.bigode.testecomerce.entity;

import java.util.Objects;

import com.bigode.testecomerce.entity.enums.CategoryProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private CategoryProject categoryProduct;
	
	@Column(name = "price")
	private Double price; 
	
	@Column(name = "info")
	private String info;
	
	
	public Product() {
	}
	
	public Product(Integer id, String name, CategoryProject categotyProduct, Double price, String info) {
		this.id = id;
		this.name = name;
		this.categoryProduct = categotyProduct;
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
	public CategoryProject getCategotyProduct() {
		return categoryProduct;
	}
	public void setCategotyProduct(CategoryProject categotyProduct) {
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
