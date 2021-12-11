package com.learn.restapi.repository;

import com.learn.restapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
