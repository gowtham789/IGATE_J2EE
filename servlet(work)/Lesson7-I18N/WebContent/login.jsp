<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>


<c:if test="${lang==null}">
 <fmt:setLocale value="en"/>
 <fmt:setBundle basename="com.igate.bundles.Messages" 
    var="lang" scope="session"/>
</c:if>

<c:if test="${param.lang!=null}">
 <fmt:setLocale value="${param.lang}"/>
 <fmt:setBundle basename="com.igate.bundles.Messages" 
    var="lang" scope="session"/>
 <c:redirect url="login.jsp"/>
</c:if>


<table>
<tr>
<td><a href="login.jsp?lang=en"><fmt:message key="login.english" bundle="${lang}"/></a></td>
<td><a href="login.jsp?lang=de"><fmt:message key="login.german" bundle="${lang}"/></a></td>
<td><a href="login.jsp?lang=fr"><fmt:message key="login.french" bundle="${lang}"/></a></td>
</table>

<h1><fmt:message key="loginpage.title" bundle="${lang}"/></h1>

<form action="LoginController" method="post">
<table>

 <tr><th colspan="3"><fmt:message key="login.title" bundle="${lang}"/></th></tr>
 <tr>
   <td><fmt:message key="login.unm" bundle="${lang}"/></td>
   <td><input type="text" name="userName"/></td>
   <td></td>
 </tr>
 <tr>
   <td><fmt:message key="login.pwd" bundle="${lang}"/></td>
   <td><input type="text" name="password"/></td>
   <td></td>
 </tr>
 <tr>
   <td><input type="submit" value='<fmt:message key="login.caption" bundle="${lang}"/>'/></td>
 </tr>

</table>
</form>


</body>
</html>