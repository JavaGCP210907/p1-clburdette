package com.revature.models;

public class reimbUpdateDTO {

	private int REIMB_ID;
	private int REIMB_STATUS_ID;
	private int REIMB_RESOLVER;
	
	public reimbUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reimbUpdateDTO(int rEIMB_ID, int rEIMB_STATUS_ID, int rEIMB_RESOLVER) {
		super();
		REIMB_ID = rEIMB_ID;
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
		REIMB_RESOLVER = rEIMB_RESOLVER;
	}

	@Override
	public String toString() {
		return "reimbUpdateDTO [REIMB_ID=" + REIMB_ID + ", REIMB_STATUS_ID=" + REIMB_STATUS_ID + ", REIMB_RESOLVER="
				+ REIMB_RESOLVER + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + REIMB_ID;
		result = prime * result + REIMB_RESOLVER;
		result = prime * result + REIMB_STATUS_ID;
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
		reimbUpdateDTO other = (reimbUpdateDTO) obj;
		if (REIMB_ID != other.REIMB_ID)
			return false;
		if (REIMB_RESOLVER != other.REIMB_RESOLVER)
			return false;
		if (REIMB_STATUS_ID != other.REIMB_STATUS_ID)
			return false;
		return true;
	}

	public int getREIMB_ID() {
		return REIMB_ID;
	}

	public void setREIMB_ID(int rEIMB_ID) {
		REIMB_ID = rEIMB_ID;
	}

	public int getREIMB_STATUS_ID() {
		return REIMB_STATUS_ID;
	}

	public void setREIMB_STATUS_ID(int rEIMB_STATUS_ID) {
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
	}

	public int getREIMB_RESOLVER() {
		return REIMB_RESOLVER;
	}

	public void setREIMB_RESOLVER(int rEIMB_RESOLVER) {
		REIMB_RESOLVER = rEIMB_RESOLVER;
	}
	
	
	
}
