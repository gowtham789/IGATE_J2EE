/**
 * 
 */

function proofs()
{
	var ctry=document.regForm.cty.value;
	if(ctry=="")
		{
		alert("please select a category");
		return false;
     }
	var coun=document.regForm.cty.selectedIndex;
	if (coun==1)
		{
			document.regForm.product.options[0].value="Television";
			document.regForm.product.options[0].text="Television";
			document.regForm.product.options[1].value="Laptop";
			document.regForm.product.options[1].text="Laptop";
			document.regForm.product.options[2].value="Phone";
			document.regForm.product.options[2].text="Phone";
		}	
	else if (coun==2)
		{
			document.regForm.product.options[0].value="Soap";
			document.regForm.product.options[0].text="Soap";
			document.regForm.product.options[1].value="Powder";
			document.regForm.product.options[1].text="Powder";
			document.regForm.product.options[2].value="";
			document.regForm.product.options[2].text="";
			
		}
	
}	



function submitVal()
{
	var n1=document.regForm.product.value;
	var n2=document.regForm.quantity.value;
	var a=parseInt(n2);
	var result;
	
	if(n1=="Phone")
	  {
	  result=10000*a;
	  document.regForm.total.value=result;
	  }
else if(n1=="Television")
	  {
	  result=20000*a;
	  document.regForm.total.value=result;
	  }
else if(n1=="Laptop")
{
result=30000*a;
document.regForm.total.value=result;
}
else if(n1=="Soap")
{
result=40*a;
document.regForm.total.value=result;
}	
else if(n1=="Powder")
{
result=90*a;
document.regForm.total.value=result;
}

else 
	{
	    alert("Required product not found");
	 }
var b=parseInt(result);

	alert ("Successfull");
	var newWindow= window.open("", "Total Fees","toolbar");
	newWindow.document.write("<html><head><link href='newwin.css' rel='stylesheet'></link></head><body bgcolor=LightGray align='center'>");
	newWindow.document.write("<h1 align='center'>Your Order Summary is </h1><br/>" );
	newWindow.document.write("<h4>Product you have selected is &nbsp"+n1+"</h4>");
	//newWindow.document.write("<h4>Category is &nbsp"+ctry+"</h4>");
	newWindow.document.write("<h4>Quantity is : "+n2+"</h4>");
	newWindow.document.write("<h4>Total Bill Amount  is : "+b+"</h4>");
	newWindow.document.write("</body></html>");

}

function resetall()
{
	document.regForm.courseName.options[0].text="";
	document.regForm.courseName.options[1].text="";
	document.regForm.courseName.options[2].text="";
	document.regForm.courseName.options[0].value="";
	document.regForm.courseName.options[1].value="";
	document.regForm.courseName.options[2].value="";
	document.getElementById("errorRow").innerHTML="<tr></tr>";
}