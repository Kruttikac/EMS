package com.ems.service;

import javax.servlet.http.HttpServletRequest;

import com.ems.bean.SecDetsBean;

public class SecProfService {
	public SecDetsBean getSecProfile(HttpServletRequest request) {
		SecDetsBean secProfile=new SecDetsBean();
		secProfile.setDepName(request.getParameter("depName"));
		secProfile.setDepRel(request.getParameter("depRel"));
		secProfile.setContact(Integer.parseInt(request.getParameter("contact")));
		secProfile.setBloodGroup(request.getParameter("bloodGrp"));
		secProfile.setEmail(request.getParameter("email"));
		secProfile.setPanNum(request.getParameter("panNum"));
		secProfile.setConfStat(false);
		return secProfile;
		
	}
}
