package com.ems.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.bean.SecDetsBean;
import com.ems.dao.ProfileDAO;
import com.ems.dao.SecDetsDAO;
import com.ems.service.ProfEditService;
import com.ems.service.SecProfService;

public class ProfileSubmitServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
			ProfileBean profile=null;
			ProfileDAO profileDao=null;
			SecDetsBean secProfile=null;
			SecDetsDAO sdDao=null;
			sdDao=new SecDetsDAO();
			profileDao=new ProfileDAO();
			ProfEditService service=new ProfEditService();
			SecProfService secService=new SecProfService();
			profile=service.getProfile(request);
			secProfile=secService.getSecProfile(request);
			secProfile.setEmployeeId(((LoginBean)request.getSession().getAttribute("user")).getEmpId());
			profile.setEmpId(((LoginBean)request.getSession().getAttribute("user")).getEmpId());
			profileDao.setUser(profile);
		    sdDao.setUser(secProfile);	
		}
	}