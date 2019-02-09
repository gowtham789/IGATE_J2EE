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


@WebServlet("/Confirmbid")
public class Confirmbid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Confirmbid() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		response.setContentType("text/html");  
		LoginService service=new LoginService();
		PrintWriter out = response.getWriter();
		
		float totalprice=0;
		
		out.write("<HTML><HEAD></HEAD><BODY >");  
	    out.write("<h2>Welcome......"+session.getAttribute("username")+"</h2>");
	    out.write("<table border='2' align='center'>");
		out.write("<tr><th>Item Id</th><th>Item Name</th><th>Item Price</th></tr>");
		
		ArrayList<BidDTO> list=(ArrayList<BidDTO>) session.getAttribute("bidlist");
		Iterator itr=list.iterator();
		
		for(BidDTO data:(ArrayList<BidDTO>) session.getAttribute("bidlist"))
		{
			
		out.write("<tr><td>"+data.getItemid()+"</td>");
		out.write("<td>"+data.getItemname()+"</td>");
		out.write("<td>"+data.getItemprice()+"</td>");
		out.write("</tr>");
		}
		
		
	
		while(itr.hasNext())
		{
			
		BidDTO item=(BidDTO) itr.next();
		service.updateStatus(item.getItemid());
		int id=item.getItemid();
		
		totalprice+=item.getItemprice();
		
		
		
		}
		
		
		out.write("</table>");
		out.write("<h3 align='center'>Final Bill is------"+totalprice+"</h3>");
		out.write("<h3 align='center'>Thank you for bidding with us.</h3>");
		
		out.write("</br></br>");
		out.write("<a href='Login.html'>Logout</a>");
		out.write("</BODY></HTML>");
		session.invalidate();
	

}
}
