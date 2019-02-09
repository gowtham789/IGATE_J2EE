<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Activate your Account</title>
</head>
<body>
	<form action="RegisterController?action=Activate" method="post">
		<h1>Activate your Account</h1>
		<br /> *Email-Id: <input type="email" name="mailId"> <br />
		*Activation Code: <input type="text" name="actcode"> <br /> <input
			type="submit" value="Activate"> <input type="reset"
			value="Reset">
	</form>
</body>
</html>