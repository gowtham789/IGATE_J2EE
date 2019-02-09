<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is home page of the application
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Banking System</title>
<link rel="stylesheet" href="JSP/Login.css"/>
<style type="text/css">
#button1
{
	border-radius:15px;
	width: 80px;
	height: 35px;
	font-family:Monotype Corsiva;
	font-weight:bold;
	font-size:20px;
	background-color:#c4ffff;
}</style>
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
	<c:if test="${lock==1}">
	<h4><font color="red">Your Account is locked please try after some time </font></h4>
	</c:if>
	
		<form action="loginpage.obj">
			<table class="table" align="center"  cellpadding="15">
				<tr class="uname"><td><b>Type of User:</b><font color="red">*</font></td>
					<td><select name="role" required>
					<option value="">--Select--</option>
					<option value="admin">Admin</option>
					<option value="customer">Customer</option></select></td>
				</tr>
				
				<tr>
					<td><input type="submit" id="button1" value="Submit" /></td>
					<td><input type="reset" id="button1" value="Cancel"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<div class="d4">
<h4 align="center"> &copy;Copyright Capge Bank</h4></div>

</div>
</body>
</html>