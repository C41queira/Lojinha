package com.bigode.testecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bigode.testecomerce.entity.UserClient;

public interface UserClientRepository extends JpaRepository<UserClient, Integer>{
	
	@Query("select c from UserClient c where c.email = :email")
	public UserClient findByEmail(String email);

}
