<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show after successfully answering the secret question
 				  so that it will ask for new passoword for updation
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.frgt
{
	position:relative;	
    margin-top:100px;
 	margin-left:250px;
 	margin-right:150px;
    border-style:solid;
	background-color:#b9ffff ;
	border-radius:45px;
	height:450px;
	width:500px;
	text-align:center;
}
#button
{
	border-radius:15px;
	width: 100px;
	height:40px;
	font-family:Monotype Corsiva;
	font-weight:bold;
	font-size:20px;
	background-color:#c4ffff;
}
select,input 
{
	border-radius:10px;	
}
#heading
{
	font-family: cursive;
}
</style>
</head>
<body>
<div class="frgt">
<h2 align="center" id="heading">Set New Password Here</h2>
<c:if test="${updatefail==1}">
<h2 id="heading"><font color="red">Due to Technical Issue Password Not Updated Try again</font></h2>
</c:if>
<c:if test="${passmismath==1}">
<h2 id="heading"><font color="red">Please enter correct New and Confirm Password</font></h2>
</c:if>

<form action="checkPass.obj" method="post">
	<table cellspacing="20" align="center">
		<tr><td colspan="2" align="center"><b>Enter your new password?</b></td>
		</tr>
		
		<tr>
				<td><b>AccountID</b></td>
				<td><input type="text" name="accId"  value="${forgotid}" readonly="readonly"/></td>	
		</tr>
		
		<tr>
				<td><b>New Password</b><font color="red">*</font></td>
				<td><input type="password" name="pass1" pattern="[A-Z][a-zA-Z0-9@.]{3,}"
				oninvalid="this.setCustomValidity('Password should have one caps,one digit,one special character with more than 4 characters')"
				onchange="this.setCustomValidity('')" required/></td>
				
		</tr>
		<tr>
				<td><b>Confirm Password</b><font color="red">*</font></td>
				<td><input type="password" name="pass2" pattern="[A-Z][a-zA-Z0-9@.]{3,}"
				oninvalid="this.setCustomValidity('Password should have one caps,one digit,one special character with more than 4 characters')"
				onchange="this.setCustomValidity('')"
				required/></td>
				
		</tr>
		<tr>
		<td><input type="submit" value="Submit" id="button"></td>
		<td><input type="reset" value="Reset" id="button"/></td>
		</tr>	
	</table>
</form>
</div>
</body>
</html>