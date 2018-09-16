package com.ems.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.BankBean;
import com.ems.dao.BankingDAO;
import com.ems.service.BankEditService;
 public class BankSubmitServlet extends HttpServlet{
 	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		BankBean bank=null;
 		BankingDAO bankDao=new BankingDAO();
 		BankEditService service=new BankEditService();
 		bank=service.getBank(request);
 		bankDao.setBankDetails(bank); 		
	}   	  	    
}
