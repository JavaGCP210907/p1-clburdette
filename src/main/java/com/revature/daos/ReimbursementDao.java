package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;
import com.revature.models.reimbReturnDTO;
import com.revature.models.reimbUpdateDTO;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDao implements ReimbursementInterface{
	
	Logger log = LogManager.getLogger(ReimbursementDao.class);
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
					rs.getTimestamp("REIMB_SUBMITTED"),
					rs.getTimestamp("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
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
	public reimbReturnDTO getReimbById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT ers_reimbursement.REIMB_ID, ers_reimbursement.REIMB_AMOUNT, ers_reimbursement.REIMB_SUBMITTED,"
			+ "ers_reimbursement.REIMB_RESOLVED, ers_reimbursement.REIMB_DESCRIPTION, ers_users.ERS_USERNAME, ers_reimbursement.REIMB_RESOLVER,"
			+ "ers_reimbursement_status.REIMB_STATUS, ers_reimbursement_type.REIMB_TYPE "
			+ "FROM ers_reimbursement, ers_users, ers_reimbursement_status, ers_reimbursement_type "
			+ "WHERE ers_reimbursement.REIMB_ID = ? "
			+ "AND ers_reimbursement.REIMB_AUTHOR = ers_users.ERS_USERS_ID "
			+ "AND ers_reimbursement.REIMB_STATUS_ID = ers_reimbursement_status.REIMB_STATUS_ID "
			+ "AND ers_reimbursement.REIMB_TYPE_ID = ers_reimbursement_type.REIMB_TYPE_ID;";

			
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			if(!rs.first()){
				return null;
			}else {
				
				List<reimbReturnDTO> reimbursementList = new ArrayList<>();
				
				rs.beforeFirst();
				
				while(rs.next()) {
				

					reimbReturnDTO r = new reimbReturnDTO (
							rs.getInt("REIMB_ID"),
							rs.getDouble("REIMB_AMOUNT"),
							rs.getTimestamp("REIMB_SUBMITTED"),
							rs.getTimestamp("REIMB_RESOLVED"),
							rs.getString("REIMB_DESCRIPTION"),
							rs.getString("ERS_USERNAME"),
							rs.getString("REIMB_RESOLVER"),
							rs.getString("REIMB_STATUS"),
							rs.getString("REIMB_TYPE")
						);
				
				

					reimbursementList.add(r);
				}
			
			
				return reimbursementList.get(0);
			}
		}catch(SQLException e) {
			System.out.println("Get reimbursement by id failed");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addReimbursement(ReimbDTO rdto) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ers_reimbursement" +
						 "(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) " +
						 "VALUES(?, DEFAULT, CAST(NULL AS timestamp),?,?, NULL,1,?);"; //write out out SQL query
			log.debug(rdto);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, rdto.getREIMB_AMOUNT());
			ps.setString(2, rdto.getREIMB_DESCRIPTION());
			ps.setInt(3, rdto.getREIMB_AUTHOR());
			ps.setInt(4, rdto.getREIMB_TYPE_ID());
			
			ps.executeUpdate();
			
			return true;
			
		}catch(SQLException e) {
			System.out.println("Add reimbursement failed");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<reimbReturnDTO> getReimbursementsByStatus(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?"; //write out out SQL query
			String sql = "SELECT ers_reimbursement.REIMB_ID, ers_reimbursement.REIMB_AMOUNT, ers_reimbursement.REIMB_SUBMITTED,"
			+ "ers_reimbursement.REIMB_RESOLVED, ers_reimbursement.REIMB_DESCRIPTION, ers_users.ERS_USERNAME, ers_reimbursement.REIMB_RESOLVER,"
			+ "ers_reimbursement_status.REIMB_STATUS, ers_reimbursement_type.REIMB_TYPE "
			+ "FROM ers_reimbursement, ers_users, ers_reimbursement_status, ers_reimbursement_type "
			+ "WHERE ers_reimbursement.REIMB_STATUS_ID = ? "
			+ "AND ers_reimbursement.REIMB_AUTHOR = ers_users.ERS_USERS_ID "
			+ "AND ers_reimbursement.REIMB_STATUS_ID = ers_reimbursement_status.REIMB_STATUS_ID "
			+ "AND ers_reimbursement.REIMB_TYPE_ID = ers_reimbursement_type.REIMB_TYPE_ID "
			+ "ORDER BY ers_reimbursement.REIMB_ID;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			List<reimbReturnDTO> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				

				reimbReturnDTO r = new reimbReturnDTO (
						rs.getInt("REIMB_ID"),
						rs.getDouble("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"),
						rs.getTimestamp("REIMB_RESOLVED"),
						rs.getString("REIMB_DESCRIPTION"),
						rs.getString("ERS_USERNAME"),
						rs.getString("REIMB_RESOLVER"),
						rs.getString("REIMB_STATUS"),
						rs.getString("REIMB_TYPE")
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
	public void updateReimbursementStatus(reimbUpdateDTO reimbursement) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE ers_reimbursement " +
					   	 "SET reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = now() " +
					   	 "WHERE reimb_id = ?"; //write out out SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursement.getREIMB_STATUS_ID());
			ps.setInt(2, reimbursement.getREIMB_RESOLVER());
			ps.setInt(3, reimbursement.getREIMB_ID());//create a Statement object to execute our query
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<reimbReturnDTO> getReimbursementsByUserId(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			log.info("get REIMB by user request in dao function");
			//String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?"; //write out out SQL query
			
			String sql = "SELECT ers_reimbursement.REIMB_ID, ers_reimbursement.REIMB_AMOUNT, ers_reimbursement.REIMB_SUBMITTED,"
			+ "ers_reimbursement.REIMB_RESOLVED, ers_reimbursement.REIMB_DESCRIPTION, ers_users.ERS_USERNAME, ers_reimbursement.REIMB_RESOLVER,"
			+ "ers_reimbursement_status.REIMB_STATUS, ers_reimbursement_type.REIMB_TYPE "
			+ "FROM ers_reimbursement, ers_users, ers_reimbursement_status, ers_reimbursement_type "
			+ "WHERE ers_reimbursement.REIMB_AUTHOR = ? "
			+ "AND ers_reimbursement.REIMB_AUTHOR = ers_users.ERS_USERS_ID "
			+ "AND ers_reimbursement.REIMB_STATUS_ID = ers_reimbursement_status.REIMB_STATUS_ID "
			+ "AND ers_reimbursement.REIMB_TYPE_ID = ers_reimbursement_type.REIMB_TYPE_ID "
			+ "ORDER BY ers_reimbursement.REIMB_ID;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);//create a Statement object to execute our query
			
			ResultSet rs = ps.executeQuery(); //put the results of the query into a ResultSet (execute the query into it)
			
			List<reimbReturnDTO> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				

				reimbReturnDTO r = new reimbReturnDTO (
						rs.getInt("REIMB_ID"),
						rs.getDouble("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"),
						rs.getTimestamp("REIMB_RESOLVED"),
						rs.getString("REIMB_DESCRIPTION"),
						rs.getString("ERS_USERNAME"),
						rs.getString("REIMB_RESOLVER"),
						rs.getString("REIMB_STATUS"),
						rs.getString("REIMB_TYPE")
				);
				
				

				reimbursementList.add(r);
			}
			log.info("get REIMB by user id back from db: " +reimbursementList);
			
			return reimbursementList;
			
		}catch(SQLException e) {
			System.out.println("Get reimbursement by id failed");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<reimbReturnDTO> getAllReimb() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT ers_reimbursement.REIMB_ID, ers_reimbursement.REIMB_AMOUNT, ers_reimbursement.REIMB_SUBMITTED,"
					+ "ers_reimbursement.REIMB_RESOLVED, ers_reimbursement.REIMB_DESCRIPTION, ers_users.ERS_USERNAME, ers_reimbursement.REIMB_RESOLVER,"
					+ "ers_reimbursement_status.REIMB_STATUS, ers_reimbursement_type.REIMB_TYPE "
					+ "FROM ers_reimbursement, ers_users, ers_reimbursement_status, ers_reimbursement_type "
					+ "WHERE ers_reimbursement.REIMB_AUTHOR = ers_users.ERS_USERS_ID "
					+ "AND ers_reimbursement.REIMB_STATUS_ID = ers_reimbursement_status.REIMB_STATUS_ID "
					+ "AND ers_reimbursement.REIMB_TYPE_ID = ers_reimbursement_type.REIMB_TYPE_ID "
					+ "ORDER BY ers_reimbursement.REIMB_ID;";

			
			Statement s = conn.createStatement(); //create a Statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the results of the query into a ResultSet (execute the query into it)
			
			List<reimbReturnDTO> reimbursementList = new ArrayList<>(); 
			
			//populate the ArrayList
			while(rs.next()) {
				

				reimbReturnDTO r = new reimbReturnDTO (
					rs.getInt("REIMB_ID"),
					rs.getDouble("REIMB_AMOUNT"),
					rs.getTimestamp("REIMB_SUBMITTED"),
					rs.getTimestamp("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					rs.getString("ERS_USERNAME"),
					rs.getString("REIMB_RESOLVER"),
					rs.getString("REIMB_STATUS"),
					rs.getString("REIMB_TYPE")
				);
				

				reimbursementList.add(r);
			}
			log.info("end of getAllReimb");
			log.info(reimbursementList);
			return reimbursementList;
			
		} catch (SQLException e) {
			System.out.println("Get all reimbursements failed");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	
}
