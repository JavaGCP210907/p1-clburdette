package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDao implements ReimbursementInterface{

	@Override
	public List<Reimbursement> getAllReimbursements() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement"; //write out out SQL query
			
			Statement s = conn.createStatement(); //create a Statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the results of the query into a ResultSet (execute the query into it)
			
			List<Reimbursement> reimbursementList = new ArrayList<>(); 
			
			//populate the ArrayList
			while(rs.next()) {
				

				Reimbursement r = new Reimbursement (
					rs.getInt("REIMB_ID"),
					rs.getDouble("REIMB_AMOUNT"),
					rs.getDate("REIMB_SUBMITTED"),
					rs.getDate("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					rs.getString("REIMB_RECEIPT"),
					rs.getInt("REIMB_AUTHOR"),
					rs.getInt("REIMB_RESOLVER"),
					rs.getInt("REIMB_STATUS_ID"),
					rs.getInt("REIMB_TYPE_ID")
				);
				

				reimbursementList.add(r);
			}
			
			
			return reimbursementList;
			
		} catch (SQLException e) {
			System.out.println("Get all reimbursements failed");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				

				Reimbursement r = new Reimbursement (
					rs.getInt("REIMB_ID"),
					rs.getDouble("REIMB_AMOUNT"),
					rs.getDate("REIMB_SUBMITTED"),
					rs.getDate("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					rs.getString("REIMB_RECEIPT"),
					rs.getInt("REIMB_AUTHOR"),
					rs.getInt("REIMB_RESOLVER"),
					rs.getInt("REIMB_STATUS_ID"),
					rs.getInt("REIMB_TYPE_ID")
				);
				
				

				reimbursementList.add(r);
			}
			
			
			return reimbursementList.get(0);
			
		}catch(SQLException e) {
			System.out.println("Get reimbursement by id failed");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ers_reimbursement" +
						 "VALUES(?,?,?,?,?,?,?,?,?,?);"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursement.getREIMB_ID());
			ps.setDouble(2, reimbursement.getREIMB_AMOUNT());
			ps.setDate(3, reimbursement.getREIMB_SUBMITTED());
			ps.setDate(4, reimbursement.getREIMB_RESOLVED());
			ps.setString(5, reimbursement.getREIMB_DESCRIPTION());
			ps.setString(6, reimbursement.getREIMB_RECEIPT());
			ps.setInt(7, reimbursement.getREIMB_AUTHOR());
			ps.setInt(8, reimbursement.getREIMB_RESOLVER());
			ps.setInt(9, reimbursement.getREIMB_STATUS_ID());
			ps.setInt(10, reimbursement.getREIMB_TYPE_ID());
			
			ps.executeUpdate();
			
			return true;
			
		}catch(SQLException e) {
			System.out.println("Add reimbursement failed");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Reimbursement> getReimbursementsByStatus(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(sql); //put the results of the query into a ResultSet (execute the query into it)
			
			List<Reimbursement> reimbursementList = new ArrayList<>(); 
			
			//populate the ArrayList
			while(rs.next()) {
				

				Reimbursement r = new Reimbursement (
					rs.getInt("REIMB_ID"),
					rs.getDouble("REIMB_AMOUNT"),
					rs.getDate("REIMB_SUBMITTED"),
					rs.getDate("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					rs.getString("REIMB_RECEIPT"),
					rs.getInt("REIMB_AUTHOR"),
					rs.getInt("REIMB_RESOLVER"),
					rs.getInt("REIMB_STATUS_ID"),
					rs.getInt("REIMB_TYPE_ID")
				);
				

				reimbursementList.add(r);
			}
			
			
			return reimbursementList;
			
		} catch (SQLException e) {
			System.out.println("Get reimbursements by status failed");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public void updateReimbursementStatus(int id, int status) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE ers_reimbursement " +
					   	 "SET reimb_status_id = ? " +
					   	 "WHERE reimb_id = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, status);
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ps.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Reimbursement> getReimbursementByUserId(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				

				Reimbursement r = new Reimbursement (
					rs.getInt("REIMB_ID"),
					rs.getDouble("REIMB_AMOUNT"),
					rs.getDate("REIMB_SUBMITTED"),
					rs.getDate("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					rs.getString("REIMB_RECEIPT"),
					rs.getInt("REIMB_AUTHOR"),
					rs.getInt("REIMB_RESOLVER"),
					rs.getInt("REIMB_STATUS_ID"),
					rs.getInt("REIMB_TYPE_ID")
				);
				
				

				reimbursementList.add(r);
			}
			
			
			return reimbursementList;
			
		}catch(SQLException e) {
			System.out.println("Get reimbursement by id failed");
			e.printStackTrace();
		}
		return null;
	}
	
}
