<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" refresh="5">
<title>Insert title here</title>
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
<div id="min" align="center">Change Address</div><br><br>

<div align="center">
<form name="changaddr" action="UpdateAddress" method="get">
<table>

<tr>
<td>New Address:</td>
<td><textarea rows="3" name="newaddr" required></textarea></td>
</tr>


<tr>
<td><input type="submit" id="button" value="Submit"/></td>
<td><input type="reset" id="button" value="Reset" /></td></tr>

</table>

</form>
<br>
<br>
<a href="changeaddr" target="_top">Go Back</a>
</div>
</body>
</html>