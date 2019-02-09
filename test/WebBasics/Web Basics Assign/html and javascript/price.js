function cal()
{
  var result;
  var n1=document.OnlineShop.prodname.value;
  var n2=document.OnlineShop.quantity.value;
  var a=parseInt(n2);
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
alert("bill is"+b);
}