<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online Banking</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- end of SOCIAL ICONS -->
<div class="header">
  <div class="row">
    <div class="logo">
      <h1>BANKING</h1>
    </div>
    <div class="menu">
      <ul>
        <li><a href="index.jsp" class="active">Home</a></li>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="services.jsp">Services</a> </li>
        <li><a href="contact.jsp">Contact</a></li>
        <c:choose>
						<c:when test="${LoginStatus == null}">      						
   						 </c:when>
						<c:otherwise>
						    <c:choose>
						    <c:when test="${LoginStatus == 'Login Successful'}">  
						    <li><a href="PersonalInfo.jsp">My Account</a></li>
      					 	<li><a href="Logout">Logout</a></li>    						
   						    </c:when>
      		                </c:choose>
   						 </c:otherwise>
					</c:choose>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of MENU WRAPPER -->
<div class="banner-wrapper">
  <div class="row">
    
  </div>
  <div class="clear"></div>
  
</div>
<!-- end of BANNER WRAPPER -->
<div class="page">
  <div class="boxs">
    <div class="panel">
     
      <div class="panel-img">
      <c:choose>
      <c:when test="${LoginStatus == '' }">
      
      </c:when>
      </c:choose>
      <a href="login.jsp"> Internet banking</a>
      </div>
     
      <div class="controller">
        <div class="clear"></div>
      </div>
    </div>
  </div>
 
      <div class="controller">
        
        <div class="clear"></div>
      </div>
    </div>
  </div>
  
    </div>
  </div>
  <div class="clear"></div>
</div>
<!-- end of BOX WRAPPER -->
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="left-panel">
	
      <div class="clear"></div>
      <br></br>
      <br />
      <br></br>
      <div class="panel"></div>
       
    </div>
    <div class="right-panel"> 
<br>	</br>
      <div class="panel martop">
        
        <div class="clear"></div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
  <!-- end of BOX WRAPPER -->
  <div class="clear"></div>
</div>
<div class="footer-wrapper">
  <div class="footer">
    <div class="panel">
      <div class="title">
        <h1>ABOUT US</h1>
        <h2>IGATE BANKING SERVICES</h2>
       
      </div>
    </div>
    <div class="panel">
      <div class="title">
        <h1>CONTACT US</h1>
        <h2>IGATE BANKING SERVICES</h2>
        <div class="content">
        
         
        </div>
      </div>
    </div>
    <div class="panel border-right">
      <div class="title">
        <h1>COPY RIGHT</h1>
        <h2>IGATE Developers</h2>
        <div class="content">
        
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
</body>
</html>

