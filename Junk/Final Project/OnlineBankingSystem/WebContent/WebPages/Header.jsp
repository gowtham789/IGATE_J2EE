<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<style type="text/css">
h1{
text-align: center;
text-shadow: -5px 5px 5px aqua;
font-size: 40px;
font-family: Monotype Corsiva;
color:#808080;
}
</style>
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
	<c:redirect url="/LoginRequest"></c:redirect>
<%} %>
<body  onload="disableclick();">
<h3 align="right">Logged by ${user}</h3>
<h1>Welcome To Online Banking System</h1>

</body>
</html>