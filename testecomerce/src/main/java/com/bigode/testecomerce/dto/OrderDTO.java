	package com.bigode.testecomerce.dto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.UserClient;

public class OrderDTO {
	
    private Integer id;
    private String dateTime;
    private Double totalValue = 0.0;
    private List<Product> listProdutos;
    private UserClient destinatario;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy h:mma", new Locale("pt", "BR"));

    public OrderDTO() {
    }

    public OrderDTO(Integer id, List<Product> listProdutos, UserClient destinatario) {
        this.id = id;
        this.dateTime = LocalDateTime.now().format(formatter);
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