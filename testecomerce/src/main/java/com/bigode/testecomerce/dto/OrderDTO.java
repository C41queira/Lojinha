	package com.bigode.testecomerce.dto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.entity.enums.CategoryShipping;

public class OrderDTO {
	
    private Integer id;
    private String dateTime;
    private Double totalValue = 0.0;
    private List<Product> listProdutos;
    private UserClient destinatario;
    private CategoryShipping categoryShipping; 
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mma", new Locale("pt", "BR"));

    public OrderDTO() {
    }

    public OrderDTO(Integer id, List<Product> listProdutos, UserClient destinatario) {
        this.id = id;
        this.dateTime = LocalDateTime.now().format(formatter);
        this.categoryShipping = CategoryShipping.ANALISE;
        this.destinatario = destinatario;
        this.listProdutos = listProdutos;
        sumTotalValue(listProdutos);
        
    }
    
    public OrderDTO(Order order) {
    	this.id = order.getId();
    	this.dateTime = order.getDateTime().format(formatter);
        this.destinatario = order.getDestinatario();
        this.listProdutos = order.getListProdutos();
        this.totalValue = order.getTotalValue();
        this.categoryShipping = order.getCategoryShipping();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Product> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(List<Product> listProdutos) {
        this.listProdutos = listProdutos;
    }

    public UserClient getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(UserClient destinatario) {
        this.destinatario = destinatario;
    }
    
	public CategoryShipping getCategoryShipping() {
		return categoryShipping;
	}

	public void setCategoryShipping(CategoryShipping categoryShipping) {
		this.categoryShipping = categoryShipping;
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
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(id, other.id);
	}
	
}