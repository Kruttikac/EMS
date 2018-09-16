package com.ems.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.BankBean;
import com.ems.bean.LoginBean;
import com.ems.dao.BankingDAO;

 public class BankEditServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
	  BankBean bankBean=null;
	  LoginBean user=(LoginBean)(request.getSession().getAttribute("user"));
	  BankingDAO bankDao=new BankingDAO();
	  bankBean=bankDao.getBankDetails(user);
	  request.getSession().setAttribute("bankBean",bankBean);
	  RequestDispatcher view=request.getRequestDispatcher("BankEditView.jsp");
	  view.forward(request,response);
	  
   }
 }