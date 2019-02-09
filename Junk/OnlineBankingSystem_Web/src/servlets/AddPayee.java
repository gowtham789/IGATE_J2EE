package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service_EJB.OnlineBankingSystem;
import service_EJB.OnlineBankingSystemInterface;

/**
 * Servlet implementation class AddPayee
 */
@WebServlet("/AddPayee")
public class AddPayee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddPayee() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		if(OBS.addPayee(Long.parseLong(request.getParameter("ActNum")), request.getParameter("NickName"), Long.parseLong(request.getParameter("PayeeAccountID"))))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("PayeeAddSucess.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("AddPayee.jsp");
			dispatch.forward(request, response);	
		}
	}

}
