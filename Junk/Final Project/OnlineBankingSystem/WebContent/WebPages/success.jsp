<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div align="center">
<br>
<br>
<h2>Updated Successfully!!!!!!</h2>

<table border="2">
	
	<tr><th>Account Id</th><td>${cust.accountId}</td></tr>
	<tr><th>Customer Name</th><td>${cust.custName}</td></tr>
	<tr><th>Email Id</th><td>${cust.email}</td></tr>
	<tr><th>Address</th><td>${cust.address}</td></tr>
	<tr><th>PanCard</th><td>${cust.pancard}</td></tr>
	<tr><th>Mobile Number</th><td>${cust.mobileNumber}</td></tr>
</table>
<br>
<br>
<a href="Home" target="_top">HomePage</a>

</div>
</body>
</html>