package com.bigode.testecomerce.dto;

import com.bigode.testecomerce.entity.Cart;
import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.entity.enums.CategoryProduct;

public class ProductDTO {
    private Integer id;
    private String name;
    private CategoryProduct categoryProduct;
    private Double price;
    private String info;
    private Cart productsCart; 
    private Order pedido; 

    public ProductDTO() {
    }
    
    

    public ProductDTO(Integer id, String name, CategoryProduct categoryProduct, Double price, String info,
			Cart productsCart, Order pedido) {
		super();
		this.id = id;
		this.name = name;
		this.categoryProduct = categoryProduct;
		this.price = price;
		this.info = info;
		this.productsCart = productsCart;
		this.pedido = pedido;
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



	public Cart getProductsCart() {
		return productsCart;
	}



	public void setProductsCart(Cart productsCart) {
		this.productsCart = productsCart;
	}



	public Order getPedido() {
		return pedido;
	}



	public void setPedido(Order pedido) {
		this.pedido = pedido;
	}

   
}