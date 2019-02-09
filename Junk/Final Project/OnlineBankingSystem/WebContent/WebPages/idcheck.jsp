<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link  rel="stylesheet" href="home.css"/>
<style type="text/css">
#id1
{
	position:relative;	
    margin-top:100px;
 	margin-left:300px;
 	margin-right:200px;
    border-style:solid;
	background-color:#8ba9b4 ;
	border-radius:45px;
	height:300px;
	width:400px;
	text-align:center;
}
</style>
</head>
<body>
<div id="id1">
<h2>Enter your account number to set new password</h2>
<form action="./getforgotid" method="post">
<table>
<tr><td><br></td></tr>
	<tr><td><br></td></tr>
	<tr>
		<td>Enter Account Id<font color="red">*</font></td>
		<td><input type="text" value="accid"  name="accid"  required/></td>
	</tr>
	<tr><td><br></td></tr>
	<tr><td><br></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" id="button" value="Submit"/></td></tr>
</table>
</form>
</div>
</body>
</html>