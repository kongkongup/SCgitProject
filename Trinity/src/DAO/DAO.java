package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTIL.ConnectionManager;
import VO.Client;

public class DAO {
	public int insert(Client client){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "INSERT INTO members "
				+ "VALUES "
				+ "( "
				+ "seq.NEXTVAL,?,?,?,?,?,?,? "
				+ ")";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,client.getMember_Password());
			pstmt.setString(2,client.getMember_Gender());
			pstmt.setInt(3,client.getMember_Age());
			pstmt.setString(4, client.getBirth());
			pstmt.setString(5, client.getMember_Phone());
			pstmt.setString(6, client.getMember_Address());
			pstmt.setString(7, client.getMember_Email());
			result = pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Client client){
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		String query = "UPDATE members "
				+ "SET "
				+ "member_Phone = ?, member_Address = ?, member_Email = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,client.getMember_Password());
			pstmt.setString(2,client.getMember_Gender());
			pstmt.setInt(3,client.getMember_Age());
			pstmt.setString(4, client.getBirth());
			pstmt.setString(5, client.getMember_Phone());
			pstmt.setString(6, client.getMember_Address());
			pstmt.setString(7, client.getMember_Email());
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
	
	public ArrayList<Client> select(int id){
		ArrayList result = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM CLIENT "
				+ "WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Client selectOne(){
		Client result = null;
		return result;
	}
	
}
