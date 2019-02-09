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
 * Servlet implementation class InterBankFundTransfer
 */
@WebServlet("/InterBankFundTransfer")
public class InterBankFundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterBankFundTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		  if(OBS.accountDebitSameBank(Float.parseFloat(request.getParameter("Amount")),Long.parseLong(request.getParameter("ActNum")), Long.parseLong(request.getParameter("PayeeAccountID"))))
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

