<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="WebPages/Login.css" type="text/css" rel="stylesheet">
</head>
<body align="center">
<div class="frgt">

<form action="./checkques" method="post">
	<table cellspacing="20" align="center">
		<tr><td colspan="2" align="center"><b>Can't Login? Forgot your password?</b></td>
		</tr>
		<tr><td colspan="2">Enter the question given below and we will 
			send you the password on your Mail Id</td></tr><br>
			<tr>
					<td> Select Your Question:</td>
					
					<td><select name="ques"  required>
				<option value="">Select</option>
				<c:forEach var="Service" items="${user}">

				<option value="${Service}">${Service}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>Answer:</b></td>
				<td><input type="text" name="ans"></td>
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