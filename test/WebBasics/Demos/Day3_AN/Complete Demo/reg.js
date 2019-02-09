function validate()
{
	var len1=document.frm.skill.length;
	var skillsList='';
	var count=0;
	for(index1=0;index1<len1;index1++)
	{
		if(document.frm.skill[index1].checked)
			{
			count++;
			skillsList=skillsList+" , "+document.frm.skill[index1].value;
			}
	}
	if(count==0)
		{
			alert("Select any one of the skills");
			return false;
		}
	else
		{
			alert("Selected skills"+skillsList+"\nSelected city "+document.frm.city.value);
			return true;
		}
}