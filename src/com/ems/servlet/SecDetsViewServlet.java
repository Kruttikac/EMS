package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.LoginBean;
import com.ems.bean.SecDetsBean;
import com.ems.dao.SecDetsDAO;
public class SecDetsViewServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecDetsDAO sdDao=null;
		SecDetsBean sdBean=null;
		LoginBean user=null;
		user=(LoginBean)(request.getSession().getAttribute("user"));
		if(user != null) {
			sdDao=new SecDetsDAO();
			sdBean=sdDao.getUser(user);
			request.getSession().setAttribute("secProfile",sdBean);
		}
		RequestDispatcher view=request.getRequestDispatcher("SecondaryDetails.jsp");
		view.forward(request, response);
	}
}
			