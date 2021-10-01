package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementInterface {

	public List<Reimbursement> getAllReimbursements();
	
	public Reimbursement getReimbursementById(int id);
	
	public boolean addReimbursement(Reimbursement reimbursement);
	
	public List<Reimbursement> getReimbursementsByStatus(int id);
	
	public void updateReimbursementStatus(int id, int status);
}
