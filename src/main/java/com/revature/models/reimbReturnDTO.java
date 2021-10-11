package com.revature.models;

import java.sql.Timestamp;

public class reimbReturnDTO {
	
	private int REIMB_ID;
	private double REIMB_AMOUNT;
	private Timestamp REIMB_SUBMITTED;
	private Timestamp REIMB_RESOLVED;
	private String REIMB_DESCRIPTION;
	private String REIMB_AUTHOR;
	private String REIMB_RESOLVER;
	private String REIMB_STATUS_ID;
	private String REIMB_TYPE_ID;
	
	public reimbReturnDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reimbReturnDTO(int rEIMB_ID, double rEIMB_AMOUNT, Timestamp rEIMB_SUBMITTED, Timestamp rEIMB_RESOLVED,
			String rEIMB_DESCRIPTION, String rEIMB_AUTHOR, String rEIMB_RESOLVER, String rEIMB_STATUS_ID,
			String rEIMB_TYPE_ID) {
		super();
		REIMB_ID = rEIMB_ID;
		REIMB_AMOUNT = rEIMB_AMOUNT;
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
		REIMB_RESOLVED = rEIMB_RESOLVED;
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		REIMB_AUTHOR = rEIMB_AUTHOR;
		REIMB_RESOLVER = rEIMB_RESOLVER;
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}

	@Override
	public String toString() {
		return "reimbReturnDTO [REIMB_ID=" + REIMB_ID + ", REIMB_AMOUNT=" + REIMB_AMOUNT + ", REIMB_SUBMITTED="
				+ REIMB_SUBMITTED + ", REIMB_RESOLVED=" + REIMB_RESOLVED + ", REIMB_DESCRIPTION=" + REIMB_DESCRIPTION
				+ ", REIMB_AUTHOR=" + REIMB_AUTHOR + ", REIMB_RESOLVER=" + REIMB_RESOLVER + ", REIMB_STATUS_ID="
				+ REIMB_STATUS_ID + ", REIMB_TYPE_ID=" + REIMB_TYPE_ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(REIMB_AMOUNT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((REIMB_AUTHOR == null) ? 0 : REIMB_AUTHOR.hashCode());
		result = prime * result + ((REIMB_DESCRIPTION == null) ? 0 : REIMB_DESCRIPTION.hashCode());
		result = prime * result + REIMB_ID;
		result = prime * result + ((REIMB_RESOLVED == null) ? 0 : REIMB_RESOLVED.hashCode());
		result = prime * result + ((REIMB_RESOLVER == null) ? 0 : REIMB_RESOLVER.hashCode());
		result = prime * result + ((REIMB_STATUS_ID == null) ? 0 : REIMB_STATUS_ID.hashCode());
		result = prime * result + ((REIMB_SUBMITTED == null) ? 0 : REIMB_SUBMITTED.hashCode());
		result = prime * result + ((REIMB_TYPE_ID == null) ? 0 : REIMB_TYPE_ID.hashCode());
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
		reimbReturnDTO other = (reimbReturnDTO) obj;
		if (Double.doubleToLongBits(REIMB_AMOUNT) != Double.doubleToLongBits(other.REIMB_AMOUNT))
			return false;
		if (REIMB_AUTHOR == null) {
			if (other.REIMB_AUTHOR != null)
				return false;
		} else if (!REIMB_AUTHOR.equals(other.REIMB_AUTHOR))
			return false;
		if (REIMB_DESCRIPTION == null) {
			if (other.REIMB_DESCRIPTION != null)
				return false;
		} else if (!REIMB_DESCRIPTION.equals(other.REIMB_DESCRIPTION))
			return false;
		if (REIMB_ID != other.REIMB_ID)
			return false;
		if (REIMB_RESOLVED == null) {
			if (other.REIMB_RESOLVED != null)
				return false;
		} else if (!REIMB_RESOLVED.equals(other.REIMB_RESOLVED))
			return false;
		if (REIMB_RESOLVER == null) {
			if (other.REIMB_RESOLVER != null)
				return false;
		} else if (!REIMB_RESOLVER.equals(other.REIMB_RESOLVER))
			return false;
		if (REIMB_STATUS_ID == null) {
			if (other.REIMB_STATUS_ID != null)
				return false;
		} else if (!REIMB_STATUS_ID.equals(other.REIMB_STATUS_ID))
			return false;
		if (REIMB_SUBMITTED == null) {
			if (other.REIMB_SUBMITTED != null)
				return false;
		} else if (!REIMB_SUBMITTED.equals(other.REIMB_SUBMITTED))
			return false;
		if (REIMB_TYPE_ID == null) {
			if (other.REIMB_TYPE_ID != null)
				return false;
		} else if (!REIMB_TYPE_ID.equals(other.REIMB_TYPE_ID))
			return false;
		return true;
	}

	public int getREIMB_ID() {
		return REIMB_ID;
	}

	public void setREIMB_ID(int rEIMB_ID) {
		REIMB_ID = rEIMB_ID;
	}

	public double getREIMB_AMOUNT() {
		return REIMB_AMOUNT;
	}

	public void setREIMB_AMOUNT(double rEIMB_AMOUNT) {
		REIMB_AMOUNT = rEIMB_AMOUNT;
	}

	public Timestamp getREIMB_SUBMITTED() {
		return REIMB_SUBMITTED;
	}

	public void setREIMB_SUBMITTED(Timestamp rEIMB_SUBMITTED) {
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
	}

	public Timestamp getREIMB_RESOLVED() {
		return REIMB_RESOLVED;
	}

	public void setREIMB_RESOLVED(Timestamp rEIMB_RESOLVED) {
		REIMB_RESOLVED = rEIMB_RESOLVED;
	}

	public String getREIMB_DESCRIPTION() {
		return REIMB_DESCRIPTION;
	}

	public void setREIMB_DESCRIPTION(String rEIMB_DESCRIPTION) {
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
	}

	public String getREIMB_AUTHOR() {
		return REIMB_AUTHOR;
	}

	public void setREIMB_AUTHOR(String rEIMB_AUTHOR) {
		REIMB_AUTHOR = rEIMB_AUTHOR;
	}

	public String getREIMB_RESOLVER() {
		return REIMB_RESOLVER;
	}

	public void setREIMB_RESOLVER(String rEIMB_RESOLVER) {
		REIMB_RESOLVER = rEIMB_RESOLVER;
	}

	public String getREIMB_STATUS_ID() {
		return REIMB_STATUS_ID;
	}

	public void setREIMB_STATUS_ID(String rEIMB_STATUS_ID) {
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
	}

	public String getREIMB_TYPE_ID() {
		return REIMB_TYPE_ID;
	}

	public void setREIMB_TYPE_ID(String rEIMB_TYPE_ID) {
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}
	
	
}
