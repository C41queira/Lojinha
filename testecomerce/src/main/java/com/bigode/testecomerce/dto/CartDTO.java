package com.bigode.testecomerce.dto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import com.bigode.testecomerce.entity.Cart;
import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.UserClient;

public class CartDTO {
	
	private Integer id;
    private Double totalValue = 0.0;
    private Integer quantityProducts = 0;
    private UserClient clientCarrinho;
    private List<Product> produtos;

    public CartDTO() {}

    public CartDTO(Cart cart) {
        this.id = cart.getId();
        this.totalValue = cart.getTotalValue();
        this.quantityProducts = cart.getQuantityProducts();
        this.clientCarrinho = cart.getClientCarrinho();
        this.produtos = cart.getProdutos();
    }
    
    

    public CartDTO(Integer id, UserClient clientCarrinho, List<Product> produtos) {
		super();
		this.id = id;
		this.clientCarrinho = clientCarrinho;
		this.produtos = produtos;
		if(!produtos.isEmpty()) {
			sumTotalValue(produtos);
			this.quantityProducts = produtos.size();
		}
		
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
        return clientCarrinho;
    }

    public void setClientCarrinho(UserClient clientCarrinho) {
        this.clientCarrinho = clientCarrinho;
    }

    public List<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Product> produtos) {
    	this.totalValue = 0.0;
    	sumTotalValue(produtos);
    	this.quantityProducts = produtos.size();
        this.produtos = produtos;
    }
    
    public void sumTotalValue(List<Product> produtos) {
		
    	DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(new Locale("en", "US")));
    	Double valor = 0.0;
    	
		if(!produtos.isEmpty()|| produtos != null) {
			for(Product product: produtos) {
				valor += product.getPrice(); 
			} 
		}
		
		this.totalValue += Double.parseDouble(df.format(valor));
	}
}
