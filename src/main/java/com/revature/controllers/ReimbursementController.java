package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.ReimbDTO;
import com.revature.models.reimbReturnDTO;
import com.revature.models.reimbUpdateDTO;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	ReimbursementService rs = new ReimbursementService();
	Logger log = LogManager.getLogger(ReimbursementController.class);

	public Handler getAllReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		
		//we create an Array with Avenger data (using the service to talk to the dao)
		//List<Reimbursement> allReimbursements = rs.getAllReimbursements();
		List<reimbReturnDTO> allReimbursements = rs.getAllReimbursements();
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONReimbursements = gson.toJson(allReimbursements); //convert our Java object into a JSON String
		
		ctx.result(JSONReimbursements);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
		
	};
	
	public Handler addReimbursementHandler = (ctx) -> {
		
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson();
		
		ReimbDTO rdto = gson.fromJson(body, ReimbDTO.class);
		
		log.debug(rdto);
		
		rs.addReimbursement(rdto);
	};
	
	public Handler getReimbursementsByIdHandler = (ctx) -> {
		
		log.info("in REIMB by User ID handler");
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		log.info(ctx.pathParam("reimbID"));	
		int id = Integer.parseInt(ctx.pathParam("reimbID"));	
		//we create an Array with Avenger data (using the service to talk to the dao)
		reimbReturnDTO reimbursementsById = rs.getReimbById(id);
		log.info("in handler back from db " + reimbursementsById);
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONReimbursements2 = gson.toJson(reimbursementsById); //convert our Java object into a JSON String
		log.info("in handler back from db after json conversion " + JSONReimbursements2);
		ctx.result(JSONReimbursements2);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
	};
	
	public Handler getReimbursementsByUserIdHandler = (ctx) -> {
		
		log.info("in REIMB by User ID handler");
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		log.info(ctx.pathParam("userID"));	
		int id = Integer.parseInt(ctx.pathParam("userID"));	
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<reimbReturnDTO> reimbursementsByUserId = rs.getReimbursementsByUserId(id);
		log.info("in handler back from db " + reimbursementsByUserId);
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONReimbursements2 = gson.toJson(reimbursementsByUserId); //convert our Java object into a JSON String
		log.info("in handler back from db after json conversion " + JSONReimbursements2);
		ctx.result(JSONReimbursements2);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
	};
	
	public Handler getReimbursementsByStatusIdHandler = (ctx) -> {
		
		log.info("in REIMB by User ID handler");
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		log.info(ctx.pathParam("statusID"));	
		int id = Integer.parseInt(ctx.pathParam("statusID"));	
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<reimbReturnDTO> reimbursementsByStatusId = rs.getReimbursementsByStatusId(id);
		log.info("in handler back from db " + reimbursementsByStatusId);
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONReimbursements2 = gson.toJson(reimbursementsByStatusId); //convert our Java object into a JSON String
		log.info("in handler back from db after json conversion " + JSONReimbursements2);
		ctx.result(JSONReimbursements2);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
	};
	
	public Handler updateReimbursementHandler = (ctx) -> {
		
		log.info("in REIMB update handler");
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson();
		
		reimbUpdateDTO reimbursement = gson.fromJson(body, reimbUpdateDTO.class);
		
		rs.updateReimbursementStatus(reimbursement);
	};
}
