<!-- 
 Expressions.jsp
-->
<html>
<head>
<title>JSP Expressions</title>
</head>

<body>
<h2>JSP Expressions</h2>
<form>
	Enter a String <input type="text" name="testParam"/>
	<input type="submit" value="Go"/>
</form>
<ul>
  <li>Current time: <%= new java.util.Date() %>
  <li>Your host name: <%= request.getRemoteHost() %>
  <li>Your session ID: <%= session.getId() %>
  <li>The <code>testParam</code> form parameter:
      <%= request.getParameter("testParam") %>
</ul>
</body>
</html>
