package com.igate.ctlr;

import java.io.IOException;
import java.util.ArrayList;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.dto.Course;
import com.igate.service.CourseService;

/**
 * Servlet implementation class courseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operation=request.getParameter("op");
		int op=Integer.parseInt(operation);
		CourseService eService=new CourseService();
		
		switch(op)
		{
		
		case 1:
			    String id=request.getParameter("id");
			    String crsNm=request.getParameter("name");
			    String duration=request.getParameter("dur");
			    int crsId=Integer.parseInt(id);
			    int crsDur=Integer.parseInt(duration);
				System.out.println("In Add Operation");
				
				Course course=new Course();
				course.setCourseId(crsId);
				course.setCourseName(crsNm);
				course.setCourseDuration(crsDur);
				
				boolean addSuc=eService.addcourse(course);
				if(addSuc)
					response.sendRedirect("addSuccess.jsp");
				else
					response.sendRedirect("addFailure.jsp");
				break;
		
		case 2: 
			    System.out.println("In Retrieve Operation");
				ArrayList<Course> cList=eService.retrieveAllcourse();
				if(cList!=null)
				{
				System.out.println(cList);
				getServletContext().setAttribute("cList",cList);
				response.sendRedirect("retrieve.jsp");
				}
				break;
		case 3:
			System.out.println("In search operation");
			int cid=Integer.parseInt(request.getParameter("cid"));
			Course course1 = eService.retrieveCourse(cid);
			request.setAttribute("course", course1);
			RequestDispatcher rd = request.getRequestDispatcher("retrieveCourse.jsp");
			rd.forward(request, response);
		}
		
			
			
		
		
		
		
	}
	
	
	

}
