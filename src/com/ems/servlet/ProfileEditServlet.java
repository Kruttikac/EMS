package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.bean.SecDetsBean;
import com.ems.dao.ProfileDAO;
import com.ems.dao.SecDetsDAO;


 public class ProfileEditServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   ProfileBean profile=null;
		   SecDetsBean secProfile=null;
		   LoginBean user=null;
		   ProfileDAO profDao=new ProfileDAO();
		   SecDetsDAO sdDao=new SecDetsDAO();
		   user=(LoginBean)(request.getSession().getAttribute("user"));
		   if(user != null) {
			   profile=profDao.getUser(user);
			   secProfile=sdDao.getUser(user);
			   request.getSession().setAttribute("secProfile",secProfile);
			   request.getSession().setAttribute("profile",profile);
			   RequestDispatcher view=request.getRequestDispatcher("ProfileEdit.jsp");
			   view.forward(request,response);
		   }
    }
 }