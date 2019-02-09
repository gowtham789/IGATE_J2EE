<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="WebPages/Login.css" type="text/css" rel="stylesheet"/>
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
<div class="d">

<div class="d1">
<img src="Webpages/logo.PNG" width="150px" height="100%" align="left" style="border-radius:10px "/>
	<h4 class="bank" align="center" clear="right" >Capge Bank</h4>
	
</div>


<div class="d2">

<marquee><h1 style="color:#0066CC" align="center">ANYTIME..!!!<br>ANYWHERE...!!!</h1><br><br></marquee>
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
		<form name="loginpage" method="post" action="Loginserv" >
			<table class="table" cellspacing="10">
				
				<tr class="uname">
				<td><b>UserName:</b></td>
					<td><input type="text" name="UserName" value=""  required />  </td>
				</tr>

				<tr ><td><b>Password:</b></td>
					 <td><input type="password" name="Pass" value="" required/>  </td>
				</tr>
			    <tr></tr>
				<tr>
					<td></td>
					<td><input type="submit" name="login" value="Login" />&nbsp;&nbsp;&nbsp;
						<input type="reset" name="cancel" value="Cancel"/>
					</td>
				</tr>
				
				<tr>
				<td colspan="2" ><font color="red">${invalidmsg}</font></td>
				</tr>
				<tr><td colspan="2"><a href="forgot" target="d3">Forgot Password?</a></td></tr>
			</table>
		</form>
	</div>
</div>
<div class="d4">
<h4 align="center"> &copy;Copyright Capge Bank</h4></div>

</div>
</body>
</html>