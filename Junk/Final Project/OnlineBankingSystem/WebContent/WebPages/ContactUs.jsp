<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
Mail us:<br>
support@capge.com<br>
capgebank@capge.com<br>
<br>
Address:<br>
Capge Bank,<br>
Sipcot IT park,Rajiv gandhi salai(IT Highway) siruseri,<br>
chennai-603111<br>
TelNo: +919948099870<br>
Fax:+91-44-47441122<br>
<br>
<br>
<a href="Home" target="_top">Go Back to Home Page</a>
</body>
</html>