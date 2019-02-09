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
 * Servlet implementation class AddService
 */
@WebServlet("/AddService")
public class AddService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddService() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();
		System.out.println(request.getParameter("ServiceDesc"));
		if(request.getParameter("ServiceDesc") == null)
		{
		session.setAttribute("AccountNumber", request.getParameter("ActNum"));
		RequestDispatcher dispatch=request.getRequestDispatcher("AddService.jsp");
		dispatch.forward(request, response);
		}
		else
		{
		  if(OBS.RaiseServiceRequest(Long.parseLong((String) session.getAttribute("AccountNumber")), request.getParameter("ServiceDesc"), "OPEN"))
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
