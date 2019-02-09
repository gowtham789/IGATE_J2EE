<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="WebPages/home.css"/>
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
<div align="center">
<h1>Select Account to get transaction</h1>
<form action="../gettransacs" method="get">

<table >
<tr><td><br></td></tr>
<tr>
<td>Select Account:</td>
<td><select name="Accountid" required><font color="red">*</font>
<option value="">--Select--</option>
<c:forEach var="ids" items="${allids}">
	<option value="<c:out value="${ids}"/>"><c:out value="${ids}"/></option>
	</c:forEach>
</select></td></tr>
<tr><td><br></td></tr>
<tr><td><input type="submit" id="button" value="Submit"/></td></tr>
</table>
<br>
<br>
<br>
<a href="../getalltrans">Click here to get all transactions of all accounts</a>
</form>
</div>
</body>
</html>