package com.igate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.service.LoginService;

/**
 * Servlet implementation class LoginServl
 */
@WebServlet("/LoginServl")
public class LoginServl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServl() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService service=new LoginService();
		//Get the request values
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		//Check if it is valid
		
		boolean valid=service.isValid(username,password);		
		
		if(valid)
		{
			response.sendRedirect("Success.html");
		}
		else
		{
			response.sendRedirect("Error.html");
		}
	}

}
