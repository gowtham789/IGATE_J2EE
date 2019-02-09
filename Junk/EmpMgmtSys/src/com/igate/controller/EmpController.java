package com.igate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.dto.Employee;
import com.igate.service.EmpService;

/**
 * Servlet implementation class EmpController
 */
@WebServlet(name = "EmployeeController", urlPatterns = { "/Login", "/Add",
		"/View", "/AddEmployee","/Delete" })
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Create Service Object
		EmpService empServ = new EmpService();

		// Create a HttpSession
		HttpSession mySes = request.getSession(true);

		// Check the type of Request
		String reqURL = request.getServletPath();

		// Login Request
		if (reqURL.equals("/Login")) {
			String username = request.getParameter("uname");
			String password = request.getParameter("pwd");
			if (password.equals("JEE")) { // Display
				// Welcome
				mySes.setAttribute("uname", username);
				mySes.setAttribute("company", "IGATE");
				// Forward to Home.html
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			} else { // Error
				response.sendRedirect("Error.jsp");
			}
		}// End of Login Request

		// Add Request
		if (reqURL.equals("/Add")) {
			response.sendRedirect("AddEmp.jsp");
		} // End of AddRequest

		// Add New Employee Request
		if (reqURL.equals("/AddEmployee")) {
			Employee newEmp = new Employee();
			// Get details from form and store in Bean - Model
			newEmp.setEmpid(Integer.parseInt(request.getParameter("empId")));
			newEmp.setEname(request.getParameter("empName"));
			newEmp.setSalary(Float.parseFloat(request.getParameter("sal")));
			newEmp.setDesig(request.getParameter("desig"));

			int count = empServ.addEmployee(newEmp);
			if (count > 0)
				response.sendRedirect("Success.jsp");
			else
				response.sendRedirect("Error.jsp");
		} // End of AddEmployee Request

		if (reqURL.equals("/View")) {
			List<Employee> empList = empServ.getEmployees();
			mySes.setAttribute("employees",empList);
			RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
			rd.forward(request, response);
			

		} // End of View Request
 System.out.println("URL ="+reqURL);
		if (reqURL.equals("/Delete")) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			int empId = Integer.parseInt(request.getParameter("id"));
			out.write("<HTML><HEAD></HEAD><body><h1> Delete</h1><table border='8'>");
			out.write("Request to delete employee with id " + empId);
			out.write("</body></HTML>");
		} // End of AddRequest
	}

}
