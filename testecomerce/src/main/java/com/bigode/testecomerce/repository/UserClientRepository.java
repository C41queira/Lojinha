package com.bigode.testecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bigode.testecomerce.entity.UserClient;

public interface UserClientRepository extends JpaRepository<UserClient, Integer>{
	
	@Query("select c from UserClient c where c.email = :email")
	public UserClient findByEmail(String email);

}
