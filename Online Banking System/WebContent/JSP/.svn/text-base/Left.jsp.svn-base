<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, all the customer operations are shown(links)
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link  rel="stylesheet" href="JSP/Home.css"/>
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
	<c:redirect url="LoginRequest.obj"></c:redirect>
<%} %> 
<body  onload="disableclick();">
<div id="min" align="center">Quick Links</div>
<br>

<ul>
<li><a href="firstpage.obj" target="right">Account Summary</a></li><br>
<li><a href="changeaddr.obj" target="right">Change Address</a></li><br>
<li><a href="ministat.obj" target="right">Mini Statement</a></li><br>
<li><a href="fundtransfer.obj" target="right">Fund Transfer</a></li><br>
<li><a href="cheqreq.obj" target="right">Request for cheque book</a></li><br>
<li><a href="track.obj" target="right">Track service request</a></li><br>
<li><a href="chnpss.obj" target="right">Change password</a></li>
</ul>

</body>
</html>