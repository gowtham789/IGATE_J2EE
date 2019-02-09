package com.cg.bid.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.cg.bid.dto.BidDTO;
import com.cg.bid.service.LoginService;


@WebServlet("/Bidcart")
public class Bidcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Bidcart() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession(false);
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		response.setContentType("text/html");  
		
		PrintWriter out = response.getWriter();
		
		LoginService service=new LoginService();
		
		BidDTO item=service.getBidbyItemid(id);
		
		
		
		if(session.getAttribute("bidlist")==null)
		{
			ArrayList<BidDTO> bidlist=new ArrayList<BidDTO>();
			bidlist.add(item);
			session.setAttribute("bidlist", bidlist);
		}
		
		else
		{
			ArrayList<BidDTO> bidlist=(ArrayList<BidDTO>) session.getAttribute("bidlist");
			Iterator itr=bidlist.iterator();
			boolean duplicate=false;
			while(itr.hasNext())
			{
				BidDTO i=(BidDTO) itr.next();
				if(i.getItemid()==id)
				{
					duplicate=true;
				}
			}
			if(duplicate==false)
			{
				bidlist.add(item);
			}
			session.setAttribute("bidlist",bidlist);
		}
		
		
		
		out.write("<HTML><HEAD></HEAD><BODY >");  
	    out.write("<h2>Welcome......"+session.getAttribute("username")+"</h2>");
	    out.write("<table border='2'  align='center'>");
		out.write("<tr><th>Item Id</th><th>Item Name</th><th>Item Price</th><th>Item Status</th><th>Remove</th></tr>");
		
		for(BidDTO data:(ArrayList<BidDTO>) session.getAttribute("bidlist"))
		{
			
		String url = response.encodeURL("Removebid?id="+data.getItemid());
		out.write("<tr><td>"+data.getItemid()+"</td>");
		out.write("<td>"+data.getItemname()+"</td>");
		out.write("<td>"+data.getItemprice()+"</td>");
		out.write("<td>"+data.getStatus()+"</td>");
		out.write("<td><a href="+url+">Remove from Bidding Cart</a></td></tr>");
		}
		out.write("</table>");
		out.write("<form action='Confirmbid' method='post'>");
		out.write("</br>");
		out.write("<input type='submit' value='Confirm Bidding'/>");
		out.write("</form>");
		out.write("<a href='DisplayServlet'>Go Back to Original Bidding Items List</a>");
		out.write("</BODY></HTML>");
		
		
	}
	}


