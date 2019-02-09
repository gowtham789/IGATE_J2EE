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

import dto_JPA.Accountmaster;
import dto_JPA.Customer;
import dto_JPA.Payee;
import dto_JPA.Servicetracker;
import dto_JPA.Useraccount;
import service_EJB.OnlineBankingSystem;
import service_EJB.OnlineBankingSystemInterface;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int loginAttempts=0;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Login Servlet here");
		OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
		HttpSession session=request.getSession();
		String loginStatus=OBS.AuthenticateUser(Long.parseLong(request.getParameter("txt_Name")), request.getParameter("txt_password"));
		System.out.println(loginStatus);
		if(loginStatus.equals("Login Successful"))
		{
			if(request.getParameter("txt_Name").equalsIgnoreCase("111"))
			{
				System.out.println("Admin here");
				session.setAttribute("LoginPerson","ADMIN");
				session.setAttribute("AllAccounts", OBS.retrieveAllAccount());
				session.setAttribute("AllRegistrations", OBS.retrieveUserRegistrations());
				
			}
			else
			{
				System.out.println("User Here");
				session.setAttribute("LoginPerson","USER");
			}
			System.out.println("Login Succesfull");			
			session.setAttribute("LoginStatus",loginStatus);
			session.setAttribute("LoginUser",request.getParameter("txt_Name"));
			ArrayList<Useraccount> users =OBS.ViewUserInfo(Long.parseLong(request.getParameter("txt_Name")));
			session.setAttribute("users",users);
			ArrayList<Accountmaster> userAccounts=new ArrayList<Accountmaster>();
			ArrayList<Customer> customerInfo= new ArrayList<Customer>();
			ArrayList<ArrayList<Payee>> payees = new ArrayList<ArrayList<Payee>>();
			ArrayList<ArrayList<Servicetracker>> services= new ArrayList<ArrayList<Servicetracker>>();
			for(Useraccount user:users)
			{
				userAccounts.add(OBS.ViewAccountInfo(user.getAccountId()));
				customerInfo.add(OBS.ViewCustomerInfo(user.getAccountId()));
				
				payees.add(OBS.viewPayee(user.getAccountId()));
				services.add(OBS.viewallRequests(user.getAccountId()));
			}
			session.setAttribute("services", services);
			session.setAttribute("userAccounts",userAccounts);
			session.setAttribute("customerInfo",customerInfo);
			session.setAttribute("payees",payees);
			RequestDispatcher dispatch=request.getRequestDispatcher("index.jsp");
			dispatch.forward(request, response);
		}
		else if (loginStatus.equals("Account Locked"))
		{
		    System.out.println("Accoutn Locked");	
			session.setAttribute("LoginStatus",loginStatus);
			RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
			dispatch.forward(request, response);
		}
		else if (loginStatus.equals("in-correct Password") || loginStatus.equals("in-correct user ID"))
		{
			session.setAttribute("LoginStatus",loginStatus);
			RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
			dispatch.forward(request, response);
		}
	}

}
