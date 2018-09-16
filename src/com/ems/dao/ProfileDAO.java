package com.ems.dao;

import java.sql.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.db.DBConnection;

public class ProfileDAO {

	public ProfileBean getUser(LoginBean user) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		ProfileBean profile=new ProfileBean();
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="Select \"Addr\",\"FN\",\"MN\",\"LN\",\"Dept\",\"MobNum\",\"Qualf\",\"Desig\",\"DOB\",\"EmployeeID\",\"DOJoining\",\"DOCreation\",\"DOMod\",\"ConfStat\" from \"Primary_Dets\" where \"EmployeeID\"=?";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
				pstmt.setInt(1,user.getEmpId());
        		rs=pstmt.executeQuery();
        		while(rs.next()) {
	        		profile.setAddr(rs.getString(1));
	        		profile.setFn(rs.getString(2));
	        		profile.setMn(rs.getString(3));
	        		profile.setLn(rs.getString(4));
	        		profile.setDept(rs.getString(5));
	        		profile.setMob(rs.getInt(6));
	        		profile.setQualf(rs.getString(7));
	        		profile.setDesig(rs.getString(8));
	        		profile.setDob(rs.getDate(9));
	        		profile.setEmpId(rs.getInt(10));
	        		profile.setDoj(rs.getDate(11));
	        		profile.setDoc(rs.getDate(12));
	        		profile.setDom(rs.getDate(13));
	        		profile.setConfStat(rs.getBoolean(14));
	        	}
        	}
        	 System.out.println("dao "+profile);
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
	public void setUser(ProfileBean profile) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="INSERT INTO \"Primary_Dets\" " +
        			"(\"Addr\"," +
        			"\"FN\"," +
        			"\"MN\"," +
        			"\"LN\"," +
        			"\"Dept\"," +
        			"\"MobNum\"," +
        			"\"DOMod\"," +
        			"\"Qualf\"," +
        			"\"Desig\"," +
        			"\"DOB\"," +
        			"\"EmployeeID\","+
        			"\"DOJoining\"," +
        			"\"DOCreation\"," +
        			"\"ConfStat\")" +
        			" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
        		pstmt.setString(1,profile.getAddr());
        		pstmt.setString(2,profile.getFn());
        		pstmt.setString(3,profile.getMn());
        		pstmt.setString(4,profile.getLn());
        		pstmt.setString(5,profile.getDept());
        		pstmt.setInt(6,profile.getMob());
                pstmt.setDate(7,profile.getDom()); 
				pstmt.setString(8,profile.getQualf());
				pstmt.setString(9,profile.getDesig());
				pstmt.setDate(10,profile.getDob());
				pstmt.setInt(11,profile.getEmpId());
				pstmt.setDate(12,profile.getDoj());
				pstmt.setDate(13,profile.getDoc());	
				pstmt.setBoolean(14,false);
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