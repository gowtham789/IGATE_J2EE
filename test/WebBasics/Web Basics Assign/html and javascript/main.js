function cal()
{
  var prdPrice=document.OnlineShop.product.value;
  if(prdPrice==0||prdPrice=="")
	  {
	  alert("select any one of the products");
	  return false;
	  }
  var len=document.OnlineShop.service.length;
  var serviceList='';
  var count=0;
  for(index=0;index<len;index++)
	  {
	    if(document.OnlineShop.service[index].checked)
	    	{
	    	count++;
	    	serviceList=serviceList+" ,"+document.OnlineShop.service[index].value;
	    	}
	  }
if(count==0)
	{
	  alert("select any one of services");
	  return false;
	}
var n1=document.OnlineShop.product.name;
var n2=document.OnlineShop.qty.value;
var fname=document.OnlineShop.firstname.value;
var a=parseInt(n2);
var result;

result=prdPrice*a;

anotherWindow = window.open("","","toolbar=no,status=no,width=200,height=100");
if(anotherWindow!=null)
	{
//create the html
var newContent = "<HTML><HEAD><TITLE>Another Window</TITLE></HEAD>"
newContent += "<BODY><H3>Thank you for shopping with us &nbsp"+fname+"</H3>"
	
	  newContent+="<h4>The product Ordered is &nbsp"+n1+"</h4><br>"
	  newContent+="<h4>The Quantity is &nbsp"+a+"</h4><br>"
	  newContent+="<h4>The bill amount is &nbsp"+result+"</h4>"
	  newContent+="<h4>The Selected services are &nbsp"+serviceList+"</h4>"
	  newContent+= "<FORM><INPUT TYPE = 'button' VALUE = 'Close' onClick = 'self.close()'></FORM>"
      newContent+= "</BODY></HTML>"
//write the html
anotherWindow.document.write(newContent);
}

}
