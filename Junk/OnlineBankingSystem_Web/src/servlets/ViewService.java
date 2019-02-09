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
 * Servlet implementation class ViewService
 */
@WebServlet("/ViewService")
public class ViewService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewService() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();	
		session.setAttribute("AccountNumber", request.getParameter("ActNum"));
		RequestDispatcher dispatch=request.getRequestDispatcher("ViewService.jsp");
		dispatch.forward(request, response);
	
	}

}
