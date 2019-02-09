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

	<div class="header">
		<div class="row">
			<div class="logo">
				<h1>BANKING</h1>
			</div>
			<div class="menu">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="services.jsp">Services</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<c:choose>
						<c:when test="${LoginStatus == null}">
						<c:redirect url="login.jsp"></c:redirect>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${LoginStatus == 'Login Successful'}">
									<li><a href="PersonalInfo.jsp">My Account</a></li>
									<li><a href="Logout">Logout</a></li>
								</c:when>
								<c:otherwise>
								<c:redirect url="login.jsp"></c:redirect>
								</c:otherwise>
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
				<div class="panel">
					<div class="title">
						<h1>Account Overview</h1>
					</div>
					<div class="content marbottom30">
						<h3>						       
							<ul>
								<table>
								<tr>
								<td>
								<label> Account No </label>
								</td>
								<td>
								<label>Date of transaction </label>
								</td>
								<td>
								<label>Transaction amount</label>
								</td>
								<td>
								<label>Transaction Description </label>
								</td>
								<td>
								<label>Transaction Id </label>
								</td>
								<td>
								<label>Transaction Type </label>
								</td>
								</tr>	
								<c:forEach items="${transactions}" var="transaction">								
								<tr>
								<td>
								<label> ${transaction.getAccountNo()} </label>
								</td>
								<td>
								<label> ${transaction.getDateoftransaction()} </label>
								</td>
								<td>
								<label> ${transaction.getTranamount()} </label>
								</td>
								<td>
								<label> ${transaction.getTranDescription()} </label>
								</td>
								<td>
								<label> ${transaction.getTransactionId()} </label>
								</td>
								<td>
								<label> ${transaction.getTransactiontype()} </label>
								</td>
								</tr>								
								</c:forEach>
								</table>
							</ul>
								
						</h3>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="right-panel">
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
					<div class="content">
						
					</div>
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
					
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>
