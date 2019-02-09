<html>
<head>
<title> Testing the global declaration </title>
</head>
<body bgcolor="yellow">
<%!	int factorial(int num)
	{ if(num<=1)
		return num;
		else
	   return num*factorial(num-1);
	}
%>

<font size=5 color = blue>

<% for (int i=0; i< 10 ;i++)
{	int res = 0;
	res = factorial(i);
	out.println("<br>"+"The factorial value of " + i + " is "+res);
}
%>
</font>

</body>
</html>

