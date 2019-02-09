<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="WebPages/Login.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="frgt">
<form action="checkPass" method="post">
	<table cellspacing="20">
		<tr><td colspan="2" align="center"><b>Enter your new password?</b></td>
		</tr>
		
		<tr>
				<td><b>Enter AccountID:</b></td>
				<td><input type="text" name="accId"  value="${forgotid}" readonly="readonly"></td>	
		</tr>
		
		<tr>
				<td><b>New Password:</b></td>
				<td><input type="password" name="pass1" required></td>
				
		</tr>
		<tr>
				<td><b>Confirm Password:</b></td>
				<td><input type="password" name="pass2" required></td>
				
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Submit"></td>
		</tr>	
	</table>
</form>
</div>
</body>
</html>