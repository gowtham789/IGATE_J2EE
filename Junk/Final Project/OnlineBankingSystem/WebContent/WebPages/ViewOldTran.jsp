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
<div id="min">Get Detailed Transactions of Your Account</div>
<br>
<br>
<form action="oldTran" method="post">
<table>
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
<td>Enter Start Date<font color="red">*</font></td>
<td><input type="date" value="From" name="startDate" max="" required/></td></tr>

<tr><td><br></td></tr>

<tr>
<td>Enter End Date<font color="red">*</font></td>
<td><input type="date" value="To" name="endDate"  required/></td></tr>
<tr><td><br></td></tr>
<tr><td><br></td></tr>
<tr><td colspan="2" align="center"><input type="submit"  id="button" value="submit"></td></tr>

</table>
</form>
<br>
<br>
<a href="ministat" target="_top"></a>
</div>
</body>
</html>