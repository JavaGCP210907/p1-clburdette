package com.revature.models;

public class Role {

	private int ERS_USER_ROLE_ID;
	private String USER_ROLE;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String uSER_ROLE) {
		super();
		USER_ROLE = uSER_ROLE;
	}

	public Role(int eRS_USER_ROLE_ID, String uSER_ROLE) {
		super();
		ERS_USER_ROLE_ID = eRS_USER_ROLE_ID;
		USER_ROLE = uSER_ROLE;
	}

	@Override
	public String toString() {
		return "Role [ERS_USER_ROLE_ID=" + ERS_USER_ROLE_ID + ", USER_ROLE=" + USER_ROLE + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ERS_USER_ROLE_ID;
		result = prime * result + ((USER_ROLE == null) ? 0 : USER_ROLE.hashCode());
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
		Role other = (Role) obj;
		if (ERS_USER_ROLE_ID != other.ERS_USER_ROLE_ID)
			return false;
		if (USER_ROLE == null) {
			if (other.USER_ROLE != null)
				return false;
		} else if (!USER_ROLE.equals(other.USER_ROLE))
			return false;
		return true;
	}

	public int getERS_USER_ROLE_ID() {
		return ERS_USER_ROLE_ID;
	}

	public void setERS_USER_ROLE_ID(int eRS_USER_ROLE_ID) {
		ERS_USER_ROLE_ID = eRS_USER_ROLE_ID;
	}

	public String getUSER_ROLE() {
		return USER_ROLE;
	}

	public void setUSER_ROLE(String uSER_ROLE) {
		USER_ROLE = uSER_ROLE;
	}
	
	
}
