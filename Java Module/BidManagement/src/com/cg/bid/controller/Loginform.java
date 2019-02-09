package com.cg.bid.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bid.service.LoginService;


@WebServlet("/Loginform")
public class Loginform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Loginform() {
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
		 
		 response.setContentType("text/html");  
	     PrintWriter out = response.getWriter();
		if(valid==true)
		{
		   
		HttpSession session=request.getSession(true);
		session.setAttribute("username",username);
		RequestDispatcher rd=request.getRequestDispatcher("DisplayServlet");
		rd.forward(request, response);
			
		}
		else
		{
			out.write("<HTML><HEAD></HEAD><BODY>");  
			out.print("<h3>You are invalid user,cannot acces bidding site,contact"
					+ " admin for registration</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			out.write("</BODY></HTML>");
		}

	}

}
