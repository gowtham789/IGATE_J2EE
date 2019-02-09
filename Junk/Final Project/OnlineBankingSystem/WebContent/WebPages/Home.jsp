<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Login Page</title>
<link rel="stylesheet" href="Webpages/home.css"/>
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

<iframe name="header" id="header" scrolling="no" height="30%" src="headerpage" width="96%"  onload="disableclick(); "></iframe>

<iframe name="left" id="left" src="leftpage" height="400px" width="25%" >
</iframe>

<iframe name="right"id="right" src="rightpage" height="400px" width="69%" >
</iframe>

<iframe name="footer" id="footer" height="70px" width="96%" src="bottomepage" ></iframe>
</body>

</html>