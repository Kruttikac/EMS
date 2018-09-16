<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
	<head>
   		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
   		<title>Welcome Employee!</title>
   		<link href="css/Left-Menu/accordionmenu[2].css" rel="stylesheet" type="text/css" />
		<script src="JS/accordionmenu.js" type="text/javascript"></script>
	</head>
<body>
<div id="acdnmenu">
<c:set var="accessLevel" value="${sessionScope.user.accessLevel}" scope="session" />
    <ul>
        <li>My Profile
            <ul>
                <li>View
                    <ul>
                        <li><a target="right" href="ProfileViewServlet">Primary Details</a></li>
                        <li><a target="right" href="SecDetsViewServlet">Secondary Details</a></li>
                    </ul>
                </li>
                <li><a target="right" href="ProfileEditServlet">Edit</a></li>
            </ul>
        </li>
        <li>My Bank Details
            <ul>
                <li><a target="right"  href="BankViewServlet">View</a></li>
                <li><a target="right" href="BankEditServlet">Edit</a></li>
            </ul>
        </li>
        <li><a href="#">View Request History</a></li>
        <li id="li4"><a target ="right" href="ChangePassword.jsp">Change Password</a></li>
     	 <c:if test="${accessLevel==2 || accessLevel==4}">
        <li id="li5"><a href="#">View Approval History</a></li>
        </c:if>
        <c:if test="${accessLevel==3 || accessLevel==4}">
        <li id="li6"><a href="#">View Approval History</a></li>
        <li id="li7"><a href="#">Stop Pay</a></li>
        <li id="li8"><a href="#">Trigger Salary Details</a></li>
        </c:if>
    </ul>	
</div>

</body>
</html>