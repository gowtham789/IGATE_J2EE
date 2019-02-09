<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
					<li><a href="index.html">Home</a></li>
					<li><a href="Login.html">Login</a></li>
					<li><a href="services.html">Services</a></li>
					<li><a href="contact.html">Contact</a></li>
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
						<h1>BOOK YOUR LOCKER</h1>
					</div>
					<div class="content marbottom30">
						<form method="post">
							<h3>
								<div class="row">
									<label>Name</label> <input id="txt_Name" type="text" />
								</div>
								<div class="row">
									<label>Email</label> <input id="Email" type="email" />
								</div>
								<div class="row">
									<label>Phone</label> <input id="Phone" type="tel" />
								</div>
								<div class="row">
									<label>Account number</label> <input id="txt_Accountnumber"
										type="text" />
								</div>
								<div class="row">
									<label>Account Type</label> <select id="sel_AccountType">
										<option value="Savings">Savings</option>
										<option value="Current">Current</option>
										<option value="Fixed Deposit">Fixed Deposit</option>
									</select>
								</div>
								<div class="row">
									<label>Locker Type</label> <select id="sel_LockerType">
										<option value="Platinum">Platinum</option>
										<option value="Gold">Gold</option>
										<option value="Silver">Silver</option>
									</select>
								</div>
								<div class="row">
									<label>Amount</label> <input id="txt_Amount" />
								</div>
								<div class="row">
									<label>Locker Size</label> <input id="txt_LockerSize" />
								</div>
								<div class="row">
									<label>Period Required</label> <select id="sel_PeriodRequired">
										<option value="6 Months">6 Months</option>
										<option value="1 Year">1 Year</option>
										<option value="2 Years">2 Years</option>
										<option value=""></option>
									</select>
								</div>
								<div class="row">
									<input type="submit" value="SUBMIT" />
								</div>
							</h3>
						</form>


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
						<P>Write your stuff here .</P>
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
					<div class="content">
						
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>
