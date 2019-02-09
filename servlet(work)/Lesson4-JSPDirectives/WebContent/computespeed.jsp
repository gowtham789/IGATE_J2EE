<!-- 
Example of using error pages (e.g. when divide by zero or number format exception occurs on this page). 
-->
<html>
<head>
<title>Computing Speed</title>
</head>

<body>

<%@ page errorPage="speederror.jsp" %>

<table border="5">
  <tr><th> Computing Speed  </th></tr>
</table>

<%! 
// Note lack of try/catch for NumberFormatException if
// value is null or malformed.

private double toDouble(String value) {
  return(Double.valueOf(value).doubleValue());
}
%>

<% 
String strFurlongs = request.getParameter("furlongs");
String strFortnights =request.getParameter("fortnights");
if (strFurlongs!=null && strFortnights!=null){
double furlongs = toDouble(strFurlongs); 
double fortnights = toDouble(strFurlongs);
double speed = furlongs/fortnights;
%>
<ul>
  <li>Distance: <%= furlongs %> furlongs.
  <li>Time: <%= fortnights %> fortnights.
  <li>Speed: <%= speed %> furlongs per fortnight.
</ul>
<%}else{ %>
<form>
Distance in furlongs <input type="text" name="furlongs"/>
Time in fortnights <input type="text" name="fortnights"/>
<input type="submit" value="Calculate Speed"/>
</form>
<%} %>
</body>
</html>

