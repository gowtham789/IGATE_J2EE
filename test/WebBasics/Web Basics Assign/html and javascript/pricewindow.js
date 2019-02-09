

function cal()
{
var n1=document.OnlineShop.prodname.value;
var n2=document.OnlineShop.quantity.value;
var a=parseInt(n2);
var result;

var anotherWindow=null;
  
  if(n1=="Mobile")
	  {
	  result=10000*a;
	  document.OnlineShop.total.value=result;
	  }
  else if(n1=="Television")
	  {
	  result=20000*a;
	  document.OnlineShop.total.value=result;
	  }
  else if(n1=="laptop")
  {
  result=30000*a;
  document.OnlineShop.total.value=result;
  }
  else if(n1=="Hometheatre")
  {
  result=15000*a;
  document.OnlineShop.total.value=result;
  
  }
 else 
	{
	    alert("Required product not found");
	 }
var b=parseInt(result);


	anotherWindow = window.open("","","toolbar=no,status=no,width=200,height=100");
	if(anotherWindow!=null)
	//create the html
	var newContent = "<HTML><HEAD><TITLE>Another Window</TITLE></HEAD>"
	newContent += "<BODY><H3>Thank you for shopping with us</H3>"
		
		  newContent+="<h4>The product Ordered is &nbsp"+n1+"</h4><br>"
		  newContent+="<h4>The Quantity is &nbsp"+a+"</h4><br>"
		  newContent+="<h4>The bill amount is &nbsp"+b+"</h4>"
		  newContent+= "<FORM><INPUT TYPE = 'button' VALUE = 'Close' onClick = 'self.close()'></FORM>"
	      newContent += "</BODY></HTML>"
	//write the html
	anotherWindow.document.write(newContent);
}