<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "com.ems.bean.BankBean" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body {
		text-align:center;
		background: #0ca3d2;
	}
	#bank {
		text-align:center;
	}
</style>
</head>
<body>
	<div id="bank">
		<h1>Please enter your Details</h1><br>
		<% 
		   BankBean bank=(BankBean)session.getAttribute("bankBean"); 
     	%>
		<form id="BankForm" method="post" action="BankSubmitServlet">	
			<table>
			<tr><td>Bank Name:</td><td><input id="bn" type="text" name="bankname" value="<%=bank.getBankName()%>" /></td></tr>
			<tr><td>Branch Name:</td><td><input id="brn" type="text" name="branchname" 
							value="<%=bank.getBranchName()%>"/></td></tr>
			<tr><td>Account Number:</td><td><input id="an" type="text" name="accnum" 
						     value="<%=bank.getAccNum()%>"/></td></tr>
			<tr><td>IFSC code:</td><td><input id="code" type="text" name="code" 
							value="<%=bank.getIfscCode()%>"/></td></tr>
			</table>
			<input type="submit" value="UPDATE" > 
</form>
</div>
<script>

</script>

</body>
</html>