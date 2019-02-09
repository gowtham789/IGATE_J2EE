<html>
<head>
<title>Time check</title>
</head>
<body> 
<% 
java.util.Date today = new java.util.Date();
int hours = today.getHours();
if (hours >= 0 && hours < 12){
%>
		Good morning
<% }else{
		if (hours >= 12 && hours < 16){
%>
		Good afternoon
<%	}else{
		if (hours >= 16 && hours < 24){
%>
				Good evening
<%}}} %>
</BODY>
</HTML>

