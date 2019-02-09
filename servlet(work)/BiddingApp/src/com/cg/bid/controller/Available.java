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
 * Servlet implementation class Available
 */
@WebServlet("/Available")
public class Available extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Available() {
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
		int itemid=Integer.parseInt(request.getParameter("id"));
		BiddingDto bdto=bs.viewById(itemid);
		if(session.getAttribute("bidlist")==null)
		{
			ArrayList<BiddingDto> bidlist=new ArrayList<BiddingDto>();
			bidlist.add(bdto);
			session.setAttribute("bidlist", bidlist);	
		}
		else
		{
			ArrayList<BiddingDto> bidlist=(ArrayList<BiddingDto>) session.getAttribute("bidlist");
			Iterator itr=bidlist.iterator();
			boolean duplicate=false;
			while(itr.hasNext())
			{
				BiddingDto bdto1=(BiddingDto) itr.next();
				if(bdto1.getItemId()==itemid)
				{
					duplicate=true;
				}
			}
			if(duplicate==false)
			{
				bidlist.add(bdto);
			}
			session.setAttribute("bidlist",bidlist);
		}
		response.setContentType("text/html");
		out.write("<h2>Welcome..."+user+"</h2>");
		out.print("<html><head></head><body><table border='4'>");
		out.print("<tr><td>itemid</td><td>itemname</td><td>itemprice</td><td>itemstatus</td><td>Remove</td>");
		
		for(BiddingDto bdto1:(ArrayList<BiddingDto>)session.getAttribute("bidlist") )
		{
			String string=response.encodeURL("RemoveServlet?id="+bdto1.getItemId());
			out.write("<tr>");
			out.write("<td>"+bdto1.getItemId()+"</td>");
			out.write("<td>"+bdto1.getItemName()+"</td>");
			out.write("<td>"+bdto1.getItemPrice()+"</td>");
			out.write("<td>"+bdto1.getStatus()+"</td>");
			out.write("<td><a href ='"+string+"'>remove from bidding cart</a></td>");
			out.write("</tr>");
		}
		out.write("</table>");
		out.write("<form action='confirmbid' method='post'>" );
		out.print("<input type='submit' name='confirmbidding' value='conformbidding'/>");
		out.write("</form>");
		out.print("<a href='ViewServlet'>go back to original bidding item list</a>");
		out.print("</body></html>");
	}

}
