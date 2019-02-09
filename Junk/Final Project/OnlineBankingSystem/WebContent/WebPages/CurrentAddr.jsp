<%@ page import="com.cg.onlinebanking.dto.CustomerDTO"%>
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

<div align="center">
<div id="min" align="center">Select Account to get details</div>
<form action="CurrAddr" name="current" method="post">

<table >
	<tr><td><br></td></tr>
	<tr>
	<td>Select Account<font color="red">*</font></td>
	<td><select name="Accountid" required>
	<option value="">--Select--</option>
	<c:forEach var="ids" items="${acctid}">
	<option value="<c:out value="${ids}"/>"><c:out value="${ids}"/></option>
	</c:forEach>
	</select></td></tr>
	<tr><td><br></td></tr>
	<tr><td><br></td></tr>
	<tr><td><input type="submit" id="button" value="Submit"/></td></tr>
	</table>

</form>
</div>

<% CustomerDTO accoId = (CustomerDTO)request.getAttribute("accdto"); %>
<% if(accoId!= null) 
{ %>
<br/>
<br/>
<table align="center" border="2">
<tr><td>accountId</td><td><%=accoId.getAccountId() %></td></tr>
<tr><td>CustomerName</td><td><%=accoId.getCustName()%></td></tr>
<tr><td>emailId</td><td><%=accoId.getEmail() %></td></tr>
<tr><td>Address</td><td><%=accoId.getAddress() %></td></tr>
<tr><td>Pancard</td><td><%=accoId.getPancard()%></td></tr>
<tr><td>Mobile Number</td><td><%=accoId.getMobileNumber()%></td></tr>
<tr><td  rowspan="2" align="center">UpdateDetails</td>
<td><a href="UpdateAddr">ChangeAddress</a></td></tr>
<tr><td><a href="UpdateMob">ChangeMobile</a></td></tr>

<% } %>
</table>
<br>
<br>
<a href="firstpage">Go Back</a>
</body>
</html>