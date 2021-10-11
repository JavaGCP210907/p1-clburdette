package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ReimbursementDao;
import com.revature.models.ReimbDTO;
import com.revature.models.reimbReturnDTO;
import com.revature.models.reimbUpdateDTO;

public class ReimbursementService {

	ReimbursementDao rDao = new ReimbursementDao();
	Logger log = LogManager.getLogger(ReimbursementService.class);
	
	public List<reimbReturnDTO> getAllReimbursements() {
		return rDao.getAllReimb();
	}
	
	public void addReimbursement(ReimbDTO rdto) throws Exception {
		try {
			log.info(rdto.getREIMB_TYPE_ID());
			log.info("hi there");
		if(rdto.getREIMB_AUTHOR() == 0 ||
		   rdto.getREIMB_TYPE_ID() == 0) {
			throw new Exception("rdto input out of range");
		}
		rDao.addReimbursement(rdto);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<reimbReturnDTO> getReimbursementsByUserId(int id) {
		
		return rDao.getReimbursementsByUserId(id);
	}
	
	public List<reimbReturnDTO> getReimbursementsByStatusId(int id) {

		return rDao.getReimbursementsByStatus(id);
	}
	
	public reimbReturnDTO getReimbById(int id) {

		return rDao.getReimbById(id);
	}
	
	public void updateReimbursementStatus(reimbUpdateDTO reimbursement) {
		rDao.updateReimbursementStatus(reimbursement);
	}
}
