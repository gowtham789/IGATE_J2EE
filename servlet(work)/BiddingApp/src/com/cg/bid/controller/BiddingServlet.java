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

import com.cg.bid.service.BiddingService;

/**
 * Servlet implementation class BiddingServlet
 */
@WebServlet("/BiddingServlet")
public class BiddingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BiddingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//Get the request values
		HttpSession session=request.getSession(true);
		BiddingService bs=new BiddingService();
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		
			bs.isLogin(username, password);
			if(bs.isLogin(username, password)==true)
			{
				session.setAttribute("uname",username);
				RequestDispatcher rd=request.getRequestDispatcher("/ViewServlet");
				rd.include(request, response);
			}
			else
			{	
				out.write("invalid user");
				RequestDispatcher rd=request.getRequestDispatcher("/ErrorServlet");
				rd.include(request, response);
			}	
	}

}
