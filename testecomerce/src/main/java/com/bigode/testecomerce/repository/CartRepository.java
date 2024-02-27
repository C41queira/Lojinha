package com.bigode.testecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bigode.testecomerce.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query("SELECT c FROM Cart c WHERE c.proprietario.id = :userId")
	Cart findCartByUserId(int userId);
}
