package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto_JPA.Transaction;
import service_EJB.OnlineBankingSystem;
import service_EJB.OnlineBankingSystemInterface;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransactionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("ActNum"));
		System.out.println(request.getParameter("ActAction"));
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
		HttpSession session=request.getSession();
		if (!request.getParameter("ActNum").equalsIgnoreCase(
				"Select Account number")) {
			if (request.getParameter("ActAction").equalsIgnoreCase(
					"Last 10 Transactions")) 
			{
				transactions=OBS.GenerateStatement(Long.parseLong(request.getParameter("ActNum")), 10);
				System.out.println(transactions);
				session.setAttribute("transactions", transactions);
				RequestDispatcher dispatch=request.getRequestDispatcher("TransactionsDisplay.jsp");
				dispatch.forward(request, response);
				
			} else if (request.getParameter("ActAction").equalsIgnoreCase(
					"All Transactions"))
			{
				transactions=OBS.GenerateStatement(Long.parseLong(request.getParameter("ActNum")));
				System.out.println(transactions);
				session.setAttribute("transactions",transactions);
				RequestDispatcher dispatch=request.getRequestDispatcher("TransactionsDisplay.jsp");
				dispatch.forward(request, response);
				
			} else if (request.getParameter("ActAction").equalsIgnoreCase(
					"Transaction between time period")) 
			{
				session.setAttribute("ActNum",request.getParameter("ActNum"));
				RequestDispatcher dispatch=request.getRequestDispatcher("TransactionHistory_Date.jsp");
				dispatch.forward(request, response);
				
			} else 
			{
				System.out.println("No Option selected");
			}
		}
		else
		{
			System.out.println("Select a valid Account number");
		}
	}

}
