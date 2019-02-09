<!-- 
Example of an error pages (used with ComputeSpeed.jsp). 
   
-->
<html>
<head>
<title>Error Computing Speed</title>
</head>

<body>

<%@ page isErrorPage="true" %>

<table boder=5 align="center">
  <tr><th>Error Computing Speed</table>
<p>
ComputeSpeed.jsp reported the following error:
<i><%= exception %></i>. This problem occurred in the
following place:
<pre>
<% exception.printStackTrace(new java.io.PrintWriter(out)); %>
</pre>

</body>
</html>

