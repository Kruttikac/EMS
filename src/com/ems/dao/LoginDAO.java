package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.db.DBConnection;

public class LoginDAO {

	public String checkIfValidUser(int userName, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String accessLevel=null;
		String sqlQuery="Select \"AccessLevel\" from \"Login_Dets\" where \"EmployeeID\"=? and \"Password\"=?";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				pstmt=conn.prepareStatement(sqlQuery);
				pstmt.setInt(1, userName);
				pstmt.setString(2, password);
				rs=pstmt.executeQuery();
				while(rs.next()){
					accessLevel=rs.getString(1);
				}
				System.out.println("accessLevel="+accessLevel);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
        	try {
        	if(null!=conn){        		
				conn.commit();				
        		conn.close();
        	}
        	if(null!=pstmt){  
        		pstmt.close();
        	}
        	if(null!=rs){ 		
        		rs.close();
        	}
        	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return accessLevel;
	}

}
