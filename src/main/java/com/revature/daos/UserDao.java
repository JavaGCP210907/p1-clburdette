package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDao implements UserInterface{

	@Override
	public User getUserByID(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				

				User u = new User (
					rs.getInt("ERS_USERS_ID"),
					rs.getString("ERS_USERNAME"),
					rs.getString("ERS_PASSWORD"),
					rs.getString("USER_FIRST_NAME"),
					rs.getString("USER_LAST_NAME"),
					rs.getString("USER_EMAIL"),
					rs.getInt("USER_ROLE_ID")
				);
				
				

				userList.add(u);
			}
			
			
			return userList.get(0);
			
		}catch(SQLException e) {
			System.out.println("Get user by id failed");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUserName(String ERS_USERNAME) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, ERS_USERNAME);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				

				User u = new User (
					rs.getInt("ERS_USERS_ID"),
					rs.getString("ERS_USERNAME"),
					rs.getString("ERS_PASSWORD"),
					rs.getString("USER_FIRST_NAME"),
					rs.getString("USER_LAST_NAME"),
					rs.getString("USER_EMAIL"),
					rs.getInt("USER_ROLE_ID")
				);
				
				

				userList.add(u);
			}
			
			
			return userList.get(0);
			
		}catch(SQLException e) {
			System.out.println("Get user by username failed");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByNameAndPassword(String ERS_USERNAME, String ERS_PASSWORD) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?" +
						 " AND ers_password = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, ERS_USERNAME);//create a Statement object to execute our query
			ps.setString(1, ERS_PASSWORD);
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			if(!rs.first()) {
				return null;
			} else {
				List<User> userList = new ArrayList<>();
			
				while(rs.next()) {
				

					User u = new User (
					rs.getInt("ERS_USERS_ID"),
					rs.getString("ERS_USERNAME"),
					rs.getString("ERS_PASSWORD"),
					rs.getString("USER_FIRST_NAME"),
					rs.getString("USER_LAST_NAME"),
					rs.getString("USER_EMAIL"),
					rs.getInt("USER_ROLE_ID")
					);
				
				

					userList.add(u);
				}
			
			
				return userList.get(0);
			}
		}catch(SQLException e) {
			System.out.println("Get user by username failed");
			e.printStackTrace();
		}
		return null;
	}

}
