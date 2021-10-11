package com.revature.daos;

import com.revature.models.LoginDTO;
import com.revature.models.User;

public interface UserInterface {
	
	public User getUserByID(int id);
	public User getUserByUserName(String ERS_USERNAME);
	public User getUserByNameAndPassword(LoginDTO LDTO);

}
