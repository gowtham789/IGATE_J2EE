//function to reset all values
function val_reset()
{
	document.getElementById("c").innerHTML="";
	document.getElementById("cn").innerHTML="";
	document.getElementById("d").innerHTML="";
	document.getElementById("r1").innerHTML="";
	document.getElementById("names").focus();
}

//function for form validation and calculate fees to be paid
function validate()
{
	if((document.student.course_type.value==""))
		{
			document.getElementById("cn").innerHTML="";
			document.getElementById("d").innerHTML="";
			document.getElementById("r1").innerHTML="";
			document.getElementById("c").innerHTML="Select your course type!";
			return false;
		}
	else if(document.student.course_name.value=="")
		{
			document.getElementById("c").innerHTML="";
			document.getElementById("d").innerHTML="";
			document.getElementById("r1").innerHTML="";
			document.getElementById("cn").innerHTML="Select your course name!";
			return false;
		}
	else if(checkDate())
		{
			document.getElementById("c").innerHTML="";
			document.getElementById("cn").innerHTML="";
			document.getElementById("r1").innerHTML="";
			document.getElementById("d").innerHTML="Date should be less than current date!";
			return false;
		}
	else if(checkAge())
		{
			document.getElementById("c").innerHTML="";
			document.getElementById("cn").innerHTML="";
			document.getElementById("r1").innerHTML="";
			document.getElementById("d").innerHTML="Age should be >18!";
			return false;
		}
	else 
		{
			document.getElementById("c").innerHTML="";
			document.getElementById("cn").innerHTML="";
			document.getElementById("d").innerHTML="";
			document.getElementById("r1").innerHTML="";
			
			var fees=0,fees_part=[15000,25000,7000],fees_full=[50000,60000],fees_fac=[40000,12000,18000];
			var index_ct=document.student.course_type.selectedIndex,index_cn=document.student.course_name.selectedIndex;
			
			if(index_ct==1)
				{
					fees+=fees_part[index_cn];
				}
			else
				{
					fees+=fees_full[index_cn];
				}
			for(var i=0;i<3;i++)
				{
					if(document.student.chk[i].checked)
					{
						fees+=fees_fac[i];
					}
				}
			
			var n=document.student.name.value;
			var course_n=document.student.course_name.value;
			var newwin=window.open("","Window");
			newwin.document.write("<html><head><title>Bill</title><link rel=stylesheet href='stu_css.css'></head>");
			newwin.document.write("<body id='b'><div><h3>Thank you for Registering "+n+"<br />");
			newwin.document.write("You have selected course "+course_n+"<br />");
			newwin.document.write("You have to pay "+fees+" fees!</h3></div></body></html>");
			return true;
		}
}

//function to populate course name
function popCourse()
{
	var index=document.student.course_type.selectedIndex;
	if(index==1)
	{
		document.student.course_name.options[0].text="MCA";
		document.student.course_name.options[0].value="MCA";
		document.student.course_name.options[1].text="MBA";
		document.student.course_name.options[1].value="MBA";
		document.student.course_name.options[2].text="BEd";
		document.student.course_name.options[2].value="BEd";
	}
	else if(index==2)
	{
		document.student.course_name.options[0].text="BE";
		document.student.course_name.options[0].value="BE";
		document.student.course_name.options[1].text="ME";
		document.student.course_name.options[1].value="ME";
		document.student.course_name.options[2].text="";
		document.student.course_name.options[2].value="";
	}
}

//funtion to check that password is equal to retyped password
function checkPass()
{
	var pass=document.student.password.value;
	var repass=document.student.repassword.value;
	var flag=true;
	if(pass==repass)
		{
			document.getElementById("r1").innerHTML="";
			return true;
		}
	else
		{
			document.getElementById("r1").innerHTML="Password Not Mathing!Retype!";
			document.student.repassword.focus();
			return false;
		}
}


//function to check date of birth is less than current date
function checkDate()
{
	var dt1=document.student.dt.value;
	var dt2=dt1.split('-');
	var dt3=dt2[0]+"/"+dt2[1]+"/"+dt2[2];
	born=new Date(dt3);
	var cur= new Date();
	if(born.getYear()>cur.getYear())
		{
			return true;
		}
	else if (born.getYear()==cur.getYear() && born.getMonth()>cur.getMonth())
		{
			return true;
		}
	else if(born.getYear()==cur.getYear() && born.getMonth()==cur.getMonth() && born.getDate()>cur.getDate())
		{
			return true;
		}
	else
		{
			return false;
		}
}

//function to check that age should be greater than 18 
function checkAge()
{
	var dob1=document.student.dt.value;

	if (dob1 != null)
        d1 = dob1.split('-');
	var d=d1[0]+"/"+d1[1]+"/"+d1[2];
	born=new Date(d);

	var now=new Date();
	if (now.getMonth() == born.getMonth() && now.getDate() == born.getDate()) {
           age = now.getFullYear() - born.getFullYear();
       }
       else {
           age = Math.floor((now.getTime() - born.getTime()) / (365.25 * 24 * 60 * 60 * 1000));
       }
	if(age<18)
		{
			return true;
		}
	else
		{
			return false;
		}
	
}