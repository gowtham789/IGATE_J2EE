package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PersonalInfoRequest
 */
@WebServlet("/PersonalInfoRequest")
public class PersonalInfoRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PersonalInfoRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("accountID", request.getParameter("ActNum"));
		RequestDispatcher dispatch=request.getRequestDispatcher("PersonalInfoDisplay.jsp");
		dispatch.forward(request, response);
	}

}
