package com.appsdeveloper.app.ws.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloper.app.ws.io.entity.AddExpenseEntity;
import com.appsdeveloper.app.ws.io.entity.UserEntity;
import com.appsdeveloper.app.ws.repository.ExpenseRepository;
import com.appsdeveloper.app.ws.repository.UserRepository;
import com.appsdeveloper.app.ws.service.ExpenseService;
import com.appsdeveloper.app.ws.shared.dto.AddExpenseDto;
import com.appsdeveloper.app.ws.shared.dto.AmountByMonth;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public void addExpense(AddExpenseDto expenseDto) {
		UserEntity entity = userRepository.findByIsLogin(true);

		AddExpenseEntity expenseEntity = new AddExpenseEntity();
		BeanUtils.copyProperties(expenseDto, expenseEntity);
		entity.setExpense(expenseEntity);

		expenseRepository.save(expenseEntity);
	}

	@Override
	public List<AmountByMonth> dashboard() {

		UserEntity entity = userRepository.findByIsLogin(true);
		int id = entity.getId();
		
		return expenseRepository.getAmount(id);

	}

	@Override
	public JSONObject totExpenditure() {
		JSONObject expenditure = new JSONObject();
		
		UserEntity entity = userRepository.findByIsLogin(true);
		int id = entity.getId();
		
		int amt = expenseRepository.getExpenditure(id);

		expenditure.put("expenditure", new Integer(amt));

		return expenditure;
	}

	@Override
	public List<AddExpenseDto> allExpense() {

		UserEntity entity = userRepository.findByIsLogin(true);

		int id = entity.getId();

		List<AddExpenseDto> returnValue = new ArrayList<>();

		List<AddExpenseEntity> theExpenses = expenseRepository.getAllExpense(id);

		for (AddExpenseEntity dto : theExpenses) {
			AddExpenseDto expense = new AddExpenseDto();
			BeanUtils.copyProperties(dto, expense);
			returnValue.add(expense);
		}

		return returnValue;
	}

	@Override
	public void deleteExpense(int id) {
		
		 expenseRepository.deleteById(id);
	}

}
