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

import com.cg.bid.dto.BiddingDto;
import com.cg.bid.service.BiddingService;

/**
 * Servlet implementation class confirmbid
 */
@WebServlet("/confirmbid")
public class confirmbid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmbid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		BiddingService bs=new BiddingService();
		HttpSession session=request.getSession(false);
		String user=(String) session.getAttribute("uname");
		float totalprice=0;
		out.write("<h2>Welcome..."+user+"</h2>");
		out.print("<html><head></head><body><table border='4'>");
		out.print("<tr><td>itemid</td><td>itemname</td><td>itemprice</td>");
		ArrayList<BiddingDto> bidlist=(ArrayList<BiddingDto>) session.getAttribute("bidlist");
		Iterator itr=bidlist.iterator();
		while(itr.hasNext())
		{
			BiddingDto bdto1=(BiddingDto) itr.next();
			if(bs.updateStatus(bdto1.getItemId()));
			{
				totalprice+=bdto1.getItemPrice();
				out.write("<tr>");
				out.write("<td>"+bdto1.getItemId()+"</td>");
				out.write("<td>"+bdto1.getItemName()+"</td>");
				out.write("<td>"+bdto1.getItemPrice()+"</td>");
				out.write("</tr>");
				
			}
		}
				out.write("</table>");
				out.write("<h3 align='center'>Final bill is...."+totalprice+"</h3>");
				out.write("<h3 align='center'>Thank you for bidding with us</h3>");
				out.write("<br><br>");
				
				out.write("<a href='Login.html'>Logout</a>");
				out.write("</body></html>");
				
				session.invalidate();
			}
	}
