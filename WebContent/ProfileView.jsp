<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ems.bean.ProfileBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
<style>
	body {
	text-align:center;
	background: #0ca3d2;

}
</style>	
</head>
<body>
<% ProfileBean prof=(ProfileBean) session.getAttribute("profile");  %>
	<div id="main">
		<h1>MY PROFILE</h1>	
         <jsp:useBean id="profile" class="com.ems.bean.ProfileBean" scope="session" />
		First Name:<jsp:getProperty name="profile" property="fn" />
		<br>
		Middle Name:<jsp:getProperty name="profile" property="mn" />
		
		<br>
		Last Name:<jsp:getProperty name="profile" property="ln" />
		
		<br>
		<hr>
		Address:<jsp:getProperty name="profile" property="addr" />
		
		<br>
		Date of birth:<%= prof.getDob() %>
		
		<br>
		Mobile Number:<jsp:getProperty name="profile" property="mob" />
		
		<br>
		<hr>
		Department:<jsp:getProperty name="profile" property="dept" />
		
		<br>
		Qualification:<jsp:getProperty name="profile" property="qualf" />
		
		<br>
		Designation:<jsp:getProperty name="profile" property="desig" />
		
		<br>
		<hr>
		Date of Joining:<%= prof.getDoj() %>
		<br>
		<hr>
	</div>
	
</body>
</html>