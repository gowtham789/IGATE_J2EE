package com.cg.bid.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bid.dto.BidDTO;
import com.cg.bid.service.LoginService;


@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
   
    public DisplayServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");  
	    
		
		PrintWriter out = response.getWriter();
	     
		HttpSession session = request.getSession(false);
		
		LoginService service=new LoginService();
		
		ArrayList<BidDTO> bids=service.getAllBid();
		
		
	    out.write("<HTML><HEAD></HEAD><BODY >");  
	    out.write("<h2>Welcome......"+session.getAttribute("username")+"</h2>");
	    out.write("<table border='2'  align='center'>");
		out.write("<tr><th>Item Id</th><th>Item Name</th><th>Item Price</th><th>Item Status</th></tr>");
		
		for(BidDTO data:bids)
		{
			String url = response.encodeURL("Bidcart?id="+data.getItemid());
			out.write("<tr><td>"+data.getItemid()+"</td>");
			out.write("<td>"+data.getItemname()+"</td>");
			out.write("<td>"+data.getItemprice()+"</td>");
			
			if(data.getStatus().equals("available"))
			{
			out.write("<td><a href="+url+">"+data.getStatus()+"</a></td>");
			}
			else
			{
				out.write("<td>"+data.getStatus()+"</td>");
				
			session.setAttribute("id",data.getItemid());
		}
		}
		out.write("</tr>");
		
		out.write("</table>");
		
		out.write("</BODY></HTML>");
		
		
		
	}

	

}
