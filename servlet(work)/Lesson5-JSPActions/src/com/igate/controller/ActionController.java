package com.igate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.dto.Employee;

/**
 * Servlet implementation class ActionController
 */
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String id=request.getParameter("eid");
		int eid=Integer.parseInt(id);
		
		String enm=request.getParameter("enm");
		
		String sal=request.getParameter("esl");
		double esl=Double.parseDouble(sal);
		
		Employee employee=new Employee();
		
		employee.setEid(eid);
		employee.setEnm(enm);
		employee.setEsl(esl);
		
		getServletContext().setAttribute("employee",employee);
		
		response.sendRedirect("output.jsp");
	}

}
