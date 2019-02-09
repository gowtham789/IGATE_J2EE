<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<hr/>
<h1>Retriveing names from NameList</h1>
${nameList[0]}<br/>
${nameList[1]}<br/>
${nameList['2']}<br/>
${nameList[3]}<br/>

<hr/>
<h1>Retriveing Employee Info from EmployeeList</h1>
${employeeList[0].eid}
${employeeList[0].enm}
${employeeList[0].esl} <br/>

${employeeList['1'].eid}
${employeeList['1'].enm}
${employeeList['1'].esl} <br/>

<hr/>
<h1>Retriveing Entire Data  from MAP using EL</h1>
${nameIdMap}<br/>

<hr/>
<h1>Retriveing Data  from MAP&lt;Long,String&gt; using EL</h1>
${nameIdMap[100]}<br/>
${nameIdMap[101]}<br/>
${nameIdMap[102]}<br/>
${nameIdMap[103]}<br/>
<hr/>

<h1>Retriveing Data  from MAP&lt;String String&gt; using EL</h1>
${nameDomainMap['Rama']}<br/>
${nameDomainMap['Sita']}<br/>
${nameDomainMap['Lava']}<br/>
${nameDomainMap['Kusha']}<br/>
<hr/>
</body>
</html>