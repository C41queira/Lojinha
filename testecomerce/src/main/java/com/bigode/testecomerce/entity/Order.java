package com.bigode.testecomerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.bigode.testecomerce.entity.enums.CategoryShipping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer id;
	
	@Column(name = "order_date")
	private LocalDateTime dateTime;
	
	@Column(name = "order_price")
	private Double totalValue = 0.0; 
	
	@Enumerated
	@Column(name="status_entrega")
	private CategoryShipping categoryShipping; 
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> listProdutos;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_order_id")
	private UserClient destinatario;

	public Order() {
		super();
	}

	public Order(Integer id, List<Product> listProdutos, UserClient destinatario, Double totalValue, 
			LocalDateTime dateTime, CategoryShipping categoryShipping) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.destinatario = destinatario;
		this.totalValue = totalValue; 
		this.listProdutos = listProdutos;
		this.categoryShipping = categoryShipping; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
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
		this.listProdutos = new ArrayList<Product>(listProdutos);
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	} 
	
	
}
