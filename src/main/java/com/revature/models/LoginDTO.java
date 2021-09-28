package com.revature.models;

public class LoginDTO {

	private String username;
	private String password;
	
	
	//then I just want two constructors so we can instantiate this class when needed
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//and then getters/setters to access our fields
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
