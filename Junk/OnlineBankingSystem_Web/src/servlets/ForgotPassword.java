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

import dto_JPA.Useraccount;
import service_EJB.OnlineBankingSystem;
import service_EJB.OnlineBankingSystemInterface;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();
		ArrayList<Useraccount> users=OBS.ViewUserInfo(Long.parseLong(request.getParameter("userID")));
		boolean ResetStatus=false;
		if(users != null)
		{
		for(Useraccount user:users)
		{
			if(user.getAccountId()==Long.parseLong(request.getParameter("ActNumber")))
			{
				ResetStatus=true;
				break;
			}
		}
		if(ResetStatus==false)
		{
			session.setAttribute("ResetStatus", "Invalid Acccount Number");
			RequestDispatcher dispatch=request.getRequestDispatcher("forgotpwd.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			System.out.println(request.getParameter("userID"));
			session.setAttribute("AccountNumber", request.getParameter("ActNumber"));
			session.setAttribute("UserID", request.getParameter("userID"));
			session.setAttribute("SecretQuestion",users.get(0).getSecretQuestion());
			session.setAttribute("SecretAnswer",users.get(0).getSecretAnswer());
			RequestDispatcher dispatch=request.getRequestDispatcher("forgotpwd_2.jsp");
			dispatch.forward(request, response);
		}
		}
		else
		{
			session.setAttribute("ResetStatus", "Invalid UserID");
			RequestDispatcher dispatch=request.getRequestDispatcher("forgotpwd.jsp");
			dispatch.forward(request, response);
		}
	}


}
