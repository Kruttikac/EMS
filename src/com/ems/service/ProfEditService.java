package com.ems.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;

public class ProfEditService {
	public ProfileBean getProfile(HttpServletRequest request) {
		ProfileBean profile=new ProfileBean();
		LoginBean loginBean=(LoginBean) request.getSession().getAttribute("user");
		profile.setEmpId(loginBean.getEmpId());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date parsed = null;
		java.sql.Date sql =null;
		profile.setFn(request.getParameter("firstname"));
		profile.setMn(request.getParameter("middlename"));
		profile.setLn(request.getParameter("lastname"));
		profile.setAddr(request.getParameter("addr"));
		try {
		System.out.println(request.getParameter("dob"));
		parsed=format.parse(request.getParameter("dob"));
		sql=new java.sql.Date(parsed.getTime());
		profile.setDob(sql);
		
		profile.setMob(Integer.parseInt(request.getParameter("mob")));
		System.out.println(request.getParameter("dept")+" dept");
		profile.setDept(request.getParameter("dept"));
		System.out.println(profile.getDept());
		profile.setQualf(request.getParameter("qualf"));
		profile.setDesig(request.getParameter("desig"));
		
		parsed=format.parse(request.getParameter("dob"));
		sql=new java.sql.Date(parsed.getTime());
		profile.setDob(sql);
		parsed=format.parse(format.format(new Date()));
		profile.setDom(new java.sql.Date(parsed.getTime()));
		
		profile.setDoc(profile.getDom());
		profile.setDoj(profile.getDom());
	    
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return profile;
	   	}

}
