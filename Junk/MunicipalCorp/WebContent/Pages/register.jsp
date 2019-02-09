<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body align="center">
	<form action="RegisterController?action=Register" method="post">
		<h3>Register New User</h3>
		<br />
		<h5>On Submission, you will receive a verification code for
			activation</h5>
		<br />
		<table align="center">
			<tr>
				<td>
				<td>First Name
				<td>Middle Name
				<td>Last Name
			</tr>
			<tr>
				<td>*Name:
				<td><input type="text" name="fName" required
					pattern="^[A-Za-z]{2,20}$" value="" />
				<td><input type="text" name="mName" required
					pattern="^[A-Za-z]{2,20}$" value="" />
				<td><input type="text" name="lName" required
					pattern="^[A-Za-z]{2,20}$" value="" />
			</tr>
			<tr>
				<td>*Business Name:
				<td><input type="text" name="bName" pattern="[A-Za-z ]*"
					required />
			</tr>
			<tr>
				<td>*Email-Id
				<td><input type="email" name="emailId" required />
			</tr>
			<tr>
				<td>*Mobile No:
				<td><input type="text" name="mobileNo"
					pattern="^[7-9][0-9]{9}$" required />
			</tr>
		</table>
		<input align="right" type="submit" value="Register" /> <input
			align="right" type="reset" value="Clean" />
	</form>
</body>
</html>