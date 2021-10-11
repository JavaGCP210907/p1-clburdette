package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbDTO;
import com.revature.models.reimbReturnDTO;
import com.revature.models.reimbUpdateDTO;

public interface ReimbursementInterface {

	public List<reimbReturnDTO> getAllReimb();
	public List<reimbReturnDTO> getReimbursementsByUserId(int id);
	public List<reimbReturnDTO> getReimbursementsByStatus(int id);
	
	public reimbReturnDTO getReimbById(int id);
	
	public boolean addReimbursement(ReimbDTO rdto);
	
	public void updateReimbursementStatus(reimbUpdateDTO reimbursement);
	

}
