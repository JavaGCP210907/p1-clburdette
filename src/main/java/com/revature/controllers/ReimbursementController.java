package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.ReimbDTO;
import com.revature.models.reimbReturnDTO;
import com.revature.models.reimbUpdateDTO;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	ReimbursementService rs = new ReimbursementService();
	Logger log = LogManager.getLogger(ReimbursementController.class);

	public Handler getAllReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { 
		
		List<reimbReturnDTO> allReimbursements = rs.getAllReimbursements();

		Gson gson = new Gson();
		
		String JSONReimbursements = gson.toJson(allReimbursements);
		
		ctx.result(JSONReimbursements);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); 
			log.error("getAllReimbursementsHandler failed");
		}
		
	};
	
	public Handler addReimbursementHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		ReimbDTO rdto = gson.fromJson(body, ReimbDTO.class);
		
		try {
			rs.addReimbursement(rdto);
		}catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public Handler getReimbursementsByIdHandler = (ctx) -> {
		
		log.info("in REIMB by User ID handler");
		
		if(ctx.req.getSession(false) != null) {
		log.info(ctx.pathParam("reimbID"));	
		int id = Integer.parseInt(ctx.pathParam("reimbID"));	

		reimbReturnDTO reimbursementsById = rs.getReimbById(id);
		log.info("in handler back from db " + reimbursementsById);

		Gson gson = new Gson();
		
		String JSONReimbursements2 = gson.toJson(reimbursementsById); 
		log.info("in handler back from db after json conversion " + JSONReimbursements2);
		ctx.result(JSONReimbursements2);
		
		ctx.status(200); 
		
		} else {
			ctx.status(403); 
		}
	};
	
	public Handler getReimbursementsByUserIdHandler = (ctx) -> {
		
		log.info("in REIMB by User ID handler");
		
		if(ctx.req.getSession(false) != null) {
		log.info(ctx.pathParam("userID"));	
		int id = Integer.parseInt(ctx.pathParam("userID"));	

		List<reimbReturnDTO> reimbursementsByUserId = rs.getReimbursementsByUserId(id);
		log.info("in handler back from db " + reimbursementsByUserId);

		Gson gson = new Gson();
		
		String JSONReimbursements2 = gson.toJson(reimbursementsByUserId); 
		log.info("in handler back from db after json conversion " + JSONReimbursements2);
		ctx.result(JSONReimbursements2);
		
		ctx.status(200); 
		
		} else {
			ctx.status(403); 
		}
	};
	
	public Handler getReimbursementsByStatusIdHandler = (ctx) -> {
		
		log.info("in REIMB by User ID handler");
		
		if(ctx.req.getSession(false) != null) {
		log.info(ctx.pathParam("statusID"));	
		int id = Integer.parseInt(ctx.pathParam("statusID"));	
	
		List<reimbReturnDTO> reimbursementsByStatusId = rs.getReimbursementsByStatusId(id);
		log.info("in handler back from db " + reimbursementsByStatusId);
		
		Gson gson = new Gson();
		
		String JSONReimbursements2 = gson.toJson(reimbursementsByStatusId);
		log.info("in handler back from db after json conversion " + JSONReimbursements2);
		ctx.result(JSONReimbursements2);
		
		ctx.status(200); 
		
		} else {
			ctx.status(403); 
		}
	};
	
	public Handler updateReimbursementHandler = (ctx) -> {
		
		log.info("in REIMB update handler");
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		reimbUpdateDTO reimbursement = gson.fromJson(body, reimbUpdateDTO.class);
		
		rs.updateReimbursementStatus(reimbursement);
	};
}
