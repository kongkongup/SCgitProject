package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTIL.ConnectionManager;
import VO.Space;
import VO.Users;


public class SpaceDAO {
	/*2017.05.22 ±è¿µÇö*/
	public int updateSpace(Space s){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "UPDATE space "
				+ "SET "
				+ "room_name = ?, assigned = ?, occupancy = ?, others = ? "
				+ "WHERE room_name = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,s.getRoom_name());
			pstmt.setString(2, s.getAssigned());
			pstmt.setInt(3, s.getOccupancy());
			pstmt.setString(4, s.getOthers());
			pstmt.setString(5, "study3");
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Space> selectAllSpaces(){
		ArrayList<Space> result = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT  * FROM member "
				+ "ORDER BY user_id";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String room_name = rs.getString(1);
				String assigned = rs.getString(2);
				int occupancy = rs.getInt(3);
				String others = rs.getString(4);
				result.add(new Space(room_name, assigned, occupancy, others));
			}
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Space selectOneSpace(String room_name){
		Space result = null;
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM space "
				+ "WHERE room_name = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, room_name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String assigned = rs.getString(2);
				int occupancy = rs.getInt(3);
				String others = rs.getString(4);
				result = new Space(room_name, assigned, occupancy, others);
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
