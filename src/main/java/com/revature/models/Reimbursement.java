package com.revature.models;

import java.util.Date;

public class Reimbursement {
	
	private int REIMB_ID;
	private double REIMB_AMOUNT;
	private Date REIMB_SUBMITTED;
	private Date REIMB_RESOLVED;
	private String REIMB_DESCRIPTION;
	private String REIMB_RECEIPT;
	private int REIMB_AUHTOR;
	private int REIMB_RESOLVER;
	private int REIMB_STATUS_ID;
	private int REIMB_TYPE_ID;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(double rEIMB_AMOUNT, Date rEIMB_SUBMITTED, Date rEIMB_RESOLVED, String rEIMB_DESCRIPTION,
			String rEIMB_RECEIPT, int rEIMB_AUHTOR, int rEIMB_RESOLVER, int rEIMB_STATUS_ID, int rEIMB_TYPE_ID) {
		super();
		REIMB_AMOUNT = rEIMB_AMOUNT;
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
		REIMB_RESOLVED = rEIMB_RESOLVED;
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		REIMB_RECEIPT = rEIMB_RECEIPT;
		REIMB_AUHTOR = rEIMB_AUHTOR;
		REIMB_RESOLVER = rEIMB_RESOLVER;
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}

	public Reimbursement(int rEIMB_ID, double rEIMB_AMOUNT, Date rEIMB_SUBMITTED, Date rEIMB_RESOLVED,
			String rEIMB_DESCRIPTION, String rEIMB_RECEIPT, int rEIMB_AUHTOR, int rEIMB_RESOLVER, int rEIMB_STATUS_ID,
			int rEIMB_TYPE_ID) {
		super();
		REIMB_ID = rEIMB_ID;
		REIMB_AMOUNT = rEIMB_AMOUNT;
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
		REIMB_RESOLVED = rEIMB_RESOLVED;
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		REIMB_RECEIPT = rEIMB_RECEIPT;
		REIMB_AUHTOR = rEIMB_AUHTOR;
		REIMB_RESOLVER = rEIMB_RESOLVER;
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}

	@Override
	public String toString() {
		return "Reimbursement [REIMB_ID=" + REIMB_ID + ", REIMB_AMOUNT=" + REIMB_AMOUNT + ", REIMB_SUBMITTED="
				+ REIMB_SUBMITTED + ", REIMB_RESOLVED=" + REIMB_RESOLVED + ", REIMB_DESCRIPTION=" + REIMB_DESCRIPTION
				+ ", REIMB_RECEIPT=" + REIMB_RECEIPT + ", REIMB_AUHTOR=" + REIMB_AUHTOR + ", REIMB_RESOLVER="
				+ REIMB_RESOLVER + ", REIMB_STATUS_ID=" + REIMB_STATUS_ID + ", REIMB_TYPE_ID=" + REIMB_TYPE_ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(REIMB_AMOUNT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + REIMB_AUHTOR;
		result = prime * result + ((REIMB_DESCRIPTION == null) ? 0 : REIMB_DESCRIPTION.hashCode());
		result = prime * result + REIMB_ID;
		result = prime * result + ((REIMB_RECEIPT == null) ? 0 : REIMB_RECEIPT.hashCode());
		result = prime * result + ((REIMB_RESOLVED == null) ? 0 : REIMB_RESOLVED.hashCode());
		result = prime * result + REIMB_RESOLVER;
		result = prime * result + REIMB_STATUS_ID;
		result = prime * result + ((REIMB_SUBMITTED == null) ? 0 : REIMB_SUBMITTED.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(REIMB_AMOUNT) != Double.doubleToLongBits(other.REIMB_AMOUNT))
			return false;
		if (REIMB_AUHTOR != other.REIMB_AUHTOR)
			return false;
		if (REIMB_DESCRIPTION == null) {
			if (other.REIMB_DESCRIPTION != null)
				return false;
		} else if (!REIMB_DESCRIPTION.equals(other.REIMB_DESCRIPTION))
			return false;
		if (REIMB_ID != other.REIMB_ID)
			return false;
		if (REIMB_RECEIPT == null) {
			if (other.REIMB_RECEIPT != null)
				return false;
		} else if (!REIMB_RECEIPT.equals(other.REIMB_RECEIPT))
			return false;
		if (REIMB_RESOLVED == null) {
			if (other.REIMB_RESOLVED != null)
				return false;
		} else if (!REIMB_RESOLVED.equals(other.REIMB_RESOLVED))
			return false;
		if (REIMB_RESOLVER != other.REIMB_RESOLVER)
			return false;
		if (REIMB_STATUS_ID != other.REIMB_STATUS_ID)
			return false;
		if (REIMB_SUBMITTED == null) {
			if (other.REIMB_SUBMITTED != null)
				return false;
		} else if (!REIMB_SUBMITTED.equals(other.REIMB_SUBMITTED))
			return false;
		if (REIMB_TYPE_ID != other.REIMB_TYPE_ID)
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

	public Date getREIMB_SUBMITTED() {
		return REIMB_SUBMITTED;
	}

	public void setREIMB_SUBMITTED(Date rEIMB_SUBMITTED) {
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
	}

	public Date getREIMB_RESOLVED() {
		return REIMB_RESOLVED;
	}

	public void setREIMB_RESOLVED(Date rEIMB_RESOLVED) {
		REIMB_RESOLVED = rEIMB_RESOLVED;
	}

	public String getREIMB_DESCRIPTION() {
		return REIMB_DESCRIPTION;
	}

	public void setREIMB_DESCRIPTION(String rEIMB_DESCRIPTION) {
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
	}

	public String getREIMB_RECEIPT() {
		return REIMB_RECEIPT;
	}

	public void setREIMB_RECEIPT(String rEIMB_RECEIPT) {
		REIMB_RECEIPT = rEIMB_RECEIPT;
	}

	public int getREIMB_AUHTOR() {
		return REIMB_AUHTOR;
	}

	public void setREIMB_AUHTOR(int rEIMB_AUHTOR) {
		REIMB_AUHTOR = rEIMB_AUHTOR;
	}

	public int getREIMB_RESOLVER() {
		return REIMB_RESOLVER;
	}

	public void setREIMB_RESOLVER(int rEIMB_RESOLVER) {
		REIMB_RESOLVER = rEIMB_RESOLVER;
	}

	public int getREIMB_STATUS_ID() {
		return REIMB_STATUS_ID;
	}

	public void setREIMB_STATUS_ID(int rEIMB_STATUS_ID) {
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
	}

	public int getREIMB_TYPE_ID() {
		return REIMB_TYPE_ID;
	}

	public void setREIMB_TYPE_ID(int rEIMB_TYPE_ID) {
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}
	
	
}
