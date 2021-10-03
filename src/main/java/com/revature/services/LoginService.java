package com.revature.services;

import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {

	public User getUserByLogin(LoginDTO LDTO) {
		UserService us = new UserService();
		User user = us.checkUserForLogin(LDTO);
		return user;
	}
	
}
