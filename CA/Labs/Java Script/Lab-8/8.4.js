function unameCheck()
{
	var uVal = document.forms[0].uname.value;
	if(uVal!="")
	{
		return valnameCheck(uVal);
	}
}
function fnameCheck()
{
	var fVal = document.forms[0].fname.value;
	if(fVal!="")
	{
		return valnameCheck(fVal);
	}
}
function lnameCheck()
{
	var lVal = document.forms[0].lname.value;
	if(lVal!="")
	{
		return valnameCheck(lVal);
	}
}
function valnameCheck(abc)
{
	var pattern = /(\D)([^!@#$%^&*_])/;
	var regOb = new RegExp(pattern);
	if(regOb.test(abc))
	{
		return true;
	}
	else
	{
		alert("Invalid name");
		return false;
	}
}
function isPass()
{
	var pVal = document.forms[0].pwd.value;
	var pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	var regOb = new RegExp(pattern);
	if(regOb.test(pVal))
	{
		return true;
	}
	else if(pVal=="")
	{
	
	}
	else if(!regOb.test(pVal))
	{
		alert("Password doesn't match the criteria");
		return false;
	}
}
function rePass()
{
	var pVal = document.forms[0].pwd.value;
	var reVal = document.forms[0].repwd.value;
	if(pVal!=reVal && reVal!="")
	{
		alert("Both passwords doesn't match");
		return false;
	}
	return true;
}
function question()
{
	var qstnVal = document.forms[0].qstn.value;
	var ownqstVal = document.forms[0].ownqst.value;
	if(qstnVal=="" && ownqstVal=="")
	{
		alert("Please select any question or write one of your own");
		return false;
	}
	return true;
}
function answer()
{
	var qstnVal = document.forms[0].qstn.value;
	var ownqstVal = document.forms[0].ownqst.value;
	var hntansVal = document.forms[0].hntans.value;
	if((qstnVal!="" || ownqstVal !="")&&(hntansVal==""))
	{
		alert("Please write the answer for the question");
		return false;
	}
	return true;
}
function validate()
{
	if(unameCheck() && fnameCheck() && lnameCheck() && isPass() && rePass() && question() && answer())
		alert("Validation Successful");
	else
		alert("Please enter the required fields");
}