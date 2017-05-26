package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTIL.ConnectionManager;
import VO.Reservation_Log;
import VO.Users;

/*2017.5.23 ±è¿µÇö*/
public class LogDAO {
	
	public int insertLog(Reservation_Log log){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "INSERT INTO reservation_log "
				+ "VALUES "
				+ "("
				+ "log_seq.NEXTVAL,?,?,?,?,?,?,?"
				+ ")";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, log.getUser_id());
			pstmt.setString(2, log.getUser_name());
			pstmt.setInt(3, log.getStart_time());
			pstmt.setInt(4, log.getEnd_time());
			pstmt.setString(5, log.getRoom_name());
			pstmt.setString(6, log.getUse());
			pstmt.setString(7, log.getDate());
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int DeleteLog(String log_seq){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "DELETE FROM reservation_log "
				+ "where log_seq = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, log_seq);
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	
	public ArrayList<Reservation_Log> selectAllLogs(){
		ArrayList<Reservation_Log> result = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT rownum,reservation_log.* "
				+ "FROM reservation_log "
				+ "ORDER BY rownum";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int rownum = rs.getInt(1);
				int log_seq = rs.getInt(2);
				String user_id = rs.getString(3);
			    String user_name = rs.getString(4);
				int start_time = rs.getInt(5);
				int end_time = rs.getInt(6);
				String room_name = rs.getString(7);
				String use = rs.getString(8);
				String date = rs.getString(9);
				result.add(new Reservation_Log(rownum, log_seq, user_id, user_name,
						room_name, start_time, end_time, use, date));
				
			}
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Reservation_Log> selectOneUserAllLogs(String id){
		ArrayList<Reservation_Log> result = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT rownum,reservation_log.* "
				+ "FROM reservation_log "
				+ "WHERE User_id = ? "
				+ "ORDER BY rownum";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int rownum = rs.getInt(1);
				int log_seq = rs.getInt(2);
				String user_id = rs.getString(3);
			    String user_name = rs.getString(4);
				int start_time = rs.getInt(5);
				int end_time = rs.getInt(6);
				String room_name = rs.getString(7);
				String use = rs.getString(8);
				String date = rs.getString(9);
				result.add(new Reservation_Log(rownum, log_seq, user_id, user_name,
						room_name, start_time, end_time, use, date));		
			}			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public ArrayList<Reservation_Log> selectDayAllLogs(String date){
		ArrayList<Reservation_Log> result = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT rownum,reservation_log.* "
				+ "FROM reservation_log "
				+ "WHERE reservation_date = ? "
				+ "ORDER BY rownum";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int rownum = rs.getInt(1);
				int log_seq = rs.getInt(2);
				String user_id = rs.getString(3);
			    String user_name = rs.getString(4);
				int start_time = rs.getInt(5);
				int end_time = rs.getInt(6);
				String room_name = rs.getString(7);
				String use = rs.getString(8);
				result.add(new Reservation_Log(rownum, log_seq, user_id, user_name,
						room_name, start_time, end_time, use, date));		
			}			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
