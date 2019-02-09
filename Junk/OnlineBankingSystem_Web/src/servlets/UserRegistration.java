package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service_EJB.OnlineBankingSystem;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystem OBS= new OnlineBankingSystem();
		if(OBS.ViewUserInfo(Long.parseLong(request.getParameter("userId"))) == null)
		{
		if(OBS.addNewUserRegistration( request.getParameter("accountType"), request.getParameter("address"), request.getParameter("customerName"), request.getParameter("email"),"N", request.getParameter("loginPassword"), Long.parseLong(request.getParameter("mobileNumber")), request.getParameter("panCard"), request.getParameter("secretAnswer"), request.getParameter("secretQuestion"), request.getParameter("transactionPassword"),Long.parseLong(request.getParameter("userId"))) == true)
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
		else
		{
			System.out.println(" User Id Already Exists");
			  RequestDispatcher dispatch=request.getRequestDispatcher("TransactionFailed.jsp");
				dispatch.forward(request, response);
		}
	}

}
