package com.cg.onlinebanking.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Tab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.PayeeDTO;
import com.cg.onlinebanking.dto.ServiceTrackerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.dto.UserDTO;
import com.cg.onlinebanking.exception.OnlineException;
import com.cg.onlinebanking.service.BankService;
import com.cg.onlinebanking.service.IOnlineBank;


@WebServlet(name="OnlineUserController",urlPatterns={"/Loginserv","/Logout","/getbal","/Home",
		"/fundtrans","/MakeTransfer","/AddPayee", "/details", "/displayservice","/home","/servreq","/insertservreq",
		"/CurrAddr","/UpdateAddress","/UpdateAddr","/UpdateMob","/UpdateMobileNum"
		,"/getMyPayees","/Addedpayee","/fundtransfer","/cheqreq","/track"
		,"/valpayee","/valdfun","/firstpage","/changeaddr","/ministat",
		"/chnpss","/ChangePass","/oldTran","/ViewPrevTran","/ViewOldTran"
		,"/Aboutus","/Service","/Contactus","/HelP","/leftpage","/headerpage",
		"/bottomepage","/rightpage","/LoginRequest","/forgot","/getforgotid","/checkques","/checkPass"})

public class OnlineUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public OnlineUserController() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
			// Check the type of Request
		
			String reqURL = request.getServletPath();
			
			HttpSession session=request.getSession(true);
			
			IOnlineBank iserv=new BankService();
			
			CustomerDTO cd = new CustomerDTO();
						
			if(reqURL.equals("/Loginserv"))
			{
				String user=request.getParameter("UserName");
				String pwd=request.getParameter("Pass");
				session.setAttribute("user", user);
				session.setAttribute("pwd", pwd);
				//session.setMaxInactiveInterval(5);
				
				try 
				{
					boolean valid=iserv.isValidAdmin(user, pwd);
					if(valid)
					{
						
						RequestDispatcher rd=request.getRequestDispatcher("/AdminPage");
						rd.forward(request, response);
					}
					else
					{
						boolean validuser=iserv.isValiduser(user, pwd);
						String status=iserv.checkStatus(user);
						if(validuser)
						{
						if(status.equals("U")||status.equals("u"))
						{
						ArrayList<Long> accids=iserv.getAcctid(user);
 						session.setAttribute("acctid", accids);
 						
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Home.jsp");
						rd.forward(request, response);
						}
						else
						{	
							request.setAttribute("lock","1");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/LoginPage.jsp");
							rd.forward(request, response);
						}
						}
						else
						{
						session.setAttribute("invalidmsg","Invalid User..........Enter valid user and password!!!!!!!!!");
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/InvalidUser.jsp");
						rd.forward(request, response);
						}
					}
				} 
				catch (OnlineException e) 
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				}
			}
			
			if(reqURL.equals("/Home"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Home.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/leftpage"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Left.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/headerpage"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Header.jsp");
				rd.forward(request, response);
			}
			
			
			if(reqURL.equals("/rightpage"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/UserWelcomePage.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/bottomepage"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Footer.jsp");
				rd.forward(request, response);
			}
			
			
			
			if(reqURL.equals("/firstpage"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Acctsummary.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/changeaddr"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/CurrentAddr.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/ministat"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/MiniStatement.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/cheqreq"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/servreq.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/fundtransfer"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Fundtransfer.jsp");
				rd.forward(request, response);
			}
			
			
			if(reqURL.equals("/track"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/tracserv.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/chnpss"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ChangePass.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/Logout"))
			{
				
				session.invalidate();
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/LoginPage.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/LoginRequest"))
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/LoginPage.jsp");
				rd.forward(request, response);
			}
			
			if(reqURL.equals("/getbal"))
			{
				String aid=request.getParameter("Accountid");
				session.setAttribute("selecid", aid);
				long id=Long.parseLong(aid);
				try
				{
					double bal=iserv.getBal(id);
					session.setAttribute("bal",bal);
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Balance.jsp");
					rd.forward(request, response);
				} 
				catch (OnlineException e) 
				{
					
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
					
				}
			}
			
			
			if(reqURL.equals("/details"))
			{
				try 
				{
					List<AccountDTO> elist=iserv.getAllAccounts();
					session.setAttribute("serList", elist);
					RequestDispatcher rd=request.getRequestDispatcher("/Webpages/tracserv.jsp");
					rd.forward(request, response);
				} 
				catch (OnlineException e) 
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				}
			}
			
			
			if(reqURL.equals("/displayservice"))
			{
				String acc=request.getParameter("Accountid");
				Long accId=Long.parseLong(acc);
				session.setAttribute("trakid", accId);
				try 
				{
					List<ServiceTrackerDTO> elist=iserv.getServiceById(accId);
					System.out.println();
					session.setAttribute("servdetails", elist);
					RequestDispatcher rd=request.getRequestDispatcher("/Webpages/servicestat.jsp");
					rd.include(request, response);
				} 
				catch (OnlineException e) 
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/Webpages/error.jsp");
					rd.include(request, response);
				}
				
				
			}
			
			
			if(reqURL.equals("/servreq"))
			{
				ArrayList<AccountDTO> alist;
				try 
				{
					
					alist = iserv.getAllAccounts();
					session.setAttribute("acctid", alist);
					RequestDispatcher rd=request.getRequestDispatcher("/Webpages/servreq.jsp");
					rd.forward(request, response);
					
				} 
				catch (OnlineException e) 
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				}
				
			}
			if(reqURL.equals("/insertservreq"))
			{
				String acc=request.getParameter("Accountid");
				Long accId=Long.parseLong(acc);
				session.setAttribute("accid", accId);
				try 
				{
					if(!iserv.getCheqStatus(accId))
					{
					int servId=iserv.insertRequest(accId);
					request.setAttribute("Cheqreq","0");
					session.setAttribute("serv", servId);
					RequestDispatcher rd=request.getRequestDispatcher("/Webpages/showRequest.jsp");
					rd.forward(request, response);
					}
					else
					{
						request.setAttribute("Cheqreq","1");
						RequestDispatcher rd=request.getRequestDispatcher("/Webpages/showRequest.jsp");
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
			
			if (reqURL.equals("/CurrAddr"))
			{
				
				Long id = (Long.parseLong(request.getParameter("Accountid")));
				session.setAttribute("addid",id);
				try 
				{
				cd = iserv.getCustomerById(id);
				request.setAttribute("accdto",cd);
				RequestDispatcher rd = request.getRequestDispatcher("/WebPages/CurrentAddr.jsp");
				rd.forward(request,response);
				
				}
				
				catch (OnlineException e) 
				{
				
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				
				}
			
			}
			
			if (reqURL.equals("/UpdateAddr"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/WebPages/ChangeAddr.jsp");
				rd.forward(request,response);
			}
		
					
			if (reqURL.equals("/UpdateAddress"))
					
			{
			
				Long aid=(Long) session.getAttribute("addid");
				String naddr = request.getParameter("newaddr");
				cd.setAddress(naddr);
					
					try
					{
						int count = iserv.changeCustomerAddress(aid,naddr);
						if(count>0)
						{
							cd =iserv.getCustomerById(aid);
							session.setAttribute("cust",cd);
							RequestDispatcher rd = request.getRequestDispatcher("/WebPages/success.jsp");
							rd.forward(request,response);
							
						}
						else
						{
							RequestDispatcher rd = request.getRequestDispatcher("/WebPages/CurrentAddr.jsp");
							rd.forward(request,response);
							
						}
						
					}
					catch(OnlineException e)
					{
						request.setAttribute("exception",e.getMessage());
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
						rd.forward(request, response);
		
					}
				}
			
			if (reqURL.equals("/UpdateMob"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/WebPages/ChangeMob.jsp");
				rd.forward(request,response);
			}
		
					
			if (reqURL.equals("/UpdateMobileNum"))
					
			{
			
				Long aid=(Long) session.getAttribute("addid");
				String mbo = request.getParameter("mbno");
				cd.setMobileNumber(mbo);
					
					try
					{
						int count = iserv.changeCustomerMobile(aid,mbo);
						
						if(count>0)
						{
							cd = iserv.getCustomerById(aid);
							session.setAttribute("cust", cd);
							RequestDispatcher rd = request.getRequestDispatcher("/WebPages/success.jsp");
							rd.forward(request,response);
						}
						else
						{
							response.sendRedirect("/WebPages/ChangeAddr.jsp");
						}
						
					}
					catch(OnlineException e)
					{
						request.setAttribute("exception",e.getMessage());
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
						rd.forward(request, response);
		
					}
				}
			
			
			if(reqURL.equals("/fundtrans"))
			{
				String aid=request.getParameter("fromacct");
				session.setAttribute("fromid", aid);
				long fid=Long.parseLong(aid);
				
				String bid=request.getParameter("toacct");
				session.setAttribute("toid", bid);
				long tid=Long.parseLong(bid);
				
				String trns=request.getParameter("amount");
				session.setAttribute("amt", trns);
				double amt=Double.parseDouble(trns);
				
				
				session.setAttribute("id1",fid);
				session.setAttribute("id2",tid);
				session.setAttribute("amount",amt);
				
				if(fid==tid)
				{
					
					session.setAttribute("fundmsg","Money cannot be transferred to same account");
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/invalfun.jsp");
					rd.forward(request, response);
				}
				else if(amt<=0)
				{
					
					session.setAttribute("fundmsg","Please Enter Valid amount");
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/invalfun.jsp");
					rd.forward(request, response);
				}
				else
				{
					try
					{
						double amount=iserv.getBal(fid);
						if(amount-amt>500)
						{
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Valdfund.jsp");
						rd.forward(request, response);
						}
						else
						{
							request.setAttribute("insuff", "1");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Payee.jsp");
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
			}
			
			
			if(reqURL.equals("/MakeTransfer"))
			{
				session.setAttribute("count","0");
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Payee.jsp");
				rd.forward(request, response);
				
			}
			
			
			if(reqURL.equals("/AddPayee"))
			{
				session.setAttribute("count","1");
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddPayee.jsp");
				rd.forward(request, response);
				
			}
			
			
			if(reqURL.equals("/getMyPayees"))
			{
				String pid=request.getParameter("fromacct");
				session.setAttribute("selectid", pid);
				long fid=Long.parseLong(pid);
				try 
				{
					ArrayList<Long> accids=iserv.getPayeeId(fid);
					request.setAttribute("payid", accids);
					if(accids.size()!=0)
					{
						session.setAttribute("count","1");
						
					}
					else
					{
						session.setAttribute("count","2");
					}
				} 
				catch (OnlineException e)
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				}
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Payee.jsp");
				rd.forward(request, response);
				
			}
			
			
			if(reqURL.equals("/Addedpayee"))
			{
				long aid=Long.parseLong(request.getParameter("fromacct"));
				long pid=Long.parseLong(request.getParameter("payeeid"));
				String pname=request.getParameter("nickname");
				try
				{
				if(aid!=pid)
				{
				boolean valid=iserv.isValidAccount(pid);
				if(valid)
				{
				boolean checkpayee=iserv.checkPayee(aid,pid);
				if(!checkpayee)
				{
				PayeeDTO pdto=new PayeeDTO();
				pdto.setAccountId(aid);
				pdto.setPayeeId(pid);
				pdto.setNickName(pname);
				session.setAttribute("pdto", pdto);
				Random rand=new Random();
				int rnum=rand.nextInt(100)*12;
				session.setAttribute("valpay","1");
				session.setAttribute("URN",rnum);
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddPayee.jsp");
				rd.forward(request, response);
				}
				else
				{
					request.setAttribute("payavail","1");
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddPayee.jsp");
					rd.forward(request, response);
					
				}
				}
				else
				{
					request.setAttribute("paynotavail","1");
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddPayee.jsp");
					rd.forward(request, response);
					
				}
				}
				else
				{
					request.setAttribute("duplicpay","1");
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddPayee.jsp");
					rd.forward(request, response);
				}
				}
				
				catch(OnlineException e)
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				}
			}
			
			
			if(reqURL.equals("/valpayee"))
			{
				int urn1=Integer.parseInt(request.getParameter("urn"));
				int urn2=(int) session.getAttribute("URN");
				if(urn1==urn2)
				{
				PayeeDTO pdto=(PayeeDTO) session.getAttribute("pdto");
				try 
				{
					int payid=iserv.insertPayee(pdto);
					if(payid>0)
					{
						
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Payeeaddsuccs.jsp");
						rd.forward(request, response);
					}
					else
					{
						request.setAttribute("payaddid","1" );
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AddPayee.jsp");
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
			}
			
			
			
			if(reqURL.equals("/valdfun"))
			{
				long fid=(long) session.getAttribute("id1");
				long tid=(long) session.getAttribute("id2");
				double amt=(double) session.getAttribute("amount");
				try 
				{
						boolean validpass=iserv.getTranspass(request.getParameter("tpass"),fid);
						if(validpass)
						{
						int fund=iserv.transferFund(fid, tid, amt);
						if(fund>0)
						{
						TransactionDTO tdto=new TransactionDTO();
						tdto.setAccountId(fid);
						tdto.setTransAmt(amt);
						tdto.setTransType("d");
						iserv.insertTransact(tdto, tid);
						session.setAttribute("funid",fund);
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Succfund.jsp");
						rd.forward(request, response);
						}
						else
						{
							request.setAttribute("exception","Fund not Transferred please try again");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
							rd.forward(request, response);
						}
						}
						else
						{
							request.setAttribute("exception","Entered Wrong Transaction Password try again...");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
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
			
			
			if (reqURL.equals("/ChangePass")) 
			{
				UserDTO ud= new UserDTO();
				// Get details from form and store in Bean - Model
				
			    ud.setLoginPwd(request.getParameter("oldpass"));
									
				String opass=request.getParameter("oldpass");
				session.setAttribute("oldPass",opass);
				
				String npass=request.getParameter("newpass");
				session.setAttribute("newPass",npass);
				
				String rpass=request.getParameter("renewpass");
				try
				{
					 
				
					boolean pass=iserv.isValidPassword(opass);
					if(pass)
					{
						if(npass.equals(rpass))
						{
							boolean check = iserv.updatePassword( opass, npass);
							if(check)
							{
							request.setAttribute("update", "1");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ChangePass.jsp");
							rd.include(request, response);
							}
							else
							{
							request.setAttribute("update", "0");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ChangePass.jsp");
							rd.include(request, response);
							}
							
						}
						else
						{
							request.setAttribute("update", "2");
							RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ChangePass.jsp");
							rd.include(request, response);
						}
					}
					else
					{
						request.setAttribute("update", "3");
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ChangePass.jsp");
						rd.include(request, response);
					}
				}
				 catch ( OnlineException e) 
				{
					
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				}
				
			}//end of change pass
			
			
			if (reqURL.equals("/ViewPrevTran")) 
			{
				try
				{
					
					Long accId=Long.parseLong(request.getParameter("Accountid"));
					session.setAttribute("pid",accId);
					ArrayList<TransactionDTO> list=iserv.getTransaction(accId);
					session.setAttribute("transactions",list);
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ViewPrevTran.jsp");
					rd.forward(request, response);
				}
				catch ( OnlineException e) 
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
				}
			}//end of viewPrevTran
			
			
			if (reqURL.equals("/oldTran")) 
			{
				long mid=Long.parseLong(request.getParameter("Accountid"));
				session.setAttribute("mid", mid);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String sDate=request.getParameter("startDate");
				LocalDate startDate = LocalDate.parse(sDate,formatter);

				String eDate=request.getParameter("endDate");
				LocalDate endDate= LocalDate.parse(eDate,formatter);
				ArrayList<TransactionDTO> list=new ArrayList<TransactionDTO>();
				try
				{
					list=iserv.getTransactionByDate(Date.valueOf(startDate),Date.valueOf(endDate),mid);
					request.setAttribute("trandate", list);
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ViewTranByDate.jsp");
					rd.forward(request, response);
				}
				catch ( OnlineException e) 
				{
					request.setAttribute("exception",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
					rd.forward(request, response);
					
				}
			}//end of oldtrans
			
			
			if (reqURL.equals("/ViewOldTran")) 
			{
			RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ViewOldTran.jsp");
			rd.forward(request, response);
			}//end of viewoldtran
				
			
			if(reqURL.equals("/Aboutus"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/AboutUs.jsp");
				rd.forward(request, response);
			}
			
			
			if(reqURL.equals("/Service"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Services.jsp");
				rd.forward(request, response);
			}
			
			
			if(reqURL.equals("/Contactus"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/ContactUs.jsp");
				rd.forward(request, response);
			}
			
			
			if(reqURL.equals("/HelP"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Help.jsp");
				rd.forward(request, response);
			}
			
			
			if(reqURL.equals("/forgot"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/Webpages/idcheck.jsp");
				rd.include(request, response);
			}
			
			if(reqURL.equals("/getforgotid"))
			{
				String s=request.getParameter("accid");
				session.setAttribute("forgotid", s);
				boolean validId;
				try {
					validId = iserv.isValidAccountUser(Long.parseLong(s));
					
					if(validId)
					{
						ArrayList<String> user=iserv.getAllQuestions();
						session.setAttribute("user", user);
						RequestDispatcher rd=request.getRequestDispatcher("/Webpages/forgot.jsp");
						rd.include(request, response);
					}
					else
					{
						OnlineException e=new OnlineException("Please check your account id");
						request.setAttribute("exception",e);
						RequestDispatcher rd=request.getRequestDispatcher("/WebPages/Errorpage.jsp");
						rd.forward(request, response);
						
					}
				
				
				} 
				catch(OnlineException e) 
				{
					 request.setAttribute("msg",e.getMessage());
					 RequestDispatcher rd=request.getRequestDispatcher("/Webpages/error.jsp");
					 rd.include(request, response);
				}
				
			}
			if(reqURL.equals("/checkques"))
			{
				String question=request.getParameter("ques");
				String answer=request.getParameter("ans");
				try 
				{
					boolean validques=iserv.isValidAnswer(question,answer);
					if(validques)
					{
						RequestDispatcher rd=request.getRequestDispatcher("/Webpages/newpass.jsp");
						rd.include(request, response);
					}
				}
				catch (OnlineException e) {
					 request.setAttribute("msg",e.getMessage());
					 RequestDispatcher rd=request.getRequestDispatcher("/Webpages/error.jsp");
					 rd.include(request, response);
				}
			}
			
			if(reqURL.equals("/checkPass"))
			{
				String fid=(String) session.getAttribute("forgotid");
				long accntId=Long.parseLong(fid);
				String password1=request.getParameter("pass1");
				String password2=request.getParameter("pass2");
				try 
				{
					boolean validId = iserv.isValidAccountUser(accntId);
					if(validId)
					{
						if(password1.equals(password2))
						{
							boolean update=iserv.updateForgotPassword(accntId, password1);
							if(update)
							{
								RequestDispatcher rd=request.getRequestDispatcher("/Webpages/successforgotpass.jsp");
								rd.include(request, response);
							}
						}
					}
					
				} catch (OnlineException e) {
					 request.setAttribute("msg",e.getMessage());
					 RequestDispatcher rd=request.getRequestDispatcher("/Webpages/error.jsp");
					 rd.include(request, response);
				}
				
				
			}
	}

}
