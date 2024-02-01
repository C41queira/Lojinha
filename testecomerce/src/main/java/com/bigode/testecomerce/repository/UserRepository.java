package com.bigode.testecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigode.testecomerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
