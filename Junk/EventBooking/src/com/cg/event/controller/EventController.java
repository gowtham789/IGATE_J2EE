package com.cg.event.controller;

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

import com.cg.event.dto.EventsDTO;
import com.cg.event.dto.UsersDTO;
import com.cg.event.exception.EventException;
import com.cg.event.service.EventService;
import com.cg.event.service.IEventService;



@WebServlet(name ="EventController", urlPatterns = { "/details", "/addDetails","/view","/viewbook","/home"})
public class EventController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	
	EventService es=new EventService();
	
	
	
    
    public EventController() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		IEventService es=new EventService();
		String reqURL = request.getServletPath();
		
		if(reqURL.equals("/addDetails"))
		{
			
			UsersDTO u=new UsersDTO();
			
		
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
			
			
			u.setName(request.getParameter("uname"));
			u.setEventtype(request.getParameter("etype"));
			u.setNumofseats(Integer.parseInt(request.getParameter("seats")));
			try
			{
				es.addUser(u);
				session.setAttribute("user",u);
				RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");
				rd.include(request, response);
				
			}
			catch(EventException e) 
			{
				
				request.setAttribute("msg",e.getMessage());
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				rd.include(request, response);
			}
			
		}
		if (reqURL.equals("/details"))
		{
				try 
				{
					ArrayList<EventsDTO> elist=es.getEventType();
					session.setAttribute("eventType", elist);
					RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
					rd.include(request, response);
				} 
				catch (EventException e) 
				{
					request.setAttribute("msg",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
					rd.include(request, response);
				}
				
		}
		
		if(reqURL.equals("/view"))
		{
			
			try {
				ArrayList<EventsDTO> elist1=es.getEventType();
				session.setAttribute("viewEvents",elist1);
				RequestDispatcher rd=request.getRequestDispatcher("newEvents.jsp");
				rd.include(request, response);
				
			} catch (EventException e) {
				request.setAttribute("msg",e.getMessage());
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				rd.include(request, response);
			}
			
			
		}
		
		if(reqURL.equals("/viewbook"))
		{
			System.out.println("in servlet");
			int eventId = Integer.parseInt(request.getParameter("id"));
			System.out.println("event id "+eventId);
			try
			{
				EventsDTO e2=es.getById(eventId);
				session.setAttribute("event1",e2);
				
				System.out.println(e2);
				
				UsersDTO u1=(UsersDTO) session.getAttribute("user");
				System.out.println(u1);
				int bid=es.getBooking(e2, u1);
				session.setAttribute("bookingId",bid );
				
				System.out.println("fhgdsjfs"+bid);
				
				RequestDispatcher rd=request.getRequestDispatcher("Book.jsp");
				rd.include(request, response);
			} 
			catch (EventException e)
			{
				request.setAttribute("msg",e.getMessage());
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				rd.include(request, response);
			}
			
		}
		
		if(reqURL.equals("/home"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("customerHome.jsp");
			rd.include(request, response);
		
		}
		
	}

}
