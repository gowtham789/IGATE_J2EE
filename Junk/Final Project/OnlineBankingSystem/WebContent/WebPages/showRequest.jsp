<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>service status</title>
<link rel="stylesheet" href="WebPages/home.css"/>
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
	<c:redirect url="/LoginRequest"/>
<%} %>
<body  onload="disableclick();">
<center>

<c:if test="${Cheqreq==1}">
<h2><font color="red">Your Request For Cheque book is Already Opened
<br> Check Status to know more info</font></h2>
<center>
<br>
<br><a href="firstpage">Go Back To Home Page</a></center>
</c:if>

<c:if test="${Cheqreq!=1}">
<h2 >Account Number Selected is ${acc}</h2>
<br><br>
<h3 >The Service ID is ${serv}</h3>
<br>
<br>
<center>
<br>
<br><a href="firstpage">Go Back To Home Page</a></center>
</c:if>
</center>
</body>
</html>