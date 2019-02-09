<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will shown for customer and admin which helps,
 				  in how to use online banking
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
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body  onload="disableclick();">
<ol>
<li style="list-style: decimal;">
<b>Change in address/mobile number/password:</b></li>
<ul><li style="list-style:disc;">
	 You can change the address of communication or mobile number or password by filling the		   required information provided in the page.
	</li></ul>
	<li style="list-style: decimal;">
<b>Request for cheque book:</b></li>
<ul><li style="list-style:disc;">
	 A cheque book request is always in Open state. Other valid states are dispatched, 			  issued or returned.
 	 know the status of the service requested like request for cheque book
	</li></ul>
<li style="list-style: decimal;">
<b>Fund Transfer</b></li>
<ul><li style="list-style:disc;">
	  You can transfer money to your own account or other account of different user of the same bank across india.
 <br>
 <b>Steps to Transfer Fund</b>
 <br>	
 	  Select the payee from the list of payees, in case you did not register for the payee, should 		    click  'add a payee' link provided in the same page.
	  Click  the Pay button you will be prompted to enter the transaction amount and 	    	   	   transaction password.
</li></ul>
<li style="list-style: decimal;">
<b>Mini Statement:</b></li>
<ul><li style="list-style:disc;">	
	 This will show the last 10 transactions and transaction details for the period selected.
	 </li></ul>
	 <br>
</ol><a href="Home.obj">Go Back to Home Page</a>
</body>
</html>