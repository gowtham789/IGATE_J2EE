<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
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
	<c:redirect url="/LoginRequest"></c:redirect>
<%} %>
<body  onload="disableclick();">
<br>
<table align="center">
<tr><td>Mybank&copy; Copyright</td>
<td>&nbsp;</td>
<td><a href="Aboutus" target="right">AboutUs</a></td>
<td>&nbsp;</td>
<td><a href="Service" target="right">Services</a></td>
<td>&nbsp;</td>
<td><a href="Contactus" target="right">ContactUs</a></td>
<td>&nbsp;</td>
<td><a href="HelP" target="right">Help</a></td>
<td>&nbsp;</td>

<td><a href="Logout" target="_top">Logout</a></td>

</tr>

</table>
</body>
</html>