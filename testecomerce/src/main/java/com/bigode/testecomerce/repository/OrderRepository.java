package com.bigode.testecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bigode.testecomerce.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query("SELECT i FROM Order i WHERE i.destinatario.id = :userId")
    public List<Order> findOrdersByUserId(int userId); 
}
