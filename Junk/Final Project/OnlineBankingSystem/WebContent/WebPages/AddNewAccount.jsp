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

<br/>
<div id="min" align="center"> Add New Account</div><br>
<form action="AddCustomer" method="post" name="AddUser">
<table align="center" >

	 <tr><th> Customer Name:<font color="red">*</font></th>
	 <td><input type="text" name="custName" pattern="[A-Za-z]+\s[A-Za-z]*" required/></td></tr>
	 
	<tr><th> Address:<font color="red">*</font></th>
	<td><textarea name="address" required></textarea></td></tr>
	
	<tr><th> Mobile Number:<font color="red">*</font></th>
	<td><input type="text" name="mobileNumber" pattern="[7|8|9][0-9]{9}" required/></td></tr>
	
	<tr><th> Email Id:<font color="red">*</font></th>
	<td><input type="Email" name="email" pattern="[A-Za-z0-9]+@[a-z]+.com" required/></td></tr>
	
	<tr><th> Pancard Number:<font color="red">*</font></th>
	<td><input type="text" name="pancard" pattern="[A-Za-z0-9]+" required/></td></tr>
	
	<tr><th> Account Type:<font color="red">*</font></th>
	<td><input type="text" name="accountType" pattern="[A-Za-z]+" required/></td></tr>
	
	<tr><th> Opening Balance:<font color="red">*</font></th><td>
	<input type="text" name="accountBalance" pattern="[1-9][0-9]+" required/></td></tr>
	
	<tr><th> Opening Date:<font color="red">*</font></th><td>
	<input type="Date" name="openDate" required/></td></tr>
	
	<tr><th> Create a User Id:<font color="red">*</font></th><td>
	<input type="text" name="userId" pattern="[A-Za-z0-9]+" required/></td></tr>
	
	<tr><th> Password:<font color="red">*</font></th><td>
	<input type="Password" name="loginPwd" pattern="[A-Za-z0-9]+" required/></td></tr>
	
	<tr><th> Lock Status:<font color="red">*</font></th><td>
	<input type="text" name="lockStatus" pattern="[L|U]" required/></td></tr>
	
	<tr><th> Secret Question:<font color="red">*</font></th><td>
	<select name="secretQuest" required >
	<option value="">--Select--</option>
	<c:forEach var="quest" items="${questions}">
	<option value="${quest}">"${quest}"</option>
	</c:forEach>
	</select></td></tr>
	
	<tr><th> Answer:<font color="red">*</font></th><td>
	<input type="text" name="ans" pattern="[A-Za-z0-9]+" required/></td></tr>
	
	<tr><th> Transaction Password:<font color="red">*</font></th><td>
	<input type="text" name="transactionPwd" pattern="[A-Za-z0-9]+" required/></td></tr>
	
	<tr><th colspan="2"><input type="submit" id="button" value="Register" /></th></tr>
</table>
</form>
</body>
</html>