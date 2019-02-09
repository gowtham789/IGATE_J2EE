function validloan()
{
	var result=true;
	var currVal = document.forms[0].curr.value;
	var loanSpan = document.getElementById("loanErr");
	if(currVal>150000)
	{
		alert("Sorry, Loan allowed is less than 150000");
		return false;
	}
	return result;
}
function validrate()
{
	var result=true;
	var percVal = document.forms[0].perc.value;
	var rateSpan = document.getElementById("perErr");
	if(percVal<0 || percVal>100)
	{
		alert("Please enter percentage in between 0 and 100");
		return false;
	}
	return result;
}
function validyrs()
{
	var result=true;
	var yrsVal = document.forms[0].repay.value;
	var yrsSpan = document.getElementById("repErr");
	if(yrsVal<7 || yrsVal>15)
	{
		alert("Repayement period should be between 7 yrs to 15 yrs");
		return false;
	}
	return result;
}

function calculate()
{
	var yrsVal = document.forms[0].repay.value;
	var percVal = document.forms[0].perc.value;
	var currVal = document.forms[0].curr.value;
	var totalpay =0,monthpay = 0,interest=0;
	if(parseInt(yrsVal)>7 && parseInt(yrsVal)<15 && parseInt(percVal)>0 && parseInt(percVal)<100 && parseInt(currVal)>0 && parseInt(currVal)<150000)
	{
		interest=(parseInt(yrsVal)*parseInt(percVal)*parseInt(currVal))/100;
		totalpay=(parseInt(currVal)+interest);
		monthpay=(parseInt(totalpay)/(parseInt(yrsVal)*12));
		document.forms[0].totint.value=interest;
		document.forms[0].totpay.value=totalpay;
		document.forms[0].monpay.value=monthpay;
	}	
	//alert(document.forms[0].totint.value);
	else
	{
		alert("Please enter correct values");
	}
}