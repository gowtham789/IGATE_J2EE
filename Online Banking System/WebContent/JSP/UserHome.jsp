<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer(customer home page frames)
 * Functionality: This is a Jsp, which will have frames of Customer Homepage
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Login Page</title>
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

<iframe name="header" id="header" scrolling="no" height="30%" src="headerpage.obj" width="96%"  onload="disableclick(); "></iframe>

<iframe name="left" id="left" src="leftpage.obj" height="400px" width="25%" >
</iframe>

<iframe name="right"id="right" src="rightpage.obj" height="400px" width="69%" >
</iframe>

<iframe name="footer" id="footer" height="70px" width="96%" src="bottomepage.obj" ></iframe>
</body>

</html>