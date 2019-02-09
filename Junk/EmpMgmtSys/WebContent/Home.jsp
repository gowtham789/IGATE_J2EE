<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To Employee Management System</h1>
	<h3> You have logged in as <%=session.getAttribute("uname") %></h3>

<br/><br/>
<a href="Add">Add new Employee Details</a>
<br/>
<a href="View"> View Employee Details</a>

</body>
</html>