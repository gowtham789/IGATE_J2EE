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
 * Servlet implementation class PasswordReset
 */
@WebServlet("/PasswordReset")
public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PasswordReset() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();
		if(session.getAttribute("SecretAnswer").equals(request.getParameter("Answer")))
		{
			OBS.ForgotPassword(Long.parseLong((String) session.getAttribute("UserID")), (String) session.getAttribute("SecretQuestion"), (String) session.getAttribute("SecretAnswer"));					
			session=request.getSession();
			session.setAttribute("ResetStatus", "sbq500#");
			RequestDispatcher dispatch=request.getRequestDispatcher("forgotpwd_2.jsp");
			dispatch.forward(request, response);
		}
	}

}
