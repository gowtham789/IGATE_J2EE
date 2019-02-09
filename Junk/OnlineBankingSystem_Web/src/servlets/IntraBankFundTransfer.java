package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service_EJB.OnlineBankingSystem;
import service_EJB.OnlineBankingSystemInterface;

/**
 * Servlet implementation class IntraBankFundTransfer
 */
@WebServlet("/IntraBankFundTransfer")
public class IntraBankFundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IntraBankFundTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();
		System.out.println(request.getParameter("PayeeActNum"));
		if(request.getParameter("PayeeActNum") == null)
		{
		session.setAttribute("AccountNumber", request.getParameter("ActNum"));
		RequestDispatcher dispatch=request.getRequestDispatcher("IntraBankFundTransfer.jsp");
		dispatch.forward(request, response);
		}
		else
		{
		  if(OBS.accountDebit(Float.parseFloat(request.getParameter("Amount")), Long.parseLong((String) session.getAttribute("AccountNumber")), Long.parseLong(request.getParameter("PayeeActNum"))) == true
				 && OBS.accountCredit(Float.parseFloat(request.getParameter("Amount")), Long.parseLong(request.getParameter("PayeeActNum")), Long.parseLong((String) session.getAttribute("AccountNumber")))
				  )
		  {
			  RequestDispatcher dispatch=request.getRequestDispatcher("TransactionSucess.jsp");
				dispatch.forward(request, response);
		  }
		  else
		  {
			  System.out.println("Error in Transaction");
			  RequestDispatcher dispatch=request.getRequestDispatcher("TransactionFailed.jsp");
				dispatch.forward(request, response);
		  }
		}
	}

}
