
function validate(){
var n=document.getElementById('name').value;	
var date=document.getElementById('date1').value;
var phone=document.getElementById('number1').value;
var emails=document.getElementById('email1').value;
var alternate=document.getElementById('Anumber1').value;
var Accountnum=document.getElementById('Account1').value;
var Accounttype=document.getElementById('Actype1').value;
var pwd=document.getElementById('pwd1').value;
var cpwd=document.getElementById('pwd2').value;
var dob=new Date(date);
if(nameval(n)){
	if(dates(dob)){
		if(number(phone)){
			if(isvalidemail(emails)){
				if(Anumber(alternate)){
					if(Actnumber(Accountnum)){
						if(Acttype(Accounttype)){
							if(password(pwd,cpwd)){
								if(cpassword(pwd,cpwd)){
									alert('submitted successfully');
								
								}
							}
						}
					}
				}
			}
		}
	}
}

}




function nameval(n)
{

if(n=='')
{
alert("enter any name");
}
else{
return true;}

/*var check=/[0-9]/g;
if(n.match(check)){
alert("user name cant be only digits");
disable="submit1"
}
*/

}
function dates(dob)
{
if(dob=='')
{
alert("enter any value");
}
else{
return true;}
}
function number(phone)
{
if(phone=='')
{
alert("Number Feild cant be empty");
}
else{
return true;}
}
function isvalidemail(emails)
{
if(emails=='')
{
alert("Email box cant be empty");
}
else{
return true;}
}
function Anumber(alternate)
{
if(alternate=='')
{
alert("Alternate number cant be empty");
}
else{
return true;}
}
function Actnumber(Accountnum)
{
if(Accountnum=='')
{
alert("Account Number cant be empty");
}
else{
return true;}
}
function Acttype(Accounttype)
{
if(Accounttype=='')
{
alert("Account type cant be empty");
}

else{
return true;}
}
function password(pwd,cpwd)
{
var re=/[A-Z]{1}[0-9]{2}[@]{1}/;
if(pwd=='')
{
alert("password cannot be empty");
}
else{
return true;}
//if(!pwd.match(re))
//{
//alert("enter the password in proper format");
//}
}
function cpassword(pwd,cpwd)
{
if(pwd!=cpwd)
{
alert("Confirm password should be same as Password");
}
else{
return true;}
}


