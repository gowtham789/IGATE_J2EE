<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will shown after clicking forgot password to validate 
 				  user account id(This page ask user to enter account id)
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
#id1
{
	position:relative;	
    margin-top:100px;
 	margin-left:250px;
 	margin-right:150px;
    border-style:solid;
	background-color:#b9ffff ;
	border-radius:45px;
	height:350px;
	width:400px;
	text-align:center;
}
#cif
{
	font-family: cursive;
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
input
{
	border-radius:10px;
}
</style>
</head>
<body>
<div id="id1">
<br>
<br>
<c:if test="${notvalidid==1}">
<h3 id="cif"><font color="maroon">please enter valid AccountId </font></h3>
</c:if>
<h2>Enter your account number to set new password</h2>
<form action="getforgotid.obj" method="post">
<table align="center">
	<tr>
	<td colspan="2"><br></td>
	</tr>
	
	<tr>
	<td colspan="2"><br></td>
	</tr>
	
	<tr>
		<td>Enter Account Id<font color="red">*</font></td>
		<td><input type="text" name="accid" pattern="[7][0-9]{7}"
		oninvalid="this.setCustomValidity('Enter Valid account number')"
			onchange="this.setCustomValidity('')" required/></td>
	</tr>
	
	<tr>
	<td colspan="2"><br></td>
	</tr>
	
	<tr>
	<td colspan="2"><br></td>
	</tr>
	
	<tr>
	<td><input type="submit" id="button" value="Submit"/></td>
	<td><input type="reset" id="button" value="Reset"/></td>
	</tr>
</table>
</form>
</div>
</body>
</html>