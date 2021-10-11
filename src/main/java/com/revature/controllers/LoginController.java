package com.revature.controllers;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;

import io.javalin.http.Handler;

public class LoginController {

	LoginService ls = new LoginService();
	Logger log = LogManager.getLogger(LoginController.class);

	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object

		
		//invoke the login() method of LoginService using the username and password in the newly created LoginDTO
		
		User checkedUser = ls.getUserByLogin(LDTO); 

		if(checkedUser != null) { //if login is successful...

			//create a user session
			ctx.req.getSession(); //req is a "Request Object", we establish sessions through it
			
			//successful status code 

			ctx.status(200);
			
			ctx.result(gson.toJson(checkedUser));
			//ctx.result("yay it finally worked!");
			
		} else { //if login fails...
			
			ctx.status(401); //"unauthorized" status code
			ctx.result("Login Failed!");
			log.error("Failed login attempt");
			
		}
		
		
	};
}
