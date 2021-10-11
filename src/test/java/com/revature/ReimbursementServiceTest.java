package com.revature;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.revature.models.LoginDTO;
import com.revature.models.ReimbDTO;
import com.revature.models.User;
import com.revature.models.reimbReturnDTO;
import com.revature.models.reimbUpdateDTO;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;



class ReimbursementServiceTest {
	
	Logger log = LogManager.getLogger(ReimbursementServiceTest.class);
	@Test
	void getAllReimbursementsTest() {
		ReimbursementService rs = new ReimbursementService();
		List<reimbReturnDTO> allReimbursements = rs.getAllReimbursements();
		Assertions.assertFalse(allReimbursements.isEmpty());
	}
	
	@Test
	void addReimbursementTest() {
		ReimbursementService rs = new ReimbursementService();
		ReimbDTO reimbToAdd = new ReimbDTO(9999999.99,"test",1,1);
		try {
		rs.addReimbursement(reimbToAdd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<reimbReturnDTO> reimbursements = rs.getReimbursementsByUserId(1);
		log.info(reimbursements);
		boolean addedReimbFound = false;
		for(reimbReturnDTO reimb: reimbursements ) {
			if(reimb.getREIMB_AMOUNT() == 9999999.99 &&
			   reimb.getREIMB_DESCRIPTION().equals("test") &&
			   reimb.getREIMB_STATUS_ID().equals("pending") &&
			   reimb.getREIMB_TYPE_ID().equals("LODGING")){
				addedReimbFound = true;
			}
		}
		Assertions.assertTrue(addedReimbFound);
	}
	
	@Test
	void getReimbursementsByUserIdTest() {
		ReimbursementService rs = new ReimbursementService();
		List<reimbReturnDTO> allReimbursements = rs.getReimbursementsByUserId(1);
		int addedReimbMatch = 0;
		for(reimbReturnDTO reimb: allReimbursements ) {
			if(reimb.getREIMB_AUTHOR().equals("vikwald1999")){
				addedReimbMatch++;
			}
		}
		Assertions.assertEquals(addedReimbMatch,allReimbursements.size());
	}
	
	@Test
	void getReimbursementsByStatusTest() {
		ReimbursementService rs = new ReimbursementService();
		List<reimbReturnDTO> allReimbursements = rs.getReimbursementsByStatusId(3);
		boolean reimbMatch = true;
		for(reimbReturnDTO reimb: allReimbursements ) {
			if(!reimb.getREIMB_STATUS_ID().equals("denied")){
				reimbMatch = false;
			}
		}
		Assertions.assertTrue(reimbMatch);
	}
	
	@Test
	void getReimbByIdTest() {
		ReimbursementService rs = new ReimbursementService();
		List<reimbReturnDTO> allReimbursements = rs.getReimbursementsByUserId(1);
		reimbReturnDTO first = allReimbursements.get(0);
		double firstAMT = first.getREIMB_AMOUNT();
		reimbReturnDTO second = rs.getReimbById(first.getREIMB_ID());
		double secondAMT = second.getREIMB_AMOUNT();
		
		Assertions.assertEquals(firstAMT, secondAMT);
	}
	
	@Test
	void updateReimbTest() {
		ReimbursementService rs = new ReimbursementService();
		reimbReturnDTO first = rs.getReimbById(1);
		String firstStatus = first.getREIMB_STATUS_ID();
		reimbUpdateDTO reimbUpdate = new reimbUpdateDTO(1,1,1);
		rs.updateReimbursementStatus(reimbUpdate);
		reimbReturnDTO second = rs.getReimbById(1);
		String secondStatus = second.getREIMB_STATUS_ID();
		boolean testStrs = firstStatus.equals(secondStatus);
		Assertions.assertFalse(testStrs);
	}
	
	@Test
	void getUserbyIdTest() {
		UserService us = new UserService();
		User user = us.getUserById(5);
		Assertions.assertTrue(user.getUSER_ROLE_ID() == 1);
	}
	
	@Test
	void userLoginTest() {
		UserService us = new UserService();
		LoginDTO LDTO = new LoginDTO("test", "test");
		User user = us.checkUserForLogin(LDTO);
		Assertions.assertFalse(user == null);
	}
	
	@Test
	void AddReimbFailConditionTest() {
		ReimbDTO rdto = new ReimbDTO(99.99,"test",0,0);
		Assertions.assertTrue(rdto.getREIMB_AUTHOR() == 0 ||
				   rdto.getREIMB_TYPE_ID() == 0);
	}
	
	@Test
	void AddReimbUpdateFailConditionTest() {
		reimbUpdateDTO rdto = new reimbUpdateDTO(9,0,0);
		Assertions.assertTrue(rdto.getREIMB_RESOLVER() == 0 ||
				   rdto.getREIMB_STATUS_ID() == 0);
	}
	


}
