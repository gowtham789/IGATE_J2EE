function validate()
{
  var actype=document.frm.type.value;
  if(actype==0||actype=="")
	  {
	  alert("select any of the Account type");
	  return false;
	  } 
  else
	  {
	  alert("Account Number is generated Successfully")
	  }
  }