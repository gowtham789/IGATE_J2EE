/**
 * 
 */
var age;
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
function proofs()
{
	var ctry=document.regForm.country.value;
	if(ctry=="")
		{
		alert("please select a country");
		return false;
     }
	var coun=document.regForm.country.selectedIndex;
	if (coun==1)
		{
			document.regForm.proof.options[0].value="VISA";
			document.regForm.proof.options[0].text="VISA NUMBER";
			document.regForm.proof.options[1].value="Account ID";
			document.regForm.proof.options[1].text="Account ID";
			document.regForm.proof.options[2].value="citizen";
			document.regForm.proof.options[2].text="Citizen ID";
		}	
	else if (coun==2)
		{
			document.regForm.proof.options[0].value="Aadhar";
			document.regForm.proof.options[0].text="AADHAR";
			document.regForm.proof.options[1].value="Passport";
			document.regForm.proof.options[1].text="PASSPORT";
			document.regForm.proof.options[2].value="pan";
			document.regForm.proof.options[2].text="PAN";
		}
	else if (coun==3)
	{
		document.regForm.proof.options[0].value="SSN";
		document.regForm.proof.options[0].text="SSN";
		document.regForm.proof.options[1].value="Greencardnum";
		document.regForm.proof.options[1].text="GreenCardNumber";
		document.regForm.proof.options[2].value="passport";
		document.regForm.proof.options[2].text="PASSPORT";
	}
	
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
			alert("Invalid Applicant");
			document.regForm.dob.value="";
		}
	else if(age==18||age<=60)
		{
		alert("Valid Applicant");
		//document.regForm.dob.value="";
		}
	else if(age>60)
	{
	alert("Senior Citizen");
	//document.regForm.dob.value="";
	}


}
function submitVal()
{
	var fees;
	var qual=document.regForm.qua.value;
	//var course= document.regForm.courseName.value;
	if (age>=18||age<=60)
		{
			fees=700;
		}
	if (age>60)
	{
		fees=500;
	}
	alert ("Registered");
	var newWindow= window.open("", "Total Fees","toolbar");
	newWindow.document.write("<html><head><link href='newwin.css' rel='stylesheet'></link></head><body bgcolor=LightGray align='center'>");
	newWindow.document.write("<h1 align='center'>Your Details Are </h1><br/>" );
	newWindow.document.write("<h4>Your Name is &nbsp"+document.regForm.stName.value+"</h4>");
	newWindow.document.write("<h4>Your country and proof is : "+document.regForm.country.value+" ::::> "+document.regForm.proof.value.toUpperCase()+"</h4>");
	newWindow.document.write("<h4>Your Date of Birth is : "+document.regForm.dob.value+"</h4>");
	newWindow.document.write("<h4>Your Fees is : "+fees+"$</h4>");
	newWindow.document.write("<h4>Your Qualification is : "+qual+"</h4>");
	newWindow.document.write("</body></html>");
	newWindow.alert("Welcome"); 
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