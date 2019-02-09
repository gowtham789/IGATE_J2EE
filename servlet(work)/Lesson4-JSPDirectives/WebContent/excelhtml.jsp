<html>
<head>
<title>Comparing Apples and Oranges</title>
</head>

<body>
<% if (request.getParameter("format")==null) { %>

<h2>Comparing Apples and Oranges</h2>
<form action="excelhtml.jsp">
<input type="text" name="format" value="excel">
<input type="submit" name="submit" value="submit">
</form>

<% } else  { %>

<%String format = request.getParameter("format");
if ((format != null) && (format.equals("excel"))) { 
  response.setContentType("application/vnd.ms-excel");
}
%>

<table BORDER=1>
  <tr><th>Quarter</th><th>Apples<th>Oranges</th></tr>
  <tr><td>First Quarter</td> <td>2307<td>4706</td></tr>
  <tr><td>Second Quarter</td> <td>2982</td> <td>5104</td></tr>
  <tr><td>Third Quarter</td> <td>3011</td> <td>5220 </td></tr>
  <tr><td>Fourth Quarter</td> <td>3055 </td> <td>5287 </td></tr>
</table>


<%}
%>


</body>
</html>
