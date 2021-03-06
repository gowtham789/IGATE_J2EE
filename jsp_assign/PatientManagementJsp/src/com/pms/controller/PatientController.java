package com.pms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pms.dto.PatientDTO;
import com.pms.service.IPatientService;
import com.pms.service.PatientService;

/**
 * Servlet implementation class PatientController
 */
@WebServlet(name = "PatientController", urlPatterns = {"/ViewById","/ViewId","/ViewPatient","/ViewAllPatients","/ViewPatient"})
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
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IPatientService ipserv=new PatientService();
		PatientDTO pd=new PatientDTO();
		// Create Service Object
				// Check the type of Request
				String reqURL = request.getServletPath();
				HttpSession mysession=request.getSession(true);
				if (reqURL.equals("/ViewById")) {
					RequestDispatcher rd=request.getRequestDispatcher("ViewPatient.jsp");
					rd.include(request, response);
				} 

				if (reqURL.equals("/ViewId")) 
				{
					int id=Integer.parseInt(request.getParameter("id"));
					if(ipserv.isPatient(id)==true)
					{
						pd=ipserv.getPatientDetails(id);
						mysession.setAttribute("patient", pd);
						RequestDispatcher rd=request.getRequestDispatcher("ViewPatient.jsp");
						rd.include(request, response);
					}
					
				} // End of ViewPatientById request
				
				if (reqURL.equals("/ViewAllPatients")) {
					ArrayList<PatientDTO> patientList= new ArrayList<PatientDTO>();
					patientList=ipserv.viewAllPatients();
					mysession.setAttribute("list", patientList);
					if(patientList.size()!=0)
					{
					RequestDispatcher rd=request.getRequestDispatcher("ViewAll.jsp");
					rd.include(request, response);
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
						rd.include(request, response);
					}
				} 
	}

}
