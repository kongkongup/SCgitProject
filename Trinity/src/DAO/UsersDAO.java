package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTIL.ConnectionManager;
import VO.Space;
import VO.Users;

public class UsersDAO {
	
	//user insert to table "USER"
	public int insertU(Users user){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "INSERT INTO USER "
				+ "VALUES "
				+ "( "
				+ "?,?,?,?,?,? "
				+ ")";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,user.getUser_ID());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getJumin());
			pstmt.setString(5, user.getPeriod());
			pstmt.setString(6, user.getClassRoom());
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int update(Users user){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "UPDATE members "
				+ "SET "
				+ "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String id){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "DELETE FROM user "
				+ "where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(id);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	
	public ArrayList<Users> selectAllUser(String id){
		ArrayList result = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM CLIENT "
				+ "WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Users selectOneUser(){
		Users result = null;
		return result;
	}
	
}
