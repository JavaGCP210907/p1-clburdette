package com.revature.services;

public class LoginService {

	public boolean login(String username, String password) {
		//temp hardcoded check. replace with real validation of UN and PW
		if(username.equals("admin") && password.equals("admin")) {
			return true;
		}
		
		return false;
		
	}
	
}
