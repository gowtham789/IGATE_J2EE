<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show 3 text boxes to enter old and new password
 				  for changing the password
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
<div id="min">Change Password</div>
<br>
<br>
<c:if test="${update==1}">
<h3><font color="green">You have updated your password successfully!!!</font></h3>
</c:if>
<c:if test="${update==0}">
<h3><font color="red">Sorry for the inconvenience please update password again!!!</font></h3>
</c:if>
<c:if test="${update==2}">
<h3><font color="red">Please ReType New Password Correctly!!!!</font></h3>
</c:if>

<c:if test="${update==3}">
<h3><font color="red">Please ReType Old Password Correctly!!!!</font></h3>
</c:if>



<center>
<form name="changepass" action="ChangePass.obj" method="post">
<table>
	<tr>
	<td>Current Password<font color="red">*</font></td>
	<td><input type="password" name="oldpass" required placeholder="Enter old password"/></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr>
	<td>New Password<font color="red">*</font></td>
	<td><input type="password" name="newpass" required placeholder="Enter new password" /></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr>
	<td>Retype New Password<font color="red">*</font></td>
	<td><input type="password" name="renewpass" required placeholder="Re-type your password"/></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr><td><br></td></tr>
	
	<tr><td><br></td></tr>

<tr><td><input type="submit" id="button" value="Submit"/></td>
<td><input type="reset" id="button" value="Reset" /></td></tr>

</table>
</form>
</center>

</body>
</html>