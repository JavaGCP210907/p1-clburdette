package com.revature.daos;

import com.revature.models.User;

public interface UserInterface {
	
	public User getUserByID(int id);
	public User getUserByUserName(String ERS_USERNAME);

}