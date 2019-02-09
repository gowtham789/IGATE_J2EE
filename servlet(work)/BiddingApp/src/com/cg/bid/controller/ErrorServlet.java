package com.cg.bid.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head></html>");
		out.write("<body>You are a invalid user,cannot access bidding site,contact admin for registration");
		out.write("<form action='BiddingServlet' method='post'>");
		out.write("<table border='3'>");
		out.write("<tr><td> Username :</td>");
		out.write(" <td> <input type='text' name='uname' required/></td></tr>");
		out.write("<tr><td> Password :</td>");
		out.write("<td> <input type='password' name='pwd' required/></td></tr>");
		out.write("<tr><td colspan='2'><input type='submit' value='Login'/></td></tr>");
		out.write("</form>");
		out.write("</table>");
		out.write("</body>");
	}

}
