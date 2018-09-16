<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ems.bean.BankBean" %>
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
	   <jsp:useBean id="bankBean" class="com.ems.bean.BankBean" scope="session" />
		<h1>Bank Details</h1>
		Bank Name:<jsp:getProperty name="bankBean" property="bankName" />
		<br>
		Branch Name:<jsp:getProperty name="bankBean" property="branchName" />
		
		<br>
		Account number:<%=(((BankBean)session.getAttribute("bankBean")).getAccNum()) %>
		<br>
		<hr>
		IFSC code:<jsp:getProperty name="bankBean" property="ifscCode" />
		
		
		<hr>
		
</body>
</html>