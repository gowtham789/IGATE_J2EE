<%@ page import="com.igate.obs.dto.CustomerDTO"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will current customer details,
 				  after selecting the account id and displayed from this page itself
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="JSP/Home.css"/>
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
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body  onload="disableclick();">
<c:if test="${fail==1}">
<h3><font color="red">Due to technical Problem Address has not Updated please try again later</font></h3>
</c:if>
<c:if test="${failmob==1}">
<h3><font color="red">Due to technical Problem Mobile Number has not Updated please try again later</font></h3>
</c:if>
<c:if test="${dto==1}">
<% CustomerDTO accoId = (CustomerDTO)session.getAttribute("accdto"); %>
<% if(accoId!= null) 
{ %>
<div id="min" align="center">Selected Account details</div>
<br>
<br>
<table align="center" border="2">
<tr><td>accountId</td><td><%=accoId.getAccountId() %></td></tr>
<tr><td>CustomerName</td><td><%=accoId.getCustName()%></td></tr>
<tr><td>emailId</td><td><%=accoId.getEmail() %></td></tr>
<tr><td>Address</td><td><%=accoId.getAddress() %></td></tr>
<tr><td>Pancard</td><td><%=accoId.getPancard()%></td></tr>
<tr><td>Mobile Number</td><td><%=accoId.getMobileNumber()%></td></tr>
<tr><td  rowspan="2" align="center">UpdateDetails</td>
<td><a href="UpdateAddr.obj">ChangeAddress</a></td></tr>
<tr><td><a href="UpdateMob.obj">ChangeMobile</a></td></tr>

<% } %>
</table>
<br>
<br>
<br>
<a href="changeaddr.obj">Go Back</a>
</c:if>
<c:if test="${addr==1}">
<div align="center">
<div id="min" align="center">Select Account to get details</div>
<form action="CurrAddr.obj" name="current" method="post">

<table >
	<tr><td><br></td></tr>
	<tr>
	<tr>
	<td>Select Account<font color="red">*</font></td>
	<td><select name="accountId" required="true">
	<option value="">--Select--</option>
	<c:forEach var="ids" items="${acctid}">
	<option value="<c:out value="${ids.accountId}"/>"><c:out value="${ids.accountId}"/></option>
	</c:forEach>
	</select></td></tr>
	<tr><td><br></td></tr>
	<tr><td><br></td></tr>
	<tr><td><input type="submit" id="button" value="Submit"/></td></tr>
	</table>

</form>
</div>
<br>
<br>
<a href="Home.obj">Go Back</a>
</c:if>
</body>
</html>