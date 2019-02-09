<%@page import="com.igate.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1>How to embed Java in JSP - 2</h1>
 
 <!--Creating an Employee object and populating it'd properties --> 
 
 <%
  
    Employee employee=new Employee();
    employee.setEid(100);
    employee.setEnm("Rama");
    employee.setEsl(55555.55);
 %>
 
 <h2>Displaying Employee Info-1(Normal Display)</h2>
 <%
    out.print("<br/>ID:"+employee.getEid());
    out.print("<br/>Name:"+employee.getEnm());
    out.print("<br/>Salary:"+employee.getEsl());
 %>
 
 <h2>Displaying Employee Info-2(Tabular Display)</h2>

 <table border="1">
  <tr><th colspan="2">Employee Info</th></tr>
  <tr>
   <td>EID</td>
   <td><%=employee.getEid()%>
  </tr>
   <tr>
   <td>Name</td>
   <td><%=employee.getEnm()%>
  </tr>
  <tr>
   <td>Salary</td>
   <td><%=employee.getEsl()%>
  </tr>
 
 </table> 

</body>
</html>