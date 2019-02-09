package com.cg.onlinebanking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.dto.UserDTO;
import com.cg.onlinebanking.exception.OnlineException;
import com.cg.onlinebanking.service.BankService;
import com.cg.onlinebanking.service.IOnlineBank;


@WebServlet(name="AdminController",urlPatterns={"/AdminPage","/newAccount","/AddCustomer","/getalladmin",
		"/getalltrans","/gettransacs"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
					// Check the type of Request
		
					String reqURL = request.getServletPath();
					
					HttpSession session=request.getSession(true);
					
					IOnlineBank iserv=new BankService();
					
					if(reqURL.equals("/AdminPage"))
					{
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AdminPage.jsp");
						rd.forward(request, response);
					}
					
					
					if(reqURL.equals("/newAccount"))
					{
						try 
						{
							ArrayList<String> ques=iserv.getAllQuestions();
							session.setAttribute("questions", ques);
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddNewAccount.jsp");
							rd.forward(request, response);
						}
						catch (OnlineException e) 
						{
							request.setAttribute("exception",e.getMessage());
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
							rd.forward(request, response);
						}
						
					}
				
					
					
					if(reqURL.equals("/AddCustomer"))
					{
						CustomerDTO cust=new CustomerDTO();
						AccountDTO acc=new AccountDTO();
						UserDTO user=new UserDTO();
						
						cust.setAddress(request.getParameter("address"));
						cust.setCustName(request.getParameter("custName"));
						cust.setEmail(request.getParameter("email"));
						cust.setMobileNumber(request.getParameter("mobileNumber"));
						cust.setPancard(request.getParameter("pancard"));
						
						acc.setAccountBalance(Double.parseDouble(request.getParameter("accountBalance")));
						acc.setAccountType(request.getParameter("accountType"));
						
						user.setUserId(request.getParameter("userId"));
						user.setLockStatus(request.getParameter("lockStatus"));
						user.setLoginPwd( request.getParameter("loginPwd"));
						user.setSecretQuest(request.getParameter("secretQuest"));
						user.setTransactionPwd(request.getParameter("transactionPwd"));
						user.setAnswer(request.getParameter("ans"));
									
						try 
						{
							long addCust=iserv.addNewCustByAdmin(cust, acc, user);
							 if(addCust>0)
							 {
								 request.setAttribute("newid", addCust);
								 RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddCustSuccess.jsp");
									rd.forward(request, response);
							 }
							 else
							 {
								 RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ErrorAddCust.jsp");
									rd.forward(request, response);
							 }
						} 
						catch (OnlineException e) 
						{
							request.setAttribute("exception",e.getMessage());
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
							rd.forward(request, response);
						}
					}
					
					
					if(reqURL.equals("/getalladmin"))
					{
						try
						{
							ArrayList<Long> uids=iserv.getAcctids();
							session.setAttribute("allids",uids);
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Getalltrans.jsp");
							rd.forward(request, response);
						} 
						catch (OnlineException e) 
						{
							request.setAttribute("exception",e.getMessage());
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
							rd.forward(request, response);
							
						}
						
					}
					
					
					if(reqURL.equals("/gettransacs"))
					{
						long id=Long.parseLong(request.getParameter("Accountid"));
						try 
						{
							ArrayList<TransactionDTO> trans=iserv.getTransaction(id);
							request.setAttribute("transids", trans);
							request.setAttribute("tids","0");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Transaactionpage.jsp");
							rd.forward(request, response);
						} 
						catch (OnlineException e) 
						{
							request.setAttribute("exception",e.getMessage());
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
							rd.forward(request, response);
							
						}
					
					}
					
					
					if(reqURL.equals("/getalltrans"))
					{
						try 
						{
							ArrayList<TransactionDTO> trans=iserv.getAllTransactions();
							request.setAttribute("transids", trans);
							request.setAttribute("tids","1");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Transaactionpage.jsp");
							rd.forward(request, response);
						} 
						catch (OnlineException e) 
						{
							request.setAttribute("exception",e.getMessage());
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
							rd.forward(request, response);
							
						}
						
					}
	}

}
