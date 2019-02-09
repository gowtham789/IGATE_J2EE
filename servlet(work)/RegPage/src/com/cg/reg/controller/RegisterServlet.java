package com.cg.reg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;
import com.cg.reg.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    
    public RegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		RegisterDto rdto=new RegisterDto();
		RegisterService rs=new RegisterService();
		rdto.setFname(request.getParameter("fname"));
		rdto.setLname(request.getParameter("lname"));
		rdto.setPassword(request.getParameter("pwd"));
		rdto.setGender(request.getParameter("gender"));
		System.out.println("hi 0");
		String[] skill = request.getParameterValues("skills");
		
		StringBuffer b=new StringBuffer();
		for(String s:skill)
		{
			b.append(s);
			b.append(',');
		}
		
		rdto.setSkills(b.toString());
		System.out.println("hi 0.1235");
		rdto.setCity(request.getParameter("city"));
		
		
		try{
			int result=rs.insertRegister(rdto);
			if(result!=0)
			{
				pw.print("Registration Successful");
				pw.println("Name	 :" +request.getParameter("fname")+ "	Inserted Successfully");
				//response.sendRedirect("Success.html");
			}
			else
			{
				System.out.println("hi 2");
				response.sendRedirect("Error.html");
			}
		}
		catch(RegisterException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
