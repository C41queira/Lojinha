package com.bigode.testecomerce.dto;

import java.util.List;

import com.bigode.testecomerce.entity.Cart;
import com.bigode.testecomerce.entity.Order;
import com.bigode.testecomerce.entity.UserClient;

public class UserClientDTO{
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String document;
    private List<Order> orders;
    private Cart carrinho;

    public UserClientDTO() {
    }

    public UserClientDTO(UserClient user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getSenha();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.document = user.getDocument();
        this.orders = user.getOrders();
        this.carrinho = user.getCarrinho();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Cart carrinho) {
        this.carrinho = carrinho;
    }
}