package com.appsdeveloper.app.ws.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloper.app.ws.io.entity.UserEntity;
import com.appsdeveloper.app.ws.repository.ExpenseRepository;
import com.appsdeveloper.app.ws.repository.UserRepository;
import com.appsdeveloper.app.ws.service.UserService;
import com.appsdeveloper.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	
	
	@Override
	public UserDto createUser(UserDto user) {
		
		// 1st check whether email is unique 
		if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("user already exists");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		UserEntity userStored = userRepository.save(userEntity);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userStored, returnValue);
		
		return returnValue;
		
	}
	
	

	@Override
	public void authorizeUser(UserDto user) {
		
		UserEntity isUser = userRepository.findByEmail(user.getEmail());
		if(isUser.getEmail()==null) throw new RuntimeException("invalid email");
		if(isUser.getPassword().contentEquals(user.getPassword())) {
		
		UserEntity entity = userRepository.findByEmail(user.getEmail());
		entity.setIsLogin(true);
		userRepository.save(entity);
		}
		else throw new RuntimeException("invalid password");
		
	}
	

	@Override
	public void logoutUser() {
		
		UserEntity entity = userRepository.findByIsLogin(true);
		entity.setIsLogin(false);
		userRepository.save(entity);
	}
}
