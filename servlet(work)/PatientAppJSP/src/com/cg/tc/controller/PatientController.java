package com.cg.tc.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class PatientServlet
 */
@WebServlet(name="PatientController",urlPatterns = { "/viewAll","/viewId","/search","/home"})
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isValid;
		PatientService ps=new PatientService();
		HttpSession session=request.getSession(true);
		// Add Request
		String reqURL = request.getServletPath();
		if (reqURL.equals("/viewId")) {
			/*RequestDispatcher rd=request.getRequestDispatcher("ViewPatient.jsp");
			rd.forward(request, response);*/
			response.sendRedirect("ViewPatient.jsp");
		} // End of AddRequest
		
		if (reqURL.equals("/search")) 
		{
			
		     int pid=Integer.parseInt(request.getParameter("id"));
		     PatientDto pat=ps.viewById(pid);
			 session.setAttribute("Pat1",pat);
			 RequestDispatcher rd=request.getRequestDispatcher("ViewPatient.jsp");
			 rd.include(request, response);
		 }
		
		
		
		//view all patients 
		if (reqURL.equals("/viewAll")) {
			List<PatientDto> pList = ps.viewAllPatient();
			session.setAttribute("patientList", pList);
			 RequestDispatcher rd=request.getRequestDispatcher("viewAllPatients.jsp");
			 rd.forward(request, response);
			

		} // End of View Request
			 
		
		if(reqURL.equals("/home"))
		{
			session.removeAttribute("Pat1");
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			 rd.forward(request, response);
		}
				
			 
		 }
		
		
			 
	}
		



