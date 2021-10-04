package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;

public class ReimbursementService {

	ReimbursementDao rDao = new ReimbursementDao();
	
	
	//create a method that gets the DAO data and sends it up to the controller
	//(this method will get called by the controller layer)
	public List<Reimbursement> getAllReimbursements() {
		return rDao.getAllReimbursements();
	}
	
	public void addReimbursement(Reimbursement reimbursement) {
		rDao.addReimbursement(reimbursement);
	}
	
	public List<Reimbursement> getReimbursementsByUserId(int id) {
		return rDao.getReimbursementByUserId(id);
	}
}
