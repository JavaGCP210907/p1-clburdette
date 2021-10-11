package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ReimbursementDao;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;
import com.revature.models.reimbReturnDTO;
import com.revature.models.reimbUpdateDTO;

public class ReimbursementService {

	ReimbursementDao rDao = new ReimbursementDao();
	Logger log = LogManager.getLogger(ReimbursementService.class);
	
	//create a method that gets the DAO data and sends it up to the controller
	//(this method will get called by the controller layer)
	public List<reimbReturnDTO> getAllReimbursements() {
		return rDao.getAllReimb();
	}
	
	public void addReimbursement(ReimbDTO rdto) {
		
		rDao.addReimbursement(rdto);
	}
	
	public List<reimbReturnDTO> getReimbursementsByUserId(int id) {
		log.info("get REIMB by user id in REIMB service layer");
		return rDao.getReimbursementsByUserId(id);
	}
	
	public List<reimbReturnDTO> getReimbursementsByStatusId(int id) {
		log.info("get REIMB by status id in REIMB service layer");
		return rDao.getReimbursementsByStatus(id);
	}
	
	public reimbReturnDTO getReimbById(int id) {
		log.info("get REIMB by status id in REIMB service layer");
		return rDao.getReimbById(id);
	}
	
	public void updateReimbursementStatus(reimbUpdateDTO reimbursement) {
		rDao.updateReimbursementStatus(reimbursement);
	}
}
