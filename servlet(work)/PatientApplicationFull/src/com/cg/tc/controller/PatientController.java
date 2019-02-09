package com.cg.tc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.tc.dto.PatientDto;
import com.cg.tc.service.PatientService;

/**
 * Servlet implementation class PatientController
 */
@WebServlet(name="PatientController", urlPatterns ={"/login","/viewAll","/viewId","/insert","/delete","/search","/home"})
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
		
		//int pid =Integer.parseInt(request.getParameter("id"));
		
		String reqURL = request.getServletPath();
		if (reqURL.equals("/login")) 
		{
			String pwd=request.getParameter("pass");
			String username=request.getParameter("uname");
			if(username.equals("chnsiptrg4") && pwd.equals("priya123"))
		{
			session.setAttribute("username",username);
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
			
		}
		else
		{
			response.sendRedirect("Error.jsp");
		}
		}
		//view all patients 
				if (reqURL.equals("/viewAll")) {
					List<PatientDto> pList = ps.getAllPatients();
					session.setAttribute("patientList", pList);
					 RequestDispatcher rd=request.getRequestDispatcher("viewAllPatients.jsp");
					 rd.forward(request, response);
					

				} // End of View Request
		}
	}
