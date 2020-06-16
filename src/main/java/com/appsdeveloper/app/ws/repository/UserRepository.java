package com.appsdeveloper.app.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsdeveloper.app.ws.io.entity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByEmail(String email);
	UserEntity findByPassword(String password);
	UserEntity findByIsLogin(Boolean login);
	
	
	
}
