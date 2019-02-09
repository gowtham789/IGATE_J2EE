<!--    
BGColor.jsp
-->
<html>
<head>
  <title>Color Testing</title>
</head>

<%
String bgColor = request.getParameter("bgColor");
boolean hasExplicitColor;
if (bgColor != null) {
  hasExplicitColor = true;
} else {
  hasExplicitColor = false;
  bgColor = "WHITE";
}
%>
<body BGCOLOR="<%= bgColor %>">
<h2 ALIGN="CENTER">Color Testing</H2>
<form>
	Background Color : 
	<input type="text" name="bgColor"/>
	<input type="submit" value="Go"/>
</form>
<%
if (hasExplicitColor) {
  out.println("You supplied an explicit background color of " +
              bgColor + ".");
} else {
  out.println("Using default background color of WHITE. " +
              "Supply the bgColor request attribute to try " +
              "a standard color, an RRGGBB value, or to see " +
              "if your browser supports X11 color names.");
}
%>

</body>
</html>
