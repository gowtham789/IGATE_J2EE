package com.cg.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.login.exception.LoginException;
import com.cg.login.service.LoginService;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    public LoginServlet2() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the request values
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		LoginService ls=new LoginService();
		try{
			ls.isLogin(username, password);
			if(ls.isLogin(username, password)==true)
			{
				response.sendRedirect("Success.html");
			}
			else
			{
				response.sendRedirect("Error.html");
			}								
		}
		catch(LoginException e)
		{
			System.out.println(e.getMessage());
		}
		
		//Check if it is valid
		//service.isValid(username,password);		
		
		/*if(username.equals("chnsiptrg4") && password.equals("igate@123"))
		{
			response.sendRedirect("Success.html");
		}
		else
		{
			response.sendRedirect("Error.html");
		}*/
	
	}
	

}
