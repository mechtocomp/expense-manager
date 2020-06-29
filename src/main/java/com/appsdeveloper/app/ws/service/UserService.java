package com.appsdeveloper.app.ws.service;

import org.json.simple.JSONObject;

import com.appsdeveloper.app.ws.shared.dto.UserDto;


public interface UserService  {
	
	UserDto createUser(UserDto user);
	JSONObject authorizeUser(UserDto user);
	void logoutUser();
	
	

}
