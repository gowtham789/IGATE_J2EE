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
 * Servlet implementation class ManagePayee
 */
@WebServlet("/ManageRegistrations")
public class ManageRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageRegistrations() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();
		
		if(request.getParameter("submit") == null)
		{
		session.setAttribute("UserRequestId", request.getParameter("UserId"));
		RequestDispatcher dispatch=request.getRequestDispatcher("ViewAllRegistrations.jsp");
		dispatch.forward(request, response);
		}
		else
		{
		  OBS.ConfirmUser(Long.parseLong(request.getParameter("confirm")));
		  RequestDispatcher dispatch=request.getRequestDispatcher("PayeeConfirmSucess.jsp");
			dispatch.forward(request, response);
		}
	}

}
