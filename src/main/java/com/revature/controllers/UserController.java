package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {

	UserService us = new UserService(); 

	public Handler getUserHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
		int id = Integer.parseInt(ctx.pathParam("resolverID"));		
		
		User user = us.getUserById(id);
		
		Gson gson = new Gson();
		
		String JSONUser = gson.toJson(user);
		
		ctx.result(JSONUser);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(500); //forbidden status code 
		}
		
	};
}
