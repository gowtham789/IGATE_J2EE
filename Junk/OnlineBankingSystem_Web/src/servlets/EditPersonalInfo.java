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
 * Servlet implementation class EditPersonalInfo
 */
@WebServlet("/EditPersonalInfo")
public class EditPersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditPersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OnlineBankingSystemInterface OBS= new OnlineBankingSystem();
		if(OBS.UpdateCustomerInfo(request.getParameter("Address"),Long.parseLong(request.getParameter("MobileNumber")), request.getParameter("Email"), Long.parseLong(request.getParameter("accountID"))))
		{
			System.out.println("Update Sucessfull");
			RequestDispatcher dispatch=request.getRequestDispatcher("UpdateSucess.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			System.out.println("Update Failed Try Again");
			RequestDispatcher dispatch=request.getRequestDispatcher("PersonalInfoDisplay.jsp");
			dispatch.forward(request, response);
		}

	}

}
