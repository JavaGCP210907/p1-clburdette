package com.revature.models;

public class Type {
	
	private int REIMB_TYPE_ID;
	private String REIMB_TYPE;
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(String rEIMB_TYPE) {
		super();
		REIMB_TYPE = rEIMB_TYPE;
	}

	public Type(int rEIMB_TYPE_ID, String rEIMB_TYPE) {
		super();
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
		REIMB_TYPE = rEIMB_TYPE;
	}

	@Override
	public String toString() {
		return "{'REIMB_TYPE_ID' :" + REIMB_TYPE_ID + ", 'REIMB_TYPE' :" + REIMB_TYPE + "}";
	}

	public int getREIMB_TYPE_ID() {
		return REIMB_TYPE_ID;
	}

	public void setREIMB_TYPE_ID(int rEIMB_TYPE_ID) {
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}

	public String getREIMB_TYPE() {
		return REIMB_TYPE;
	}

	public void setREIMB_TYPE(String rEIMB_TYPE) {
		REIMB_TYPE = rEIMB_TYPE;
	}
	

	
}
