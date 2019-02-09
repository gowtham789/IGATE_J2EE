<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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
<div id="min">Services Request Status</div>
<br>
<form action="displayservice" name="track" method="post">
<table >

	<tr><td><br></td></tr>
	
	<tr><td><br></td></tr>
	
	<tr>
		<td>Select Account<font color="red">*</font></td>
		<td><select name="Accountid" required>
		<option value="">--Select--</option>
		<c:forEach var="ids" items="${acctid}">
			<option value="<c:out value="${ids}"/>"><c:out value="${ids}"/></option>
			</c:forEach>
		</select></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr>
	<td><input type="submit" id="button" value="Submit"/></td>
	<td><input type="reset" id="button" value="Reset" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>