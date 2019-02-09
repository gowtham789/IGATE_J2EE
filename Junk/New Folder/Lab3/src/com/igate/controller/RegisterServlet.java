package com.igate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.dto.RegisterDto;
import com.igate.service.RegisterService;

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
		
		RegisterService service=new RegisterService();
		RegisterDto r=new RegisterDto();
		
		//Get the request values
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String pwd=request.getParameter("pwd");
		String gender=request.getParameter("gen");
		String[] skills=request.getParameterValues("skill");
		
		
		
		StringBuffer buffer = new StringBuffer(50);
		for(String s:skills)
		{
			buffer.append(s);
			buffer.append(",");
		}
		String city=request.getParameter("city");
		r.setfName(fname);
		r.setlName(lname);
		r.setPwd(pwd);
		r.setGender(gender);
		r.setSkill(buffer.toString());
		r.setCity(city);
		
		System.out.println(r);
		
		String insert=service.insertRegister(r);	
		
		if(insert!=null)
		{
			PrintWriter out=response.getWriter();
			out.write("<html><head></head><body>");
			out.write("<h1>Welcome</h1>");
			out.write("<h3>"+insert+"</h3>");
			out.write("</body></html>");
		}
		else
		{
			response.sendRedirect("Error.html");
		}
		
	}

}
