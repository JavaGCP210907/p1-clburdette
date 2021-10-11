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
		
		ReimbursementController rc = new ReimbursementController(); //declare and initialize controllers
		LoginController lc = new LoginController();
		UserController uc = new UserController();
		
		Logger log = LogManager.getLogger(Launcher.class);
		
		final int PORT = 8090;
		
		try(Connection conn = ConnectionUtil.getConnection()){ //try connection to db

		} catch (SQLException e) {
			log.error("initial connection to db failed");
			e.printStackTrace();
		}
		
		//create and start Javalin server on port PORT
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(PORT);
		
		log.info("launcher successfully loaded and ready");
		//reimbursement posts and gets
		app.post("/reimbursements", rc.addReimbursementHandler);
		app.post("/reimbursements/status", rc.updateReimbursementHandler);
		app.get("/reimbursements", rc.getAllReimbursementsHandler);
		app.get("/reimbursements/:reimbID", rc.getReimbursementsByIdHandler);
		app.get("/reimbursements/user/:userID", rc.getReimbursementsByUserIdHandler);
		app.get("/reimbursements/status/:statusID", rc.getReimbursementsByStatusIdHandler);
		//get user for resolver username
		app.get("/resolver/:resolverID" , uc.getUserHandler);
		//Send a POST request to validate user login credentials
		app.post("/login", lc.loginHandler);
	}
}
