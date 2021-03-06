package com.cg.tc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.tc.dto.PatientDto;
import com.cg.tc.service.PatientService;

/**
 * Servlet implementation class PatientServer
 */
@WebServlet(name="PatientServer", urlPatterns = { "/Add","/View","/AddPatient","/ViewPatient"})
public class PatientServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServer() {
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
		
		PatientService ps=new PatientService();
		boolean isValid;
		PrintWriter out=response.getWriter();
		//Adding An Employee
		// Add Request
		String reqURL = request.getServletPath();
				if (reqURL.equals("/Add")) {
					response.sendRedirect("AddPatient.html");
				} // End of AddRequest

				// Add New Employee Request
				if (reqURL.equals("/AddPatient")) {
					PatientDto pdto=new PatientDto();
					// Get details from form and store in Bean - Model
					pdto.setPatientName(request.getParameter("pname"));
					pdto.setAge(Integer.parseInt(request.getParameter("age")));
					pdto.setPhoneNo(request.getParameter("mno"));
					pdto.setDescription(request.getParameter("desc"));
					
					int count=ps.addPatientDetails(pdto);
					if (count > 0)
						response.sendRedirect("Success.html");
					else
						response.sendRedirect("Error.html");
				} // End of AddPatient Request
				
				//Adding An Employee
				// Add Request
						if (reqURL.equals("/View")) {
							response.sendRedirect("ViewPatient.html");
						} // End of AddRequest
						
						if (reqURL.equals("/ViewPatient")) {
							PatientDto pdto=new PatientDto();
						int id=pdto.setPatientId(Integer.parseInt(request.getParameter("pid")));
						
						 isValid=ps.isPatient(id);
						 if(isValid)
						 {
							 PatientDto pb=ps.getPatientDetails(id);
							 response.setContentType("text/html");
							 out.write("<h2>Patient Details</h2>");
							out.print("<html><head></head><body><table border='4'>");
							out.print("<tr><td>Patientid</td><td>Patientname</td><td>Age</td><td>PhoneNo</td><td>Description</td><td>Date</td>");
							out.write("<tr>");	
							 out.write("<td>"+pb.getPatientId()+"</td>");
							 out.write("<td>"+pb.getPatientName()+"</td>");
							 out.write("<td>"+pb.getAge()+"</td>");
							 out.write("<td>"+pb.getPhoneNo()+"</td>");
							 out.write("<td>"+pb.getDescription()+"</td>");
							 out.write("<td>"+pb.getConsultationDate()+"</td>");
							 out.write("</table>");
							 out.write("</body>");
							 out.write("</html>");
						 }
						 else
						 {
							 response.sendRedirect("Errorpat.html");
						 }
						 
						}
	}

	}
