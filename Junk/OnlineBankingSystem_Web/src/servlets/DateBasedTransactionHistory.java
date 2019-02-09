package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jms.Session;
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
 * Servlet implementation class DateBasedTransactionHistory
 */
@WebServlet("/DateBasedTransactionHistory")
public class DateBasedTransactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateBasedTransactionHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(request.getParameter("StartDate"));
		ArrayList<Transaction> transactions=null;
		try {
			Date Startdate=formatter.parse(request.getParameter("StartDate"));
			Date Enddate=formatter.parse(request.getParameter("EndDate"));
			System.out.println(Startdate);
			System.out.println(Enddate);
			new GregorianCalendar(Startdate.getYear(), Startdate.getDay(), Startdate.getMinutes());
			transactions=OBS.GenerateStatement(Long.parseLong((String) session.getAttribute("ActNum")),Startdate,Enddate);
			session.setAttribute("transactions", transactions);
			RequestDispatcher dispatch=request.getRequestDispatcher("TransactionsDisplay.jsp");
			dispatch.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	}

}
