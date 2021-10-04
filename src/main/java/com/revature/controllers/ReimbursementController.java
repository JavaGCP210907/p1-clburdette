package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	ReimbursementService rs = new ReimbursementService(); 

	public Handler getAllReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<Reimbursement> allReimbursements = rs.getAllReimbursements();
		
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
		
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		
		rs.addReimbursement(reimbursement);
	};
	
	public Handler getReimbursementsByUserIdHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
			
		int id = Integer.parseInt(ctx.body());	
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<Reimbursement> ReimbursementsByUserId = rs.getReimbursementsByUserId(id);
		
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONReimbursements2 = gson.toJson(ReimbursementsByUserId); //convert our Java object into a JSON String
		
		ctx.result(JSONReimbursements2);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
	};

}
