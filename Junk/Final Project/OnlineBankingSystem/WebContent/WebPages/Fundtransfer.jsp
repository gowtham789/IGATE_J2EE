<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<c:redirect url="/LoginRequest"/>
<%} %>
<body  onload="disableclick();">

	<div id="min">Fund Transfer</div>
			<div align="center">
			
			<br>
	<h3>Here You can transfer fund to your own account</h3>		
			<br>
	<form name="trans" action="./fundtrans" method="post">
	
	<table>
	<tr>
		<td>Select From Account<font color="red">*</font></td>
		<td><select name="fromacct" required>
		<option value="">Select</option>
		<c:forEach var="ids" items="${acctid}">
		<option value="<c:out value="${ids}"/>"><c:out value="${ids}"/></option>
		</c:forEach>
		</select></td>
	</tr>
	
	<tr><td><br></td></tr>
	<tr>
		<td>Select To Account<font color="red">*</font></td>
		<td><select name="toacct" required>
		<option value="">Select</option>
		<c:forEach var="ids" items="${acctid}">
		<option value="<c:out value="${ids}"/>"><c:out value="${ids}"/></option>
		</c:forEach>
		</select></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr>
	<td>Enter Amount to Transfer<font color="red">*</font></td>
	<td><input type="text" name="amount" pattern="[0-9]+" 
	oninvalid="this.setCustomValidity('Enter Valid amount')"
			onchange="this.setCustomValidity('')" maxlength="6" required/></td>
	</tr>
	<tr><td><br></td></tr>
	</table>
	<br>

<input type="submit" id="button" value="Submit"/>
<br><br><h3>Click below link to transfer fund to others account of same bank</h3>	
<br>
<a href="./MakeTransfer">Make A Transfer</a>
	</form>
	</div>
</body>
</html>