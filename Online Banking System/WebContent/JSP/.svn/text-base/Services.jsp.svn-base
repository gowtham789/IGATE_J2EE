<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will shown after clicking services of capge bank,
 				  from admin or customer home page
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link  rel="stylesheet" href="WebPages/home.css"/>
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
<ul>
<li>
 Electronic FundTransfer System.</li>
 <li>
 Safe Deposit Lockers.</li>
 <li>
 Check Collection Policy.</li>
 <li>
 MiniStatement Details.</li>
 <li>
  Track service requests.</li>
</ul>
<a href="Home.obj">Go Back to Home Page</a>
</body>
</html>