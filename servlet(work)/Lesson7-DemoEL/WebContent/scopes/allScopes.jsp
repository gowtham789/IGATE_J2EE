<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Accessing information through attributes stored in different scopes</h1>

<h2>Without refering to scopes</h2>
Name : ${name}<br/>
Company : ${company}<br/>
Location : ${location}<br/>

<br/><br/><br/>
<h2>Refering to scopes with appropriate EL implicit object</h2>
Name : ${requestScope.name}<br/>
Company : ${sessionScope.company}<br/>
Location : ${applicationScope.location}<br/>


</body>
</html>