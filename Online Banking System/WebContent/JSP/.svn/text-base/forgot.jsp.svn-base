<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will be shown after selecting a account for forgot password
 				  and displays secret question from this page to validate user to change password
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
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
	height:350px;
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
</style>
</head>
<body>
<div class="frgt">
<c:if test="${answerfail==1}">
<h2><font color="maroon">Please Enter Correct Answer</font></h2>
</c:if>
<h2 align="center">Account Entered is ${forgotid}</h2>
<form action="checkques.obj" method="post">
	<table align="center">
	
		<tr>
		<td colspan="2" align="center">
		<b>Can't Login? Forgot your password?</b></td>
		</tr>
		
		<tr>
		<td colspan="2">Enter the question given below and we will 
			send you the password on your Mail Id</td>
		</tr>
		
		<tr><td><br></td></tr>
		
		<tr>
		<td> Select Your Question<font color="red">*</font></td>
		<td><select name="ques"  required>
		<option value="">Select</option>
		<c:forEach var="Service" items="${user}">
		<option value="${Service.secretQuest}">${Service.secretQuest}</option>
		</c:forEach>
		</select></td>
		</tr>
			
		<tr>
		<td><b>Answer</b><font color="red">*</font></td>
		<td><input type="text" name="ans" required="required"/></td>
		</tr>
		<tr><td><br></td></tr>
		<tr>
		<td><input type="submit" value="Submit" id="button"></td>
		<td><input type="reset" value="Reset" id="button"/></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>