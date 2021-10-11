package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		ReimbursementController rc = new ReimbursementController();//to get access to the HTTP Handlers in the controller layer
		LoginController lc = new LoginController();
		UserController uc = new UserController();
		Logger log = LogManager.getLogger(Launcher.class);
		
		//testing whether our connection works...
		try(Connection conn = ConnectionUtil.getConnection()){

		} catch (SQLException e) {
			log.error("initial connection to db failed");
			e.printStackTrace();
		}
		
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8090);
		
		
		log.info("launcher successfully loaded and ready");
		//app.get("/users", ac.getAllUsers);

		app.post("/reimbursements", rc.addReimbursementHandler);
		app.post("/reimbursements/status", rc.updateReimbursementHandler);
		app.get("/reimbursements", rc.getAllReimbursementsHandler);
		app.get("/reimbursements/:reimbID", rc.getReimbursementsByIdHandler);
		app.get("/reimbursements/user/:userID", rc.getReimbursementsByUserIdHandler);
		app.get("/reimbursements/status/:statusID", rc.getReimbursementsByStatusIdHandler);
		app.get("/resolver/:resolverID" , uc.getUserHandler);
		
		//imagine we have users 
		//Send a POST request to validate user login credentials
		app.post("/login", lc.loginHandler);
	}

}
