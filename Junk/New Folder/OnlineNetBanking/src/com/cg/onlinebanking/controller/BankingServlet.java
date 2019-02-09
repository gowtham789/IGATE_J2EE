package com.cg.onlinebanking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.exception.OnlineException;
import com.cg.onlinebanking.service.BankService;
import com.cg.onlinebanking.service.IOnlineBank;


@WebServlet(name = "BankingServlet", urlPatterns = {"/CurrAddr","/success","/UpdateAddress","/UpdateAddr","/UpdateMob","/UpdateMobileNum"})

public class BankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankingServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		IOnlineBank os = new BankService();
		HttpSession session = request.getSession(true);
			    
		CustomerDTO cd = new CustomerDTO();

		
		// Check the type of Request
		String reqURL = request.getServletPath();
		
		if (reqURL.equals("/CurrAddr"))
		{
			Long id = (Long.parseLong(request.getParameter("account")));
			
			try 
			{
			
			cd = os.getCustomerById(id);
		
			session.setAttribute("acc",cd);
			RequestDispatcher rd = request.getRequestDispatcher("CurrentAddr.jsp");
			rd.forward(request,response);
			
			}
			
			catch (OnlineException e) 
			{
			
			String msg = e.getMessage();
			request.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request,response);

			
			}
		
		}
		
		if (reqURL.equals("/UpdateAddr"))
		{
			
			long aid =Long.parseLong(request.getParameter("id"));
		
			session.setAttribute("updateid", aid);
			response.sendRedirect("ChangeAddr.jsp");
		}
	
				
		if (reqURL.equals("/UpdateAddress"))
				
		{
		
			Long aid=(Long) session.getAttribute("updateid");
				
			String naddr = request.getParameter("newaddr");
			cd.setAddress(naddr);
				
				try
				{
					int count = os.changeCustomerAddress(aid,naddr);
					if(count>0)
					{
						response.sendRedirect("success.jsp");
					}
					else
					{
						response.sendRedirect("ChangeMob.jsp");
					}
					
				}
				catch(OnlineException e)
				{
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					response.sendRedirect("error.jsp");
	
				}
			}
		
		if (reqURL.equals("/UpdateMob"))
		{
			long aid =Long.parseLong(request.getParameter("id"));
			//System.out.println(mid);
			session.setAttribute("updateid", aid);
			response.sendRedirect("ChangeMob.jsp");
		}
	
				
		if (reqURL.equals("/UpdateMobileNum"))
				
		{
		
			Long aid=(Long) session.getAttribute("updateid");
				
			String mbo = request.getParameter("newMobNum");
			cd.setMobilenumber(mbo);
				
				try
				{
					int count = os.changeCustomerMobile(aid,mbo);
					if(count>0)
					{
						response.sendRedirect("success.jsp");
					}
					else
					{
						response.sendRedirect("ChangeAddr.jsp");
					}
					
				}
				catch(OnlineException e)
				{
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					response.sendRedirect("error.jsp");
	
				}
			}


	}

}

