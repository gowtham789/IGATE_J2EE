/**
 * 
 */
function pass_val()
{
	var pa= document.regForm.pass1.value;
	var pa2= document.regForm.pass2.value;
	if (pa!=pa2)
		{
			alert("Please Retype the password correctly");
			document.regForm.pass2.value="";
			document.regForm.pass1.value="";
		}
}
function course()
{
	var coun=document.regForm.courseType.selectedIndex;
	if (coun==1)
		{
			document.regForm.courseName.options[0].value="mca";
			document.regForm.courseName.options[0].text="MCA";
			document.regForm.courseName.options[1].value="mba";
			document.regForm.courseName.options[1].text="MBA";
			document.regForm.courseName.options[2].value="b.ed";
			document.regForm.courseName.options[2].text="B.Ed";
		}	
	else if (coun==2)
		{
			document.regForm.courseName.options[0].value="be";
			document.regForm.courseName.options[0].text="BE";
			document.regForm.courseName.options[1].value="me";
			document.regForm.courseName.options[1].text="ME";
			document.regForm.courseName.options[2].value="";
			document.regForm.courseName.options[2].text="";
		}
}	
function submitVal()
{
	var fees;
	var course= document.regForm.courseName.value;
	if (course =="mca")
		{
			fees=15000;
		}
	else if (course=="mba")
		{
			fees=25000;
		}
	else if (course=="b.ed")
	{
		fees=7000;
	}
	else if (course=="be")
	{
		fees=50000;
	}
	else if (course=="me")
	{
		fees=65000;
	}
	else if (course=="")
	{
		document.getElementById("err").innerHTML="<font color=\"red\"><b>Please select a product</b></font>";
		return false;
	}
	else
		{
			document.getElementById("err").innerHTML="<font color=\"red\"><b>Please select a product</b></font>";
			return false;
		}
	if (document.regForm.hoste.checked)
		{
			fees=fees+40000;
		}
	if (document.regForm.transpor.checked)
		{
			fees=fees+12000;
		}
	if (document.regForm.book.checked)
		{
			fees=fees+18000;
		}
	alert ("Registered");
	var newWindow= window.open("", "Total Fees","toolbar");
	newWindow.document.write("<html><head><link href='newwin.css' rel='stylesheet'></link></head><body bgcolor=LightGray align='center'>")
	newWindow.document.write("<h1>Welcome </h1><br/>" );
	newWindow.document.write("<table align='center'> <tr><td>"+document.regForm.stName.value+"</td></tr>")
	newWindow.document.write("<tr><td>Your course details is : "+document.regForm.courseType.value+" ::::> "+document.regForm.courseName.value.toUpperCase()+"</td></tr>");
	if (document.regForm.hoste.checked)
		{
		newWindow.document.write("<tr><td>With "+document.regForm.hoste.value+"Facility</td></tr>");
		}
	if (document.regForm.transpor.checked)
		{
			newWindow.document.write("<tr><td>With "+document.regForm.transpor.value+"Facility</td></tr>");
		}
	if (document.regForm.book.checked)
		{
			newWindow.document.write("<tr><td>With "+document.regForm.book.value+"Facility</td></tr>");
		}
	newWindow.document.write("<tr><td>Registration is done</td><tr/><tr><td> Amount to be paid is Rs<b>"+fees+"</b></td></tr></table>");
	newWindow.document.write("</body></html>");
	newWindow.alert("Welcome"); 
}
function getAge()
{
	var dob1=document.regForm.dob.value;
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
	if (age<18)
		{
			alert("Not eligible as age is less than 18");
			document.regForm.dob.value="";
		}
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