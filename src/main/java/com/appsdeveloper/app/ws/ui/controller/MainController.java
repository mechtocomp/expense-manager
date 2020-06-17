package com.appsdeveloper.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.app.ws.service.UserService;
import com.appsdeveloper.app.ws.shared.dto.AddExpenseDto;
import com.appsdeveloper.app.ws.shared.dto.DashboardDto;
import com.appsdeveloper.app.ws.shared.dto.UserDto;
import com.appsdeveloper.app.ws.ui.model.request.AddExpenseRequestModel;
import com.appsdeveloper.app.ws.ui.model.request.AuthorizeUser;
import com.appsdeveloper.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloper.app.ws.ui.model.response.AddExpenseResponseModel;
import com.appsdeveloper.app.ws.ui.model.response.MonthlyExpenseResponse;
import com.appsdeveloper.app.ws.ui.model.response.UserResponse;

@RestController
@RequestMapping("user")
public class MainController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserDetailsRequestModel user)
	{
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		
		UserDto returnValue =  userService.createUser(userDto);
		
		UserResponse response = new UserResponse();
		BeanUtils.copyProperties(returnValue,response);
		
		return response;
	}
	
	@PostMapping("/login")
	public HttpStatus authorize(@RequestBody AuthorizeUser user)
	{
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		
		userService.authorizeUser(userDto);
		
		return HttpStatus.OK;
	}
	
	@PostMapping("/addexpense")
	public ResponseEntity<Object> addExpense(@RequestBody AddExpenseRequestModel expense)
	{
		AddExpenseDto expenseDto = new AddExpenseDto();
		BeanUtils.copyProperties(expense, expenseDto);
		
		userService.addExpense(expenseDto);
		
		AddExpenseResponseModel response = new AddExpenseResponseModel();
		response.setResponse("Expense Added");
		return new ResponseEntity <> (response, HttpStatus.OK);
	}
	
	@GetMapping("/dashboard")
	public ResponseEntity<Object> sendDashboard()
	{
		DashboardDto dto = userService.dashboard();
		MonthlyExpenseResponse response = new MonthlyExpenseResponse();
		
		BeanUtils.copyProperties(dto, response);
		
		return new ResponseEntity<> (response, HttpStatus.OK); 
	}
	

}
