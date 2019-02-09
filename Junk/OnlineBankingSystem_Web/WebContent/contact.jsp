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
        <li><a href="index.jsp">Home</a></li>
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
<div class="page padding-bottom">
  <div class="content_wrap">
    <div class="left-panel">
      <div class="generic-content">
        <div class="title">
          <h1>Contact us</h1>
          <h2>IGATE BANKING SERVICES</h2>
        </div>
        <div class="content">
          <div class="address martop">
            <div class="panel">
              <div class="title">
                <h1>Address - 01</h1>
              </div>
              <div class="content">
                <p>Block No:5, Some where Road,<br />
                  City name, State, Country name</p>
                <p class="padTop"><span>Phone :</span> 000 888 88888</p>
                <p><span>Email :</span> <a href="mailto:info@companyname.com">info@companyname.com</a></p>
              </div>
            </div>
            <div class="panel marginTop">
              <div class="title">
                <h1>Address - 02</h1>
              </div>
              
            </div>
          </div>
        </div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="right-panel">
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
      <div class="contact-panel">
        
  <!-- end of BOX WRAPPER -->
  <div class="clear"></div>
</div>
<div class="footer-wrapper">
  <div class="footer">
    <div class="panel">
      <div class="title">
       
        <div class="content">
        
        </div>
      </div>
    </div>
    <div class="panel">
      <div class="title">
        
        <div class="content">
          
        </div>
      </div>
    </div>
    <div class="panel border-right">
      <div class="title">
      
        <div class="content">
          
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
</body>
</html>
