package com.igate.munipal.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.munipal.dto.FirmMaster;
import com.igate.munipal.exception.FirmException;
import com.igate.munipal.service.RegisterImplService;
import com.igate.munipal.service.RegisterService;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config;
	RegisterService service = new RegisterImplService();

	public RegisterController() {
		super();
		System.out.println("Municipal Controller constructor");
	}

	// ***********************init method***********************
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Municipal Controller init function");
	}

	// ***********************destroy method***********************
	public void destroy() {
		System.out.println("Municipal Controller Destroy....");
	}

	// ***********************doGet method***********************
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Here");
		doPost(request, response);
	}

	// ***********************doPost method***********************
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		if (action != null) {
			// ***********************Redirect To home
			// page***********************
			if (action.equals("RedirectToHome")) {
				System.out.println("Here man");
				RequestDispatcher req = request
						.getRequestDispatcher("/Pages/home.jsp");
				req.forward(request, response);
			}
			if (action.equals("DisplayRegistrationForm")) {
				System.out.println("H");
				RequestDispatcher req = request
						.getRequestDispatcher("/Pages/register.jsp");
				req.forward(request, response);
			}
			// ***********************Fetching user details from registration
			// form***********************
			if (action.equals("Register")) {
				FirmMaster firmObj = new FirmMaster();
				firmObj.setOwnerName(request.getParameter("fName") + " "
						+ request.getParameter("mName") + " "
						+ request.getParameter("lName"));
				firmObj.setBusinessName(request.getParameter("bName"));
				firmObj.seteMail(request.getParameter("emailId"));
				firmObj.setMobileNo(request.getParameter("mobileNo"));
				firmObj.setIsActive("N");
				try {
					int result = service.InsertData(firmObj);
					if (result > 0) {
						Random randomNo = new Random();
						int actCode = randomNo.nextInt(10000) * 100;
						HttpSession session = request.getSession();
						session.setAttribute("actcode", actCode);
						session.setAttribute("mail",
								request.getParameter("emailId"));
						RequestDispatcher req = request
								.getRequestDispatcher("/Pages/activated.jsp");
						req.forward(request, response);
					}
				} catch (FirmException e) {
					// TODO Auto-generated catch block
					request.setAttribute("exception",
							"Data is not inserted into DB" + e.getMessage());
					RequestDispatcher req = request
							.getRequestDispatcher("/Pages/errorpage.jsp");
					req.forward(request, response);
				}
			}
			// ***********************To display index.jsp
			// Page***********************
			if (action.equals("ShowHomePage")) {
				RequestDispatcher req = request
						.getRequestDispatcher("/index.jsp");
				req.forward(request, response);
			}
			// ***********************To display acivate.jsp
			// Page***********************
			if (action.equals("DisplayActivationForm")) {
				RequestDispatcher req = request
						.getRequestDispatcher("/Pages/activate.jsp");
				req.forward(request, response);
			}
			// ***********************To activate the
			// account***********************
			if (action.equals("Activate")) {
				FirmMaster master = new FirmMaster();
				String email = request.getParameter("mailId");
				String actcode = request.getParameter("actcode");
				HttpSession session2 = request.getSession(false);
				String mymail = (String) session2.getAttribute("mail");
				Integer actcodeSession = (Integer) session2
						.getAttribute("actcode");
				try {

					if (Integer.parseInt(actcode) == actcodeSession
							&& email.equals(mymail)) {
						master.seteMail(email);
						master.setIsActive("Y");
						try {
							int row = service.activateData(master);
							if (row > 0) {
								RequestDispatcher req = request
										.getRequestDispatcher("/Pages/success.jsp");
								req.forward(request, response);
							}
						} catch (FirmException e) {

							e.printStackTrace();
						}
					} else { // ***********************To raise
								// error***********************
						String error = "Please Enter valid mail-Id and activation code";
						request.setAttribute("exception", error);
						RequestDispatcher req = request
								.getRequestDispatcher("/Pages/errorpage.jsp");
						req.forward(request, response);
					}
				} catch (Exception e) {
					String error = "Please Enter valid mail-Id and activation code"
							+ e.getMessage();
					request.setAttribute("exception", error);
					RequestDispatcher req = request
							.getRequestDispatcher("/Pages/errorpage.jsp");
					req.forward(request, response);
				}
			}

		} else {
			String error = "No action is defined";
			request.setAttribute("exception", error);
			RequestDispatcher req = request
					.getRequestDispatcher("/Pages/errorpage.jsp");
			req.forward(request, response);

		}
	}
}
