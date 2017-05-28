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
				+ "log_seq.NEXTVAL,?,?,?,?,?,?"
				+ ")";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, log.getUser_id());
			pstmt.setInt(2, log.getStart_time());
			pstmt.setInt(3, log.getEnd_time());
			pstmt.setString(4, log.getRoom_name());
			pstmt.setString(5, log.getUse());
			pstmt.setString(6, log.getDate());
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
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
				int start_time = rs.getInt(4);
				int end_time = rs.getInt(5);
				String room_name = rs.getString(6);
				String use = rs.getString(7);
				String date = rs.getString(8);
				result.add(new Reservation_Log(rownum, log_seq, user_id, room_name, start_time, end_time, use, date));
				
			}
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
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
				int start_time = rs.getInt(4);
				int end_time = rs.getInt(5);
				String room_name = rs.getString(6);
				String use = rs.getString(7);
				String date = rs.getString(8);
				result.add(new Reservation_Log(rownum, log_seq, user_id,
						room_name, start_time, end_time, use, date));		
			}			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
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
				int start_time = rs.getInt(4);
				int end_time = rs.getInt(5);
				String room_name = rs.getString(6);
				String use = rs.getString(7);
				result.add(new Reservation_Log(rownum, log_seq, user_id,
						room_name, start_time, end_time, use, date));		
			}			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
