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

<div id="min">Change Mobile Number</div><br><br>

<div align="center">
<form name="changaddr" action="UpdateMobileNum" method="post">
<table>

<tr>
<td>New MobileNumber<font color="red">*</font></td>
<td><input type="text" name="mbno" pattern="[7|8|9][0-9]{9}" 
oninvalid="this.setCustomValidity('Enter Valid number')"
			onchange="this.setCustomValidity('')" maxlength="10" ></td>
</tr>

<tr>
<td><input type="submit" id="button" value="Submit"/></td>
<td><input type="reset" id="button" value="Reset" /></td></tr>

</table>
</form>
</div>
</body>
</html>