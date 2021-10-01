package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class UserService {

	UserDao uDao = new UserDao();
	
	public String getClientUserIdentifier(String userName) {
		User user = uDao.getUserByUserName(userName);
		return user.toString();
	}
}