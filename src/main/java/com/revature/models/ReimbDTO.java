package com.revature.models;

public class ReimbDTO{
	
	private double REIMB_AMOUNT;
	private String REIMB_DESCRIPTION;
	private int REIMB_AUTHOR;
	private int REIMB_TYPE_ID;
	
	public ReimbDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbDTO(double rEIMB_AMOUNT, String rEIMB_DESCRIPTION, int rEIMB_AUTHOR, int rEIMB_TYPE) {
		super();
		REIMB_AMOUNT = rEIMB_AMOUNT;
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		REIMB_AUTHOR = rEIMB_AUTHOR;
		REIMB_TYPE_ID = rEIMB_TYPE;
	}

	@Override
	public String toString() {
		return "ReimbDTO [REIMB_AMOUNT=" + REIMB_AMOUNT + ", REIMB_DESCRIPTION=" + REIMB_DESCRIPTION + ", REIMB_AUTHOR="
				+ REIMB_AUTHOR + ", REIMB_TYPE=" + REIMB_TYPE_ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(REIMB_AMOUNT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + REIMB_AUTHOR;
		result = prime * result + ((REIMB_DESCRIPTION == null) ? 0 : REIMB_DESCRIPTION.hashCode());
		result = prime * result + REIMB_TYPE_ID;
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
		ReimbDTO other = (ReimbDTO) obj;
		if (Double.doubleToLongBits(REIMB_AMOUNT) != Double.doubleToLongBits(other.REIMB_AMOUNT))
			return false;
		if (REIMB_AUTHOR != other.REIMB_AUTHOR)
			return false;
		if (REIMB_DESCRIPTION == null) {
			if (other.REIMB_DESCRIPTION != null)
				return false;
		} else if (!REIMB_DESCRIPTION.equals(other.REIMB_DESCRIPTION))
			return false;
		if (REIMB_TYPE_ID != other.REIMB_TYPE_ID)
			return false;
		return true;
	}

	public double getREIMB_AMOUNT() {
		return REIMB_AMOUNT;
	}

	public void setREIMB_AMOUNT(double rEIMB_AMOUNT) {
		REIMB_AMOUNT = rEIMB_AMOUNT;
	}

	public String getREIMB_DESCRIPTION() {
		return REIMB_DESCRIPTION;
	}

	public void setREIMB_DESCRIPTION(String rEIMB_DESCRIPTION) {
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
	}

	public int getREIMB_AUTHOR() {
		return REIMB_AUTHOR;
	}

	public void setREIMB_AUTHOR(int rEIMB_AUTHOR) {
		REIMB_AUTHOR = rEIMB_AUTHOR;
	}

	public int getREIMB_TYPE_ID() {
		return REIMB_TYPE_ID;
	}

	public void setREIMB_TYPE_ID(int rEIMB_TYPE) {
		REIMB_TYPE_ID = rEIMB_TYPE;
	}
	

	
	
}