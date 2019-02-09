<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>adding patient</title>

<script type="text/javascript">
function isValid()
{
	 var name=document.Patient.pName.value;
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
<h1>Welcome To Patient Management System</h1>
<h3> You have logged in as <%=session.getAttribute("uname") %></h3>

<form action="addUser" method="post" name="Patient">

<table border="2" align="center" width="40%">
<tr><th> Patient Name:</th><td><input type="text" name="pName" /></td></tr>
<tr><th> Age:</th><td><input type="text" name="age" /></td></tr>
<tr><th> Phone:</th><td><input type="text" name="phone" /></td></tr>
<tr><th> Description:</th><td><input type="text" name="desc" /></td></tr>
<tr>
			<td>Doctor Name:</td>
			<td><select name="doc" >
				<option value="">Select</option>
				<option value="Dr.Ravi">Dr.Ravi</option>
				<option value="Dr.Pramod">Dr.Pramod</option>
				<option value="Dr.Lalitha">Dr.Lalitha</option>
				</select>
			</td>
		</tr>
<tr>

<tr><th><input type="submit" value="Insert" onClick="return isValid()"/></th></tr>
</table>
</form>




</body>
</html>