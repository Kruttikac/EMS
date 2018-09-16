<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form id="changePass" name="changePass" action="PasswordServlet" method="post">
	Enter your old Password:<input type="password" id="oldPass" name="oldPass"/><br>
	Enter your new Password:<input type="password" id="newPass" name="newPass"/><br>
	Confirm your new password:<input type="password" id="confPass" name="confPass"/><br>
    <input type="submit" />
  </form>

</body>
</html>