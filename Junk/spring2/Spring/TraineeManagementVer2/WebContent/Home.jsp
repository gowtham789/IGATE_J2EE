<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<c:if test="${add==1}">
		<u>
		<h2 align="center">Trainee Information</h2>
		</u>
		<c:url var="myAction" value="Insert.obj" />
		
		<form:form action="${myAction}" method="get" modelAttribute="addtrainee">
		<table>
		<tr>
		<td>Trainee Id</td>
		<td><form:input path="id"/></td>
		<td> <form:errors path="id" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Trainee Name</td>
		<td><form:input path="name"/></td>
		<td> <form:errors path="name" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Trainee Location</td>
		<td><form:radiobutton path="location" value="Chennai" label="Chennai" />
		<form:radiobutton path="location" value="Bangalore" label="Bangalore" />
		<form:radiobutton path="location" value="Mumbai" label="Mumbai" />
		<form:radiobutton path="location" value="Hyderabad" label="Hyderabad" /></td>
		<td> <form:errors path="location" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Trainee Domain</td>
		<td><form:select path="domain">
		<form:option value=""></form:option>
		<form:option value=".Net">.Net</form:option>
		<form:option value="Mainframe">Mainframe</form:option>
		<form:option value="JEE">JEE</form:option>
		<form:option value="Vnv">Vnv</form:option></form:select></td>
		<td> <form:errors path="domain" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td colspan="3" align="left"><input type="submit" value="Insert"/>
		</td>
		</tr>
		</table>
		</form:form>
</c:if>


<c:if test="${update==1}">
<h2 align="center">Trainee Information</h2>
	<c:forEach var="tbean" items="${traineelist}">
	<table border="1" align="center">
		<tr>
			<th bgcolor="bisque">Trainee Id</th>
			<th bgcolor="bisque">Trainee Name</th>
			<th bgcolor="bisque">Trainee Location</th>
			<th bgcolor="bisque">Trainee Domain</th>
			<th bgcolor="bisque" colspan="2" align="center">Operation</th>
		</tr>
	<c:if test="${id==tbean.id}">
	
		<c:url var="myAction" value="update.obj" />
		<form:form action="${myAction}" method="get" modelAttribute="viewtrainee">
		
		<tr>
		<td><form:input path="id" readonly="true"/></td>
		
		<td><form:input path="name"/></td>
		
		<td><form:radiobutton path="location" value="Chennai" label="Chennai" />
		<form:radiobutton path="location" value="Bangalore" label="Bangalore" />
		<form:radiobutton path="location" value="Mumbai" label="Mumbai" />
		<form:radiobutton path="location" value="Hyderabad" label="Hyderabad" /></td>
		
		<td><form:select path="domain">
		<form:option value=""></form:option>
		<form:option value=".Net">.Net</form:option>
		<form:option value="Mainframe">Mainframe</form:option>
		<form:option value="JEE">JEE</form:option>
		<form:option value="Vnv">Vnv</form:option></form:select></td>
	
		<td colspan="2" align="left"><input type="submit" value="Update"/>
		</td>
		</tr>
		</form:form>
		</c:if>
		<c:if test="${id!=tbean.id}">
		<tr>
			<td>${tbean.id}</td>
			<td>${tbean.name}</td>
			<td>${tbean.location}</td>
			<td>${tbean.domain}</td>
			<td><a href="del.obj?did=${tbean.id}">Delete</a></td>
			<td><a href="mod.obj?mid=${tbean.id}">Modify</a></td>
		</tr>
		</c:if>	
		</table>	
  </c:forEach>	
</c:if>

<c:if test="${update!=1}">
<h2 align="center">Trainee Information</h2>
	<table border="1" align="center">
		<tr>
			<th bgcolor="bisque">Trainee Id</th>
			<th bgcolor="bisque">Trainee Name</th>
			<th bgcolor="bisque">Trainee Location</th>
			<th bgcolor="bisque">Trainee Domain</th>
			<th bgcolor="bisque" colspan="2" align="center">Operation</th>
		</tr>
		<c:forEach var="tbean" items="${traineelist}">
		<tr>
			<td>${tbean.id}</td>
			<td>${tbean.name}</td>
			<td>${tbean.location}</td>
			<td>${tbean.domain}</td>
			<td><a href="del.obj?did=${tbean.id}">Delete</a></td>
			<td><a href="mod.obj?mid=${tbean.id}">Modify</a></td>
		</tr>
		</c:forEach>
	</table>
<br>
Add a <a href="Add.obj">NEW</a> Trainee here

</c:if>

</body>
</html>