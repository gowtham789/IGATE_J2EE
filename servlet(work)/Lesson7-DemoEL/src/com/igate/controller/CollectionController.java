package com.igate.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.dto.Employee;

/**
 * Servlet implementation class CollectionController
 */
public class CollectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> nameList=new ArrayList<String>();
		
		nameList.add("Rama");
		nameList.add("Sita");
		nameList.add("Lava");
		nameList.add("Kusha");
		
		ArrayList<Employee> employeeList=new ArrayList<Employee>();
		
		Employee e1=new Employee(100,"Rama",33333.33);
		Employee e2=new Employee(101,"Sita",22222.22);
		Employee e3=new Employee(102,"Lava",22222.22);
		Employee e4=new Employee(103,"Kusha",22222.22);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		
		
		HashMap<Long, String> nameIdMap=new HashMap<Long, String>();
		
		nameIdMap.put(100l,"Rama");
		nameIdMap.put(101l,"Sita");
		nameIdMap.put(102l,"Lava");
		nameIdMap.put(103l,"Kusha");
		
		
	    HashMap<String, String> nameDomainMap=new HashMap<String, String>();
		
	    nameDomainMap.put("Rama","JEE");
	    nameDomainMap.put("Sita",".Net");
	    nameDomainMap.put("Lava","VnV");
	    nameDomainMap.put("Kusha","BI");
	
		getServletContext().setAttribute("nameList",nameList);
		getServletContext().setAttribute("employeeList",employeeList);
		getServletContext().setAttribute("nameIdMap",nameIdMap);
		getServletContext().setAttribute("nameDomainMap",nameDomainMap);
		
		response.sendRedirect("collection/collection.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
