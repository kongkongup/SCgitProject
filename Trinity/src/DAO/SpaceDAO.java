package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import UTIL.ConnectionManager;
import VO.Space;


public class SpaceDAO {
	
	public int updateSpace(Space s){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "UPDATE space "
				+ "SET "
				+ "room_Name = ?, desk = ? chair = ?"
				+ "WHERE room_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,s.getRoom_Name());
			pstmt.setInt(2, s.getDesk());
			pstmt.setInt(3, s.getChair());
			pstmt.setInt(4, s.getRoom_id());
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
