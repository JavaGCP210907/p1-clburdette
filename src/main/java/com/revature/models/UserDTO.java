package com.revature.models;

public class UserDTO {
	
	private String USER_FIRST_NAME;
	private String USER_LAST_NAME;
	private int USER_ROLE_ID;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String uSER_FIRST_NAME, String uSER_LAST_NAME, int uSER_ROLE_ID) {
		super();
		USER_FIRST_NAME = uSER_FIRST_NAME;
		USER_LAST_NAME = uSER_LAST_NAME;
		USER_ROLE_ID = uSER_ROLE_ID;
	}

	@Override
	public String toString() {
		return "UserDTO [USER_FIRST_NAME=" + USER_FIRST_NAME + ", USER_LAST_NAME=" + USER_LAST_NAME + ", USER_ROLE_ID="
				+ USER_ROLE_ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UserDTO other = (UserDTO) obj;
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

	public int getUSER_ROLE_ID() {
		return USER_ROLE_ID;
	}

	public void setUSER_ROLE_ID(int uSER_ROLE_ID) {
		USER_ROLE_ID = uSER_ROLE_ID;
	}
	
	
	

}
