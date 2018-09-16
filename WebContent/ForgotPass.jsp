<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset your Password</title>
</head>
<body>
   <form action="ResetPassServlet" method="post" >
	Security Question:<%=request.getAttribute("quest") %><br>
	<input type="hidden" name="empId" value='<%= request.getParameter("empId")%>' />
	Enter your answer:<input type="text" id="answer" name="answer"/><br>
	Enter your new Password:<input type="password" id="newPass" name="newPass"/><br>
	Confirm your new password:<input type="password" id="confPass" name="confPass"/><br>
	<input type="submit" value="SUBMIT">
	</form>
</body>
</html>