function addNum()
{
	var n1=document.AdditionForm.num1.value;
	var firstNum=parseInt(n1);
	
	var n2=document.AdditionForm.num2.value;
	var secondNum=parseInt(n2);

	var result=firstNum+secondNum;

	
	document.AdditionForm.num3.value=result;
	alert("The sum is "+result);
}