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
<div id="min" align="center">Quick Links</div>
<br>

<ul>
<li><a href="firstpage" target="right">Account Summary</a></li><br>
<li><a href="changeaddr" target="right">Change Address</a></li><br>
<li><a href="ministat" target="right">Mini Statement</a></li><br>
<li><a href="fundtransfer" target="right">Fund Transfer</a></li><br>
<li><a href="cheqreq" target="right">Request for cheque book</a></li><br>
<li><a href="track" target="right">Track service request</a></li><br>
<li><a href="chnpss" target="right">Change password</a></li>
</ul>

</body>
</html>