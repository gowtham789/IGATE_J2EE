<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<%@taglib uri="linktojdbc" prefix="igate"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1>Illustrating Custom Tag</h1>
 
 <c:set var="jdbcDriver" value="oracle.jdbc.driver.OracleDriver"/>
 
 <igate:jdbc driver="oracle.jdbc.driver.OracleDriver"/> 
 
 <h6>Custom Tag Execution complete with JDBC Driver Loading</h6>

</body>
</html>