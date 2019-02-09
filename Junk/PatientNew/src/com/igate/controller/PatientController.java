package com.igate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.dto.PatientBean;
import com.igate.exception.PatientException;
import com.igate.service.IPatientService;
import com.igate.service.PatientService;

/**
 * Servlet implementation class PatientController
 */
@WebServlet(name = "PatientController", urlPatterns = { "/viewPatients", "/viewById","/search","/Login","/home","/log","/add","/addUser"})
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		
		String reqURL = request.getServletPath();
		IPatientService ps=new PatientService();
		PatientBean p=new PatientBean();
		PrintWriter out=response.getWriter();
		
		
		
		if (reqURL.equals("/Login"))
		{
			String username = request.getParameter("uname");
			String password = request.getParameter("pwd");
			if (username.equals("842744") && password.equals("gowti")) 
			{
				session.setAttribute("uname", username);
				ServletContext sc=getServletContext();
				Object cnt=sc.getAttribute("user");
				int temp;
				if(cnt==null)
				{
					temp=0;
					sc.setAttribute("user",temp);
				}
				else
				{
					temp=(int)sc.getAttribute("user");
					temp=temp+1;
					sc.setAttribute("user", temp);
				}
				
				// Display Welcome
				// Forward to Home.jsp
				
				

				response.sendRedirect("Home.jsp");
			} else { // Error
					response.sendRedirect("Error.jsp");
				}
		}// End of Login Request
		
		
		if (reqURL.equals("/viewPatients"))
		{
			try {
				ArrayList<PatientBean> pList= ps.getAllPatients();
				
				session.setAttribute("PatientList", pList);
				for(PatientBean p1:pList)
				{
					System.out.println(p1.getPatientName());
				}
				
				RequestDispatcher rd=request.getRequestDispatcher("ViewPatients.jsp");
				rd.include(request,response);
				
			} catch (PatientException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
		}//End of ViewPatient
		
		if(reqURL.equals("/viewById"))
		{
			System.out.println("in viewbyid");
			response.sendRedirect("ViewPatient.jsp");
			
		}
		
		if (reqURL.equals("/search"))
		{
			System.out.println("in search");
			 int id;
			 id=(Integer.parseInt(request.getParameter("id")));
			 boolean valid;
			try {
				valid = ps.isPatient(id);
				System.out.println(valid);
				if(valid)
				 {
					PatientBean patient=ps.getPatientById(id);
					System.out.println(patient);
					session.setAttribute("pat", patient);
					RequestDispatcher rd=request.getRequestDispatcher("ViewPatient.jsp");
					rd.forward(request, response);
				 }
				 else
				 {
					 response.sendRedirect("Error.jsp");
				 }
				
			} catch (PatientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // End of search
		
			if (reqURL.equals("/home"))
			{	
				session.removeAttribute("pat");
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				rd.include(request,response);
				
				 
			}
			if(reqURL.equals("/log"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request,response);
				session.invalidate();
			}
			
			if(reqURL.equals("/add"))
			{
				System.out.println("hi");
				response.sendRedirect("AddPatient.jsp");
			}
			if(reqURL.equals("/addUser"))
			{
				PatientBean pb=new PatientBean();
		
				pb.setPatientName((request.getParameter("pName")));
				pb.setAge(Integer.parseInt(request.getParameter("age")));
				pb.setPhone(request.getParameter("phone"));
				pb.setDescription(request.getParameter("desc"));
				pb.setDocName("doc");
				System.out.println("hello");
				int count1;
				try 
				{
					count1 = ps.addPatientDetails(pb);
					if (count1 > 0)
						response.sendRedirect("Success.jsp");
					else
						response.sendRedirect("Error.jsp");
				} // End of AddEmployee Request
					
					
				catch (PatientException e)
				{
					
					e.printStackTrace();
				}
				

				

			}
			
			
		}		
			

}

			