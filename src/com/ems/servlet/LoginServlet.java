package com.ems.servlet;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.dao.ProfileDAO;
import com.ems.service.LoginService;
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
			
		LoginBean user=null;
		ProfileBean profile=null;
		ProfileDAO profDAO=new ProfileDAO();
		int userName=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		System.out.println(session+" session");
		if(0 != userName && null != password) {
			LoginService service=new LoginService();
			user=service.checkIfValidUser(userName, password);
			
			if(user.getAccessLevel() != null) {	
				profile=profDAO.getUser(user);
				request.setAttribute("user",user);
				request.setAttribute("profile",profile);
				request.getSession().setAttribute("profile",profile);
				request.getSession().setAttribute("user",user);
				RequestDispatcher view=request.getRequestDispatcher("Employee.jsp");
				view.forward(request,response);	
			}
			else {
				System.out.println("Invalid Employee ID/Password");
			}
		    
		}
		else{
		
			System.out.println("ERROR!");
		}
		
	}
}