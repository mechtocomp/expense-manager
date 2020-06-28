package com.appsdeveloper.app.ws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.app.ws.service.ExpenseService;
import com.appsdeveloper.app.ws.service.UserService;
import com.appsdeveloper.app.ws.shared.dto.AddExpenseDto;
import com.appsdeveloper.app.ws.shared.dto.AmountByMonth;
import com.appsdeveloper.app.ws.ui.model.request.AddExpenseRequestModel;
import com.appsdeveloper.app.ws.ui.model.response.AddExpenseResponseModel;
import com.appsdeveloper.app.ws.ui.model.response.AllExpense;

@RestController
@RequestMapping("expense")
public class ExpenseController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ExpenseService expenseService;
	
	@PostMapping("/addexpense")
	public ResponseEntity<Object> addExpense(@RequestBody AddExpenseRequestModel expense)
	{
		AddExpenseDto expenseDto = new AddExpenseDto();
		BeanUtils.copyProperties(expense, expenseDto);
		
		expenseService.addExpense(expenseDto);
		
		AddExpenseResponseModel response = new AddExpenseResponseModel();
		response.setResponse("Expense Added");
		return new ResponseEntity <> (response, HttpStatus.OK);
	}
	
	@GetMapping(path="/dashboard", produces = {"application/json"})
	public ResponseEntity<Object> sendDashboard()
	{
		List<AmountByMonth> amount = expenseService.dashboard();

		return new ResponseEntity<> (amount, HttpStatus.OK); 
	}
	
	
	@GetMapping(path="/expenditure", produces = {"application/json"})
	public ResponseEntity<Object> expenditure()
	{
		JSONObject totAmount = expenseService.totExpenditure();
		
		return new ResponseEntity<> (totAmount, HttpStatus.OK);
	}
	
	
	@GetMapping(path="/allExpense", produces = {"application/json"})
	public ResponseEntity<Object> allExpense()
	{
		List<AllExpense> returnValue = new ArrayList<>();
		
		List<AddExpenseDto> expenseDto = expenseService.allExpense();
		
		for(AddExpenseDto dto : expenseDto)
		{
			AllExpense expense = new AllExpense();
			BeanUtils.copyProperties(dto, expense);
			returnValue.add(expense);
		}
		
		return new ResponseEntity<> (returnValue, HttpStatus.OK); 
	}
	
}
