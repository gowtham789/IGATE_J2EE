<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddPayee</title>
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

<div id="min" align="center"><h2>Add Payee Here</h2></div>
<div align="center">
<br>
<br>
<c:if test="${duplicpay==1 }">
<h3><font color="red">Payee Account Should be Different From Account Id</font></h3>
</c:if>


<c:if test="${paynotavail==1 }">
<h3><font color="red">Payee Account does not exists in this bank</font></h3>
</c:if>


<c:if test="${payavail==1 }">
<h3><font color="red">Payee Account Already Exists as your payee</font></h3>
</c:if>


<c:if test="${payaddid==1 }">
<h3><font color="green">Please enter a valid Payee account of this Bank</font></h3>
</c:if>

<c:if test="${valpay==1}">
Enter the number shown on the Screen&nbsp;&nbsp;${URN}
<br>
<br>
<form action="./valpayee" method="post">
<table>
<tr><td>Enter URN</td><td><input type="text" name="urn" placeholder="enter code"/></td></tr>
<tr><td><br></td></tr>
<tr><td colspan="2" align="center"><input type="submit" id="button" value="Submit"/></td></tr>
</table>
</form>
</c:if>
</div>
<div align="center">
<form name="addpayee" action="./Addedpayee" method="post">
	
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
	<tr>
	<td>Payee Id<font color="red">*</font></td>
	<td><input type="text" name="payeeid" pattern="[7][0-9]{7}" 
	oninvalid="this.setCustomValidity('Account number should be 8 digits starts with 7')"
			onchange="this.setCustomValidity('')" maxlength="8" required/></td>
	</tr>
	<tr>
	<td>Nick Name<font color="red">*</font></td>
	<td><input type="text" name="nickname" pattern="[A-Z-a-z]+" oninvalid="this.setCustomValidity('Account number should be 8 digits starts with 7')"
			onchange="this.setCustomValidity('')" required/></td>
	</tr>
	
	<tr><td><br></td></tr>
	<tr><td><input type="submit" id="button" value="AddPayee"/></td></tr>
	</table>
	</form>
	<br>
	<br>
	<br>
	<a href="MakeTransfer" target="right">Go Back</a>
</div>

</body>
</html>