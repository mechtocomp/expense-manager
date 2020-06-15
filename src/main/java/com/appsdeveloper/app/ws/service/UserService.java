package com.appsdeveloper.app.ws.service;

import com.appsdeveloper.app.ws.shared.dto.AddExpenseDto;
import com.appsdeveloper.app.ws.shared.dto.DashboardDto;
import com.appsdeveloper.app.ws.shared.dto.UserDto;

public interface UserService  {
	
	UserDto createUser(UserDto user);
	void authorizeUser(UserDto user);
	
	void addExpense(AddExpenseDto expenseDto);
	DashboardDto dashboard();

}
