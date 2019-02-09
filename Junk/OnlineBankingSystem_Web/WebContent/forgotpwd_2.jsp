<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online Banking</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href="css/Login-style.css" rel="stylesheet" type="text/css" />

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
				<div class="panel">
					<div class="title">
						<h1>FORGOT YOUR PASSWORD</h1>
					</div>
					<div class="content marbottom30">
						<h3>
							<form id="forgotpwd" method="post" action="PasswordReset">
								<ul>
									<li id="li_6"><label class="description" for="element_4">SECRET Question
									</label>
										<div>
											<input name="Question"
												class="element text medium" type="text" maxlength="255"
												value="${SecretQuestion}"  readonly="readonly"/>
										</div></li>
									<li id="li_4"><label class="description" for="element_4">Answer
									</label>
										<div>
											<input name="Answer"
												class="element text medium" type="text" maxlength="255"
												value="" />
										</div>
										<c:choose>
											<c:when
												test="${ResetStatus != null && ResetStatus == 'sbq500#' }">
												<p>
													This is your temporary password sbq500#
												</p>
											</c:when>
											<c:otherwise>
												<p>
													<small>Enter your account number</small>
												</p>
											</c:otherwise>
										</c:choose>
										</li>
									<br> </br>
									<br> </br>
									<li class="buttons"><input id="saveForm"
										class="button_text" type="submit" name="submit" value="Submit" />
									</li>
								</ul>
							</form>
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
						<p>
							
						</p>
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
