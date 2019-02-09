function calNo()
{
	for(var i=1;i<100;i++)
	{
		if((i%10)==9)
		{
			document.writeln(i+"<br>");
		}
		else
			document.writeln(i);
	}
}