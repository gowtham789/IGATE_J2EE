package com.cg.tc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.tc.service.PatientService;

/**
 * Servlet implementation class PatientController
 */
@WebServlet(name="PatientController", urlPatterns ={"/login","/snoop","/viewAll","/viewId","/insert","/delete"})
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		PatientService ps=new PatientService();
		//login
		
		String uname =request.getParameter("id");
		String pwd=request.getParameter("pass");
		boolean status=ps.isLogin(uname,pwd);
		String reqURL = request.getServletPath();
		if (reqURL.equals("/login")) 
		{
			
		if(status==true)
		{
			session.setAttribute("uname",uname);
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
			
		}
		else
		{
			response.sendRedirect("Error.jsp");
		}
		}
	}

}
