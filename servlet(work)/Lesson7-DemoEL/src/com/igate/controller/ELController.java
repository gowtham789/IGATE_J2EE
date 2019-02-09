package com.igate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.dto.Dog;
import com.igate.dto.Employee;

/**
 * Servlet implementation class ELController
 */
public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Dog dog=new Dog();
		
		dog.setName("Tommy");
		dog.setBreed("Beagle");
		
		Employee employee=new Employee();
		
		employee.setEid(100);
		employee.setEnm("Xavier");
		employee.setEsl(33333.33);
		employee.seteDog(dog);
		
		getServletContext().setAttribute("employee",employee);
		
		response.sendRedirect("object/employeeInfo.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
