<%@ page import="com.cg.onlinebanking.dto.CustomerDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="CurrAddr" name="current" method="post">
<table border="2">
<tr><td>Enter Account Id</td>
<td><input type="text" name="account"/></td></tr>
<tr><th><input type="submit" value="submit"/></th></tr>
</table>
</form>
<% CustomerDTO accoId = (CustomerDTO)session.getAttribute("acc"); %>
<% if(accoId!= null) 
{ %>
<br/>
<br/>
<table border="2">
<tr>
<th>accountId</th>
<th>CustomerName</th>
<th>emailId</th>
<th>Address</th>
<th>Pancard</th>
<th>Mobile Number</th>
</tr>
<tr>
<td><%=accoId.getAccountId() %></td>
<td><%=accoId.getCustName()%></td>
<td><%=accoId.getEmail() %></td>
<td><%=accoId.getAddress() %></td>
<td><%=accoId.getPancard()%></td>
<td><%=accoId.getMobilenumber()%></td>

	<td><%Long cid= accoId.getAccountId();%>
	<td><a href="UpdateAddr?id=<%=cid %>">ChangeAddress</a></td>
	<td><a href="UpdateMob?id=<%=cid %>">ChangeMobile</a></td>

<%} %>
</tr>

	
</table>

</body>
</html>