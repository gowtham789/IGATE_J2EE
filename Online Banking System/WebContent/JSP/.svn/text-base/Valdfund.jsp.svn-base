<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will be shown after customer submitting fund transferpage
 				  and ask user to enter transaction password to transfer succesfully
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
<link  rel="stylesheet" href="JSP/Home.css"/>
</head>
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
<div id="min" align="center">Enter Transaction Password to transfer fund</div>
<br>
<br>
<div align="center">
	<form action="valdfun.obj" method="post">
		<table>
			<tr>
			<td>Enter Transaction Password <font color="red">*</font></td>
			<td><input type="text" name="tpass" required/></td>
			</tr>
			<tr><td colspan="2"><br></td></tr>
			<tr><td colspan="2"><br></td></tr>
			<tr><td colspan="2" align="center"><input type="submit" id="button" value="submit"/></td></tr>
		</table>
	</form>
</div>
<a href="fundtransfer.obj">Go Back</a>
</body>
</html>