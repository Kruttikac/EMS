package com.ems.dao;
import java.sql.*;

import com.ems.bean.BankBean;
import com.ems.bean.LoginBean;
import com.ems.db.DBConnection;

public class BankingDAO {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sqlQuery=null;
	public BankBean getBankDetails(LoginBean user) {
		
		BankBean bank=new BankBean();
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="SELECT " 
	        		+ "\"EmployeeID\"," 
	        		+ "\"BankName\"," 
	        		+ "\"BranchName\"," 
	        		+ "\"IFSCcode\"," 
	        		+ "\"AccountNumber\"," 
	        		+ "\"ConfStat\" " 
	        		+ "FROM " + "\"Bank_Dets\" " 
	        		+ "WHERE \"EmployeeID\"=?";
        	
        	//
        	System.out.println("user.getEmpId() = " + user.getEmpId() );
        	//
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
				pstmt.setInt(1,user.getEmpId());
        		rs=pstmt.executeQuery();
        		while(rs.next()) {
        			bank.setEmpId(rs.getInt(1));
        			bank.setBankName(rs.getString(2));
        			bank.setBranchName(rs.getString(3));
        			bank.setIfscCode(rs.getString(4));
        			bank.setAccNum(rs.getInt(5));
        			bank.setConfStat(rs.getBoolean(6));
	        		
	        	}
        	}
        }
        catch(Exception ex) {
           ex.printStackTrace();
           if(null!=con){        		
        	   try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	}
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
        return bank;
	}
	public void setBankDetails(BankBean bank) {
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
			sqlQuery="INSERT INTO \"Bank_Dets\" " +
					"(\"EmployeeID\"," +
					"\"BankName\"," +
					"\"BranchName\"," +
					"\"IFSCcode\"," +
					"\"AccountNumber\"," +
					"\"ConfStat\") " +
					"VALUES(?,?,?,?,?,?)";
			if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
        		pstmt.setInt(1,bank.getEmpId());
        		pstmt.setString(2,bank.getBankName());
        		pstmt.setString(3,bank.getBranchName());
        		pstmt.setString(4,bank.getIfscCode());
        		pstmt.setInt(5,bank.getAccNum());
        		pstmt.setBoolean(6,false);
        		int rows=pstmt.executeUpdate();
        		System.out.println(rows+" rows");
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
	}
}