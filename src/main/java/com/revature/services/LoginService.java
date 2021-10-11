package com.revature.services;

import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {
	UserService us = new UserService();
	
	public User getUserByLogin(LoginDTO LDTO) {
		//TODO add user name and password validation 
		User user = us.checkUserForLogin(LDTO);

		return user;
	}
	
}
