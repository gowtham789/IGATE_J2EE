package com.igate.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLController
 */
public class JSTLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSTLController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int index = Integer.parseInt(request.getParameter("index"));
		switch(index){
			case 1: case 2: case 3:
			//Code to demonstrate c:set,c:out and c:remove tags 
			String company="IGATE";
			getServletContext().setAttribute("company",company);
			response.sendRedirect("core/coreTags1.jsp");
			break;
			case 4: case 5: case 6:
			//Code to demonstrate c:forEach, c:if tags
			Employee employee1=new Employee();
			employee1.setEid(101);
			employee1.setEnm("Rama");
			employee1.setEsl(22222.22);
			
			Employee employee2=new Employee();
			employee2.setEid(102);
			employee2.setEnm("Sita");
			employee2.setEsl(33333.33);
			
			Employee employee3=new Employee();
			employee3.setEid(103);
			employee3.setEnm("Lava");
			employee3.setEsl(23233.33);
			
			Employee employee4=new Employee();
			employee4.setEid(104);
			employee4.setEnm("Kusha");
			employee4.setEsl(31313.33);
			
			
			ArrayList<Employee> eList=new ArrayList<Employee>();
			
			
			eList.add(employee1);
			eList.add(employee2);
			eList.add(employee3);
			eList.add(employee4);
			
			getServletContext().setAttribute("eList",eList);
			response.sendRedirect("core/coreTags2.jsp");
			break;
			case 7:
			//Code to demonstrate c:choose,c:when and c:otherwise tags
			Date today=new Date();
			int day=today.getDay();
			getServletContext().setAttribute("day",day+1);
			response.sendRedirect("core/coreTags4.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
