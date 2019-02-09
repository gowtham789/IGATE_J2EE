<!DOCTYPE html>
<html>
<head>
<title>JSP 2.2 Expression Language - Basic Operators</title>
</head>
<%@page import="java.util.stream.*"%>
<body>
	<h4>JSP 2.2 Expression Language - Basic Operators</h4>
	<hr>
	<br>
	<table border="1">
		<thead>
			<tr>
				<td><b>EL Expression</b></td>
				<td><b>Result</b></td>
			</tr>
		</thead>
		<tr>
			<td>\${1}</td>
			<td>${1}</td>
		</tr>
		<tr>
			<td>\${1 + 2}</td>
			<td>${1 + 2}</td>
		</tr>
		<tr>
			<td>\${1.2 + 2.3}</td>
			<td>${1.2 + 2.3}</td>
		</tr>
		<tr>
			<td>\${21 * 2}</td>
			<td>${21 * 2}</td>
		</tr>
		<tr>
			<td>\${3/4}</td>
			<td>${3/4}</td>
		</tr>
		<tr>
			<td>\${1 &lt; 2}</td>
			<td>${1 < 2}</td>
		</tr>
		<tr>
			<td>\${1 lt 2}</td>
			<td>${1 lt 2}</td>
		</tr>
		 
		<tr>
			<td>\${((x, y) -> x + y)(7, 4.5)}</td>
			<td>${((x, y) -> x + y)(7, 4.5)}</td>
		</tr>
		<tr>
			<td>\${[1,2,3,4].stream().sum()}</td>
			<td>${[1,2,3,4].stream().sum()}</td>
		</tr>
	</table>
</body>
</html>
