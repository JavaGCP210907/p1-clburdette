package com.revature.controllers;

import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {

	UserService us = new UserService(); 

	public Handler getUserHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
		String body = ctx.body();
		
		String clientUserIdentifier = us.getClientUserIdentifier(body);
		
		ctx.result(clientUserIdentifier);
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(500); //forbidden status code 
		}
		
	};
}
