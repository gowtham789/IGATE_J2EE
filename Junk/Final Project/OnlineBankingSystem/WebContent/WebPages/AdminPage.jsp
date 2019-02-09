<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="WebPages/home.css"/>
<script type="text/javascript">
	document.onmousedown=disableclick;
	function disableclick()
	{
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
<iframe id="header" height="30%" width="96%" src="WebPages/Header.jsp"></iframe>

<iframe id="left" height="400px" width="25%" src="WebPages/AdminHome.jsp"></iframe>

<iframe id="right" name="right" src="WebPages/WelAdmin.jsp" height="400px" width="69%"></iframe>

<iframe id="footer" height="70px" width="96%" src="WebPages/Footer.jsp"> </iframe>
</body>
</html>