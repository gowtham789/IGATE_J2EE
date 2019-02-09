<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">
<h1 align="center"><i> Welcome To Patient Management System</i></h1>
<form name="LoginForm" action="Login" method="post">
<table border="2" align="center" width="40%">
<tr>
 <td> Username :</td> <td> <input type="text" name="uname" required/></td>
 </tr>
 <tr>
  <td> Password :</td>  <td> <input type="password" name="pwd" required/></td>
   </tr>
   <tr>
  <td colspan="2" align="center"><input type="submit" value="Login"/></td>
   </tr>
</table>

</form>
<h4>No of users logged in... ${user}</h4>

</body>
</html>