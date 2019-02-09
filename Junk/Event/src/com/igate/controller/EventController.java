package com.igate.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.dto.Events;
import com.igate.dto.users;
import com.igate.exception.EventException;
import com.igate.service.EventService;
import com.igate.service.IEventService;

/**
 * Servlet implementation class EventController
 */
@WebServlet(name = "EventController", urlPatterns = { "/details", "/AddDetails","/view","/viewbook","/home"})
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		IEventService es=new EventService();
		String reqURL = request.getServletPath();
		if (reqURL.equals("/details"))
		{
				try {
					ArrayList<Events> elist=es.geteventType();
					session.setAttribute("eventType", elist);
					RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
					rd.include(request, response);
					
					
					
				} catch (EventException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
		}
		if(reqURL.equals("/AddDetails"))
		{
			ServletContext sc=getServletContext();
			Object cnt=sc.getAttribute("user1");
			int temp;
			if(cnt==null)
			{
				temp=0;
				sc.setAttribute("user1",temp);
			}
			else
			{
				temp=(int)sc.getAttribute("user1");
				temp=temp+1;
				sc.setAttribute("user1", temp);
			}
			
			users u=new users();
			
			u.setName(request.getParameter("uname"));
			u.setEventtype(request.getParameter("etype"));
			u.setNumofseats(Integer.parseInt(request.getParameter("seats")));
			try {
				es.Adduser(u);
				
				session.setAttribute("user",u);
				RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");
				rd.include(request, response);
				
				
				
			} catch (EventException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
			
			
			
		}
		if(reqURL.equals("/view"))
		{
			
			try {
				ArrayList<Events> elist1=es.geteventType();
				session.setAttribute("viewEvents",elist1);
				RequestDispatcher rd=request.getRequestDispatcher("newEvents.jsp");
				rd.include(request, response);
				
			} catch (EventException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
			
		}
		if(reqURL.equals("/viewbook"))
		{
			
			
			System.out.println("in servlet");
			int eventId = Integer.parseInt(request.getParameter("id"));
			System.out.println("event id "+eventId);
			try {
				Events e2=es.byid(eventId);
				session.setAttribute("event1",e2);
				
				System.out.println(e2);
				
				users u1=(users) session.getAttribute("user");
				System.out.println(u1);
				int bid=es.booking(e2, u1);
				session.setAttribute("bookingId",bid );
				
				System.out.println("fhgdsjfs"+bid);
				
				RequestDispatcher rd=request.getRequestDispatcher("Book.jsp");
				rd.include(request, response);
				
				
			} catch (EventException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
			
			
			
			
		}
		if(reqURL.equals("/home"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");
		rd.include(request, response);
		
	}

}
}
