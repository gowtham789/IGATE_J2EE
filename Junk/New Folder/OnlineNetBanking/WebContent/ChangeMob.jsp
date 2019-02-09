<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="min">Change Mobile Number</div><br><br>
<center>

<form name="changaddr" action="UpdateMobileNum" method="post">
<table>

<tr>
<td>New MobileNumber:</td>
<td><input type="text" name=mbno pattern="[7|8|9][0-9]{9}" required ></td>
</tr>

<tr>
<td><input type="submit" id="button" value="Submit"/></td>
<td><input type="reset" id="button" value="Reset" /></td></tr>

</table>

</center>
</form>



</body>
</html>