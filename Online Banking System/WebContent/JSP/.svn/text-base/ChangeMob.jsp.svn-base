<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will ask user to enter mobile number for updation
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" refresh="5">
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

<div id="min">Change Mobile Number</div><br><br>

<div align="center">
<form action="UpdateMobileNum.obj" method="post">
<br>
<table>
	<tr>
	<td>New MobileNumber<font color="red">*</font></td>
	<td><input type="text" name="mbno" pattern="[7|8|9][0-9]{9}" 
		oninvalid="this.setCustomValidity('Enter Valid number')"
				onchange="this.setCustomValidity('')" maxlength="10"  required></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr><td><br></td></tr>
	
	<tr>
	<td><input type="submit" id="button" value="Submit"/></td>
	<td><input type="reset" id="button" value="Reset" /></td></tr>

</table>
</form>
</div>
<a href="changeaddr.obj">Go Back</a>
</body>
</html>