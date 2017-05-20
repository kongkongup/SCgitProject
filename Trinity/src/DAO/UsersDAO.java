package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTIL.ConnectionManager;
import VO.Users;

public class UsersDAO {
	
	//user insert to table "USER"
	public int insertUser(Users user){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "INSERT INTO user "
				+ "VALUES "
				+ "( "
				+ "?,?,?,?,?,?,?,? "
				+ ")";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,user.getUser_ID());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getJumin());
			pstmt.setString(6, user.getE_Mail());
			pstmt.setString(7, user.getPeriod());
			pstmt.setString(8, user.getClassRoom());
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int updateUser(Users user){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "UPDATE user "
				+ "SET "
				+ "mail = ?, period = ?, classRoom = ? "
				+ "WHERE user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getE_Mail());
			pstmt.setString(2, user.getPeriod());
			pstmt.setString(3, user.getClassRoom());
			pstmt.setString(4, user.getUser_ID());
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteUser(String id){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "DELETE FROM user "
				+ "where user_id = ?";
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
	
	public ArrayList<Users> selectAllUsers(){
		ArrayList<Users> result = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM user "
				+ "ORDER BY user_id";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String user_ID = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String gender = rs.getString(4);
				String jumin = rs.getString(5);
				String e_Mail = rs.getString(6);
				String period = rs.getString(7);
				String classRoom = rs.getString(8);
				result.add(new Users(user_ID, password, name, gender, jumin, e_Mail, period, classRoom));
			}
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Users selectOneUser(String id){
		Users result = null;
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM user "
				+ "WHERE jumin = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String user_ID = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String gender = rs.getString(4);
				String jumin = rs.getString(5);
				String e_Mail = rs.getString(6);
				String period = rs.getString(7);
				String classRoom = rs.getString(8);
				result = new Users(user_ID, password, name, gender, jumin, e_Mail, period, classRoom);
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
