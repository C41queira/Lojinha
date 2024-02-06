package com.bigode.testecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bigode.testecomerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query("select o from User o where o.name= :name and o.senha= :senha")
	public User loginUser(String name, String senha);
}
