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
			
			String sql = "SELECT * FROM ers_reimbursement WHERE id = ?"; //write out out SQL query
			
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReimbursement(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
