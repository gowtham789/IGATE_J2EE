<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link  rel="stylesheet" href="WebPages/home.css"/>
</head>
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
<div id="min" align="center">Enter Transaction Password to transfer fund</div>
<form action="./valdfun" method="post">
<table>
<tr>
<td>Enter Transaction Password <font color="red">*</font></td>
<td><input type="text" name="tpass"/></td>
</tr>
<tr><td colspan="2"><input type="submit" id="button" value="submit"/></td></tr>
</table>
</form>
</body>
</html>