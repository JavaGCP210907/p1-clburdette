package com.revature.models;

public class User {
	
	private int ERS_USERS_ID;
	private String ERS_USERNAME;
	private String ERS_PASSWORD;
	private String USER_FIRST_NAME;
	private String USER_LAST_NAME;
	private String USER_EMAIL;
	private int USER_ROLE_ID;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String eRS_USERNAME, String eRS_PASSWORD, String uSER_FIRST_NAME, String uSER_LAST_NAME,
			String uSER_EMAIL, int uSER_ROLE_ID) {
		super();
		ERS_USERNAME = eRS_USERNAME;
		ERS_PASSWORD = eRS_PASSWORD;
		USER_FIRST_NAME = uSER_FIRST_NAME;
		USER_LAST_NAME = uSER_LAST_NAME;
		USER_EMAIL = uSER_EMAIL;
		USER_ROLE_ID = uSER_ROLE_ID;
	}

	public User(int eRS_USERS_ID, String eRS_USERNAME, String eRS_PASSWORD, String uSER_FIRST_NAME,
			String uSER_LAST_NAME, String uSER_EMAIL, int uSER_ROLE_ID) {
		super();
		ERS_USERS_ID = eRS_USERS_ID;
		ERS_USERNAME = eRS_USERNAME;
		ERS_PASSWORD = eRS_PASSWORD;
		USER_FIRST_NAME = uSER_FIRST_NAME;
		USER_LAST_NAME = uSER_LAST_NAME;
		USER_EMAIL = uSER_EMAIL;
		USER_ROLE_ID = uSER_ROLE_ID;
	}

	@Override
	public String toString() {
		return "User [ERS_USERS_ID=" + ERS_USERS_ID + ", ERS_USERNAME=" + ERS_USERNAME + ", ERS_PASSWORD="
				+ ERS_PASSWORD + ", USER_FIRST_NAME=" + USER_FIRST_NAME + ", USER_LAST_NAME=" + USER_LAST_NAME
				+ ", USER_EMAIL=" + USER_EMAIL + ", USER_ROLE_ID=" + USER_ROLE_ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ERS_PASSWORD == null) ? 0 : ERS_PASSWORD.hashCode());
		result = prime * result + ((ERS_USERNAME == null) ? 0 : ERS_USERNAME.hashCode());
		result = prime * result + ERS_USERS_ID;
		result = prime * result + ((USER_EMAIL == null) ? 0 : USER_EMAIL.hashCode());
		result = prime * result + ((USER_FIRST_NAME == null) ? 0 : USER_FIRST_NAME.hashCode());
		result = prime * result + ((USER_LAST_NAME == null) ? 0 : USER_LAST_NAME.hashCode());
		result = prime * result + USER_ROLE_ID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ERS_PASSWORD == null) {
			if (other.ERS_PASSWORD != null)
				return false;
		} else if (!ERS_PASSWORD.equals(other.ERS_PASSWORD))
			return false;
		if (ERS_USERNAME == null) {
			if (other.ERS_USERNAME != null)
				return false;
		} else if (!ERS_USERNAME.equals(other.ERS_USERNAME))
			return false;
		if (ERS_USERS_ID != other.ERS_USERS_ID)
			return false;
		if (USER_EMAIL == null) {
			if (other.USER_EMAIL != null)
				return false;
		} else if (!USER_EMAIL.equals(other.USER_EMAIL))
			return false;
		if (USER_FIRST_NAME == null) {
			if (other.USER_FIRST_NAME != null)
				return false;
		} else if (!USER_FIRST_NAME.equals(other.USER_FIRST_NAME))
			return false;
		if (USER_LAST_NAME == null) {
			if (other.USER_LAST_NAME != null)
				return false;
		} else if (!USER_LAST_NAME.equals(other.USER_LAST_NAME))
			return false;
		if (USER_ROLE_ID != other.USER_ROLE_ID)
			return false;
		return true;
	}

	public int getERS_USERS_ID() {
		return ERS_USERS_ID;
	}

	public void setERS_USERS_ID(int eRS_USERS_ID) {
		ERS_USERS_ID = eRS_USERS_ID;
	}

	public String getERS_USERNAME() {
		return ERS_USERNAME;
	}

	public void setERS_USERNAME(String eRS_USERNAME) {
		ERS_USERNAME = eRS_USERNAME;
	}

	public String getERS_PASSWORD() {
		return ERS_PASSWORD;
	}

	public void setERS_PASSWORD(String eRS_PASSWORD) {
		ERS_PASSWORD = eRS_PASSWORD;
	}

	public String getUSER_FIRST_NAME() {
		return USER_FIRST_NAME;
	}

	public void setUSER_FIRST_NAME(String uSER_FIRST_NAME) {
		USER_FIRST_NAME = uSER_FIRST_NAME;
	}

	public String getUSER_LAST_NAME() {
		return USER_LAST_NAME;
	}

	public void setUSER_LAST_NAME(String uSER_LAST_NAME) {
		USER_LAST_NAME = uSER_LAST_NAME;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public int getUSER_ROLE_ID() {
		return USER_ROLE_ID;
	}

	public void setUSER_ROLE_ID(int uSER_ROLE_ID) {
		USER_ROLE_ID = uSER_ROLE_ID;
	}
	
	

}
