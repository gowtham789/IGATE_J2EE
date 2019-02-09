package com.igate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginExample
 */
@WebServlet("/CheckUser")
public class LoginExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginExample() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the request values
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		//Check if it is valid
		//service.isValid(username,password);
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.write("<HTML><HEAD></HEAD><BODY bgcolor='blue'>");
		
		if(username.equals("chnsiptrg4") && password.equals("igate@123"))
		{
			out.write("<H1> Welcome </H1>");
			out.write("<H2>Logged in Successfully...</H2>");
		}
		else
		{
			out.write("<H1> Sorry .... Invalid </H1>");
		}
		out.write("</BODY></HTML>");
	}

}
