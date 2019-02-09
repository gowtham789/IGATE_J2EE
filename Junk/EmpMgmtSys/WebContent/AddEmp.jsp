<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function isValid()
{
	 var name=document.AddUser.empName.value;
	 if(name.length<3)
		 {
		 alert("Name should be minimum 3 chars");
		  return false;
		 }
	 else return true;
	}
</script>
</head>
<body>
	<h1>Welcome To Employee Management System</h1>
	<h3> You have logged in as <%=session.getAttribute("uname") %></h3>

<br/>
<h2> Add New Employee</h2>
<form action="AddEmployee" method="post" name="AddUser">
<table>
 <tr><th> Emp Id:</th><td><input type="text" name="empId"/></td></tr>
<tr><th> Emp Name:</th><td><input type="text" name="empName"/></td></tr>
<tr><th> Salary:</th><td><input type="text" name="sal"/></td></tr>
<tr><th> Desig:</th><td><input type="text" name="desig"/></td></tr>
<tr><th><input type="submit" value="Register" onClick="return isValid()"/></th></tr>
</table>
</form>
</body>
</html>