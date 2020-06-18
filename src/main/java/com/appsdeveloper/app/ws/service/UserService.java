package com.appsdeveloper.app.ws.service;

import java.util.List;

import com.appsdeveloper.app.ws.shared.dto.AddExpenseDto;
import com.appsdeveloper.app.ws.shared.dto.AmountByMonth;
import com.appsdeveloper.app.ws.shared.dto.UserDto;

public interface UserService  {
	
	UserDto createUser(UserDto user);
	void authorizeUser(UserDto user);
	
	void addExpense(AddExpenseDto expenseDto);
	public  List<AmountByMonth> dashboard();

}
