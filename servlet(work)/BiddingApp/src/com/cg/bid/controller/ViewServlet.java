package com.cg.bid.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bid.dto.BiddingDto;
import com.cg.bid.service.BiddingService;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
		
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			BiddingService bs=new BiddingService();
			ArrayList<BiddingDto> itemList = bs.getItems();
			HttpSession session=request.getSession(false);
			String user=(String) session.getAttribute("uname");
			out.write("<h2>Welcome..."+user+"</h2>");
			out.print("<html><head></head><body><table border='4'>");
			out.print("<tr><td>itemid</td><td>itemname</td><td>itemprice</td><td>itemstatus</td>");
		
			//Display the contents
			
			for(BiddingDto bdto:itemList)
			{
				//System.out.println("hi");
				String string=response.encodeURL("Available?id="+bdto.getItemId());
				out.write("<tr>");
				out.write("<td>"+bdto.getItemId()+"</td>");
				out.write("<td>"+bdto.getItemName()+"</td>");
				out.write("<td>"+bdto.getItemPrice()+"</td>");
				if(bdto.getStatus().equals("available"))
				{
					out.write("<td><a href =\""+ string +"\">"+bdto.getStatus()+"</a></td>");
				}
				else
				{
					out.write("<td>"+bdto.getStatus()+"</td>");
				}
				out.write("</tr>");
			}
			out.write("</table></body></HTML>");

		} // End of View Request
	}


