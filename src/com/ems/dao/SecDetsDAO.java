package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.bean.LoginBean;
import com.ems.bean.SecDetsBean;
import com.ems.db.DBConnection;

public class SecDetsDAO {
	public SecDetsBean getUser(LoginBean user) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		SecDetsBean profile=new SecDetsBean();
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="SELECT \"DepName\"," +
        			"\"DepRel\"," +
        			"\"Contact\"," +
        			"\"Email\"," +
        			"\"BloodGroup\"," +
        			"\"PanNum\"," +
        			"\"LibNum\"," +
        			"\"EmployeeID\", " +
        			"\"ConfStat\" " +
        			"from \"Secondary_Dets\" " +
        			"where \"EmployeeID\"=?";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
				pstmt.setInt(1,user.getEmpId());
        		rs=pstmt.executeQuery();
        		while(rs.next()) {
	        		profile.setDepName(rs.getString(1));
	        		profile.setDepRel(rs.getString(2));
	        		profile.setContact(rs.getInt(3));
	        		profile.setEmail(rs.getString(4));
	        		profile.setBloodGroup(rs.getString(5));
	        		profile.setPanNum(rs.getString(6));
	        		profile.setLibNum(rs.getInt(7));
	        		profile.setEmployeeId(rs.getInt(8));
	        		profile.setConfStat(rs.getBoolean(9));
	        		
	        	}
        	}
        	 
        }
       
        catch(Exception ex) {
           ex.printStackTrace();
        }
        finally{
        	try {
        	if(null!=con){        		
				con.commit();				
        		con.close();
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
        return profile;
	}
	public void setUser(SecDetsBean profile) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="INSERT INTO \"Secondary_Dets\" " +
        			"(\"DepName\"," +
        			"\"DepRel\"," +
        			"\"Contact\"," +
        			"\"Email\"," +
        			"\"BloodGroup\"," +
        			"\"PanNum\"," +
        			"\"LibNum\"," +
        			"\"EmployeeID\"," +
        			"\"ConfStat\" )" +
        			" VALUES(?,?,?,?,?,?,?,?,?)";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
        		pstmt.setString(1,profile.getDepName());
        		pstmt.setString(2,profile.getDepRel());
        		pstmt.setInt(3,profile.getContact());
        		pstmt.setString(4,profile.getEmail());
        		pstmt.setString(5,profile.getBloodGroup());
        		pstmt.setString(6,profile.getPanNum());
                pstmt.setInt(7,profile.getLibNum()); 
				pstmt.setInt(8,profile.getEmployeeId());
				pstmt.setBoolean(9,false);
        		pstmt.executeUpdate();
        	}
        }
        catch(Exception ex) {
           ex.printStackTrace();
        }
        finally{
        	try {
        	if(null!=con){        		
				con.commit();				
        		con.close();
        	}
        	if(null!=pstmt){  
        		pstmt.close();
        	}
        	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}


