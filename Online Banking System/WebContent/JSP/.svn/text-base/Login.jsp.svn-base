<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will shown for customer after selecting customer,
 				  from first page and ask user credintails 
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Banking System</title>
<link href="JSP/Login.css" type="text/css" rel="stylesheet"/>
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
<body  onload="disableclick();">
<div class="d">

<div class="d1">
<img src="JSP/logo.PNG" width="150px" height="100%" align="left" style="border-radius:10px "/>
	<h4 class="bank" align="center" clear="right" >Capge Bank</h4>
	
</div>


<div class="d2">

<marquee><h1 style="color:#0066CC" align="center">ANYTIME..!!!<br>ANYWHERE...!!!</h1><br></marquee>
<h2 style="color:purple;" align="center">All your accounts are now at your fingertips.<br>View your accounts,transfer funds and pay your bills,<br>all with a click</h2>

<ul>
<li style="list-style: disc;">
	 CapgeBank  started with the unique distinction of being the central bank of Chennai, 	

 	   covering present-day Hyderabad, karnataka, Mumbai, Delhi and so on to manage its           

                    currency.
</li></ul>

</div>

<div class="d3">
	<div class="user">
	<c:if test="${user==1}">
	<h4><font color="red">Please Enter a valid userid and password </font></h4>
	</c:if>
	<c:if test="${exception==1}">
	<h4><font color="red">Problem with database server please try again later</font></h4>
	</c:if>
	<c:if test="${statusfail==1}">
	<h4><font color="red">Your Account Is Locked Please Try again Later </font></h4>
	</c:if>
	
		<form:form  action="UserLogin.obj" modelAttribute="udto">
			<table class="table" cellspacing="10">
				<tr class="uname" align="center">
				<td><b>UserName:</b></td>
				<td><form:input path="userId" required="true" />  </td>
				</tr>

				<tr>
				<td><b>Password:</b></td>
				<td><form:password path="loginPwd"  required="true"/>  </td>
				</tr>
			    <tr></tr>
				<tr>
					<td><input type="submit" id="button" value="Login" /></td>
					<td><input type="reset" id="button" value="Cancel"/></td>
				</tr>
				<tr><td></td><td><a href="forgot.obj" target="d3">Forgot Password?</a></td></tr>
			</table>
		</form:form>
	</div>
</div>
<div class="d4">
<h4 align="center"> &copy;Copyright Capge Bank</h4></div>

</div>
</body>
</html>