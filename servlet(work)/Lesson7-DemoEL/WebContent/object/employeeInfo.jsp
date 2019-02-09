<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>This Page will illustrate how to retrieve info and display data using EL</h1>

<table border='1'>
 <tr><th colspan="2">Employee Info</th></tr>
 <tr><td>ID</td><td>${employee.eid}</td></tr>
 <tr><td>Name</td><td>${employee.enm}</td></tr>
 <tr><td>Salary</td><td>${employee.esl}</td></tr>
</table>

<hr/>


<table border='1'>
 <tr><th colspan="2">Employee Dog Info</th></tr>
 <tr><td>Dog Name</td><td>${employee.eDog.name}</td></tr>
 <tr><td>Dog Breed</td><td>${employee.eDog.breed}</td></tr>
</table>

</body>
</html>