<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="WebPages/home.css"/>
<title>Insert title here</title>
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
<div id="min" align="center">About CapgeBank</div><br>
<ol>
<li style="list-style: decimal;">
Our Vision:
</li>

<ul>
<li style="list-style: disc;">
	"To be the most preferred and trusted bank".
</li>
</ul>

<li style="list-style: decimal;">
Our Mission:
</li>

<ul>
<li style="list-style: disc;">
	 "To Achieve Values Based Operational Excellence providing customer delight resulting in 
consistent superior financial performance".
</li>
</ul>


<li style="list-style: decimal;">
Values:
</li>
<ul>
<li style="list-style: disc;">
	 "Transparency and ethics in all dealings. Respect and empathy for customers. 

Competence and dedication in all that we do. Commitment to National and social objectives".
</li>
</ul>

<li style="list-style: decimal;">
Overview:
</li>
<ul>
<li style="list-style: disc;">
	 CapgeBank  started with the unique distinction of being the central bank of Chennai, 	

 	   covering present-day Hyderabad, karnataka, Mumbai, Delhi and so on to manage its           

                    currency. The first branch of the bank was opened at Chennai on 6th april 1980.
	   in 1990, the bank was taken over by the reserve bank of India.
</li>
</ul>
</ol>
<a href="Home" target="_top">Go Back to Home Page</a>
</body>
</html>