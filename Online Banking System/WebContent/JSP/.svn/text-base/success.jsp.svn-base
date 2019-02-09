<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will shown after successful updation of customer
 				  mobile and address
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="JSP/Home.css"/>
<script type="text/javascript">
	document.onmousedown=disableclick;
	function disableclick()
	{
	//location.replace("http://localhost:8080/OnlineNetBanking/Loginserv");
	if(event.button==2)
		{
		
		alert("Right Click Disabled for security purpose");
		return false;
		}
	}
</script>

</head>
<%if(session.getAttribute("user")==null)
	{%>
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body  onload="disableclick();">
<div align="center">
<br>
<br>
<h2>Updated Successfully!!!!!!</h2>

<table border="2">
	
	<tr><th>Account Id</th><td>${cust.accountId}</td></tr>
	<tr><th>Customer Name</th><td>${cust.custName}</td></tr>
	<tr><th>Email Id</th><td>${cust.email}</td></tr>
	<tr><th>Address</th><td>${cust.address}</td></tr>
	<tr><th>PanCard</th><td>${cust.pancard}</td></tr>
	<tr><th>Mobile Number</th><td>${cust.mobileNumber}</td></tr>
</table>
<br>
<br>
<a href="Home.obj">HomePage</a>

</div>
</body>
</html>