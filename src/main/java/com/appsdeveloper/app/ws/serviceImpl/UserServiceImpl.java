package com.appsdeveloper.app.ws.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloper.app.ws.io.entity.AddExpenseEntity;
import com.appsdeveloper.app.ws.io.entity.UserEntity;
import com.appsdeveloper.app.ws.repository.ExpenseRepository;
import com.appsdeveloper.app.ws.repository.UserRepository;
import com.appsdeveloper.app.ws.service.UserService;
import com.appsdeveloper.app.ws.shared.dto.AddExpenseDto;
import com.appsdeveloper.app.ws.shared.dto.DashboardDto;
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
		
		if(userRepository.findByEmail(user.getEmail())==null) throw new RuntimeException("invalid email");
		if(userRepository.findByPassword(user.getPassword())==null) throw new RuntimeException("invalid password");
		
		UserEntity entity = userRepository.findByEmail(user.getEmail());
		entity.setIsLogin(true);
		userRepository.save(entity);
		
		
	}

	@Override
	public void addExpense(AddExpenseDto expenseDto) {
		UserEntity entity = userRepository.findByIsLogin(true);
		
		AddExpenseEntity expenseEntity = new AddExpenseEntity();
		BeanUtils.copyProperties(expenseDto, expenseEntity);
		entity.setExpense(expenseEntity);
		AddExpenseEntity addedExpense= expenseRepository.save(expenseEntity);
		
	}

	@Override
	public DashboardDto dashboard() {
		
		long janSum = expenseRepository.janExpense();
		long febSum = expenseRepository.febExpense();
		long marSum = expenseRepository.marExpense();
		long aprSum = expenseRepository.aprExpense();
		long maySum = expenseRepository.mayExpense();
		long junSum = expenseRepository.junExpense();
		long julySum = expenseRepository.julyExpense();
		long augSum = expenseRepository.augExpense();
		long sepSum = expenseRepository.sepExpense();
		long octSum = expenseRepository.octExpense();
		long novSum = expenseRepository.novExpense();
		long decSum = expenseRepository.decExpense();
		
		DashboardDto dto = new DashboardDto();
		
		dto.setJAN(janSum);
		dto.setFEB(febSum);
		dto.setMAR(marSum);
		dto.setAPR(aprSum);
		dto.setMAY(maySum);
		dto.setJUN(junSum);
		dto.setJULY(julySum);
		dto.setAUG(augSum);
		dto.setSEP(sepSum);
		dto.setOCT(octSum);
		dto.setNOV(novSum);
		dto.setDEC(decSum);
		
		return dto;
		
	}

}
