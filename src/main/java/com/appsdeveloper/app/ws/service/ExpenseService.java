package com.appsdeveloper.app.ws.service;

import java.util.List;

import com.appsdeveloper.app.ws.shared.dto.AddExpenseDto;
import com.appsdeveloper.app.ws.shared.dto.AmountByMonth;
import org.json.simple.JSONObject;


public interface ExpenseService  {
	
	void addExpense(AddExpenseDto expenseDto);
	public  List<AmountByMonth> dashboard();
	JSONObject totExpenditure();
	List<AddExpenseDto> allExpense();

}
