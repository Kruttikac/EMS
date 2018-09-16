<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ems.bean.SecDetsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body {
		text-align:center;
		background: #0ca3d2;
	}
</style>
</head>
<body>
	<%SecDetsBean secProfile=(SecDetsBean)session.getAttribute("secProfile"); %>
	Dependence Name:<%=secProfile.getDepName() %><br>
	Dependence Relation:<%=secProfile.getDepRel() %><br>
	Contact Number:<%=secProfile.getContact() %><br>
	Email:<%=secProfile.getEmail() %><br>
	PAN Number:<%=secProfile.getPanNum() %><br>
	Library Number:<%=secProfile.getLibNum() %><br>
</body>
</html>