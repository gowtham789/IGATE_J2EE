package com.igate.obs.controller;


import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.igate.obs.dto.AccountDTO;
import com.igate.obs.dto.AdminDTO;
import com.igate.obs.dto.CustomerDTO;
import com.igate.obs.dto.PayeeDTO;
import com.igate.obs.dto.ServiceTrackerDTO;
import com.igate.obs.dto.TransactionDTO;
import com.igate.obs.dto.UserDTO;
import com.igate.obs.exception.OnlineException;
import com.igate.obs.service.IOnlineService;

@Controller
public class OnlineBankingSystem 
{
	@Autowired
	IOnlineService OnlineService;
	
	/***********************************************************
	 * Method Name: loginpage
	 * Return type:String
	 * Parameters:Object of type Model,parameters form jsp page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="loginpage")
	public String loginpage(@RequestParam("role") String role,Model model)
	{
		if(role.equals("admin"))
		{
			AdminDTO adto=new AdminDTO();
			model.addAttribute("adto",adto);
			return "AdminLogin";
		}
		else
		{
			UserDTO udto=new UserDTO();
			model.addAttribute("udto",udto);
			return "Login";
		}
	}
	
	/***********************************************************
	 * Method Name: loginreq
	 * Return type:String
	 * Parameters:None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="LoginRequest")
	public String loginreq()
	{
		return "LoginPage";
	}
	
	/***********************************************************
	 * Method Name: logout
	 * Return type:String
	 * Parameters:Object of type HttpSession
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "LoginPage";
	}
	
	/***********************************************************
	 * Method Name: services
	 * Return type:String
	 * Parameters:None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Services")
	public String services()
	{
		return "Services";
	}
	
	/***********************************************************
	 * Method Name: help
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Help")
	public String help()
	{
		return "Help";
	}
	
	/***********************************************************
	 * Method Name: aboutus
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Aboutus")
	public String aboutus()
	{
		return "AboutUs";
	}
	
	/***********************************************************
	 * Method Name: contactus
	 * Return type:String
	 * Parameters:None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Contactus")
	public String contactus()
	{
		return "ContactUs";
	}
	
	/***********************************************************
	 * Method Name: home
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Home")
	public String home()
	{
		return "UserWelcomePage";
	}
	
	/***********************************************************
	 * Method Name: adminlogin
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,AdminDTO from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 * @throws SQLException 
	 ***********************************************************/
	
	@RequestMapping(value="AdminLogin")
	public String adminlogin(@ModelAttribute("adto") AdminDTO adto,Model model,HttpSession session) 
	{
		String user=adto.getAdId();
		String pwd=adto.getAdPwd();
		session.setAttribute("user",user);
		boolean valid;
		try 
		{
			valid = OnlineService.isValidAdmin(user, pwd);
			if(valid)
			{
				return "Admin";
			}
			else
			{
				model.addAttribute("admin","1");
				return "AdminLogin";
			}
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","1");
			return "AdminLogin";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
		
		
	}
	
	/***********************************************************
	 * Method Name: userlogin
	 * Return type:String
	 * Parameters: Object of type Model,HttpSession,UserDTO from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="UserLogin")
	public String userlogin(@ModelAttribute("udto")@Valid UserDTO udto,BindingResult result,Model model,HttpSession session)
	{
		String user=udto.getUserId();
		String pwd=udto.getLoginPwd();
		session.setAttribute("user", user);
		ArrayList<Long> ids;
		boolean valid;
		try 
		{	
			valid = OnlineService.isValiduser(user, pwd);
			if(valid)
			{
				String status=OnlineService.checkStatus(user);
				if(status.equals("U")||status.equals("u"))
				{
					ids = OnlineService.getAllAcctids(user);
					session.setAttribute("acctid", ids);
					return "UserHome";
				}
				else
				{
					model.addAttribute("statusfail","1");
					return "Login";
				}
			}
			else
			{
				model.addAttribute("user","1");
				return "Login";
			}
			
			
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","1");
			return "Login";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: header
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="headerpage")
	public String header()
	{
		return "Header";
	}
	
	/***********************************************************
	 * Method Name: left
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="leftpage")
	public String left()
	{
		return "Left";
	}
	
	/***********************************************************
	 * Method Name: right
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="rightpage")
	public String right()
	{
		return "UserWelcomePage";
	}
	
	/***********************************************************
	 * Method Name: bottom
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="bottomepage")
	public String bottom()
	{
		return "Footer";
	}
	
	/***********************************************************
	 * Method Name: first
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="firstpage")
	public String first()
	{
		
		return "Acctsummary";
	}
	
	/***********************************************************
	 * Method Name: getbalance
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameter from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="getbal")
	public String getbalance(@RequestParam("accountId") long id,Model model,HttpSession session)
	{
		double bal;
		try 
		{
			bal = OnlineService.getBal(id);
			session.setAttribute("bal",bal);
			session.setAttribute("selecid", id);
			return "Balance";
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: getcurraddr
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="changeaddr")
	public String getcurraddr(Model model)
	{
		model.addAttribute("addr","1");
		return "CurrentAddr";
	}
	
	/***********************************************************
	 * Method Name: getaddr
	 * Return type:String
	 * Parameters: Object of type Model,HttpSession,Parameter from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="CurrAddr")
	public String getaddr(@RequestParam("accountId") long id,Model model,HttpSession session)
	{
		try 
		{
			CustomerDTO cdto=OnlineService.getCustomerById(id);
			session.setAttribute("accdto",cdto);
			session.setAttribute("addid", id);
			model.addAttribute("dto","1");
			return "CurrentAddr";
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: updatecurraddr
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="UpdateAddr")
	public String updatecurraddr(Model model)
	{
		return "ChangeAddr";
	}
	
	/***********************************************************
	 * Method Name: updatecurrmob
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="UpdateMob")
	public String updatecurrmob(Model model)
	{
		return "ChangeMob";
	}
	
	/***********************************************************
	 * Method Name: updatemobile
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,parameter mbno from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="UpdateMobileNum.obj")
	public String updatemobile(@RequestParam("mbno")String mobno,Model model,HttpSession session)
	{
		Long aid=(Long) session.getAttribute("addid");
		try
		{
			int count=OnlineService.changeCustomerMobile(aid,mobno);
			if(count>0)
			{
				CustomerDTO  cd=OnlineService.getCustomerById(aid);
				session.setAttribute("cust", cd);
				return "success";
			}
			else
			{
				model.addAttribute("failmob","1");
				model.addAttribute("addr","1");
				return "CurrentAddr";
			}
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: updateAddress
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,parameter newaddr from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="UpdateAddress")
	public String updateAddress(@RequestParam("newaddr")String addr,Model model,HttpSession session)
	{
		long id=(long) session.getAttribute("addid");
		try 
		{
			int count=OnlineService.changeCustomerAddress(id, addr);
			if(count>0)
			{
				CustomerDTO  cd=OnlineService.getCustomerById(id);
				session.setAttribute("cust", cd);
				return "success";
			}
			else
			{
				model.addAttribute("fail","1");
				model.addAttribute("addr","1");
				return "CurrentAddr";
			}
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name:  fundtranspage
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="fundtransfer")
	public String fundtranspage()
	{
		return "Fundtransfer";
	}
	
	/***********************************************************
	 * Method Name: fundtrans
	 * Return type:String
	 * Parameters:Object of type Model,Parameter(fromacct,toacct) from Jsp Request Page,HttpSession
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="fundtrans")
	public String fundtrans(@RequestParam("fromacct") long fid,
			@RequestParam("toacct") long tid,@RequestParam("amount") double amt,HttpSession session,Model model)
	{		
		if(fid==tid)
		{
			
			model.addAttribute("fundmsg","1");
			return "Fundtransfer";
		}
		else if(amt<=0)
		{
			
			model.addAttribute("fundmsg","2");
			return "Fundtransfer";
		}
		else
		{
			try
			{
				double amount=OnlineService.getBal(fid);
				if(amount-amt>500)
				{
					session.setAttribute("id1",fid);
					session.setAttribute("id2",tid);
					session.setAttribute("amount",amt);
					return "Valdfund";
				}
				else
				{
					model.addAttribute("insuff", "1");
					return "Fundtransfer";
				}
			} 
			catch(EmptyResultDataAccessException e)
			{
				OnlineException ee=new OnlineException("No Data Found for the Given Details");
				model.addAttribute("exception",ee.getMessage());
				return "Error";
			}
			catch(DataAccessException e)
			{
				model.addAttribute("exception","Problem with database server please try again later");
				return "Error";
			}
			catch (OnlineException e)
			{
				model.addAttribute("exception","Technical Problem try again later");
				return "Error";
			} 
		}
	}
	
	/***********************************************************
	 * Method Name: validate
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameter(tpass) from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="valdfun")
	public String validate(@RequestParam("tpass") String tpass,Model model,HttpSession session)
	{
			long fid=(long) session.getAttribute("id1");
			long tid=(long) session.getAttribute("id2");
			double amt=(double) session.getAttribute("amount");
			try 
			{
					boolean validpass=OnlineService.getTranspass(tpass,fid);
					if(validpass)
					{
					int fund=OnlineService.transferFund(fid, tid, amt);
					if(fund>0)
					{
					TransactionDTO tdto=new TransactionDTO();
					tdto.setAccountId(fid);
					tdto.setTransAmt(amt);
					tdto.setTransType("D");
					int id=OnlineService.insertTransact(tdto, tid);
					if(id>0)
					{
						tdto.setTransactionId(id);
						tdto.setAccountId(tid);
						tdto.setTransAmt(amt);
						tdto.setTransType("C");
						OnlineService.insertTransacred(tdto, fid);
						session.setAttribute("funid",fund);
						return "Succfund";
					}
					else
					{
						model.addAttribute("id","0");
						return "Fundtransfer";
					}
					}
					else
					{
						model.addAttribute("fund","0");
						return "Fundtransfer";
					}
					}
					else
					{
						model.addAttribute("transpass","0");
						return "Fundtransfer";
					}
				
			}
			catch(EmptyResultDataAccessException e)
			{
				OnlineException ee=new OnlineException("No Data Found for the Given Details");
				model.addAttribute("exception",ee.getMessage());
				return "Error";
			}
			catch(DataAccessException e)
			{
				model.addAttribute("exception","Problem with database server please try again later");
				return "Error";
			}
			catch (OnlineException e)
			{
				model.addAttribute("exception","Technical Problem try again later");
				return "Error";
			} 
	}
	
	/***********************************************************
	 * Method Name: maketransfer
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="MakeTransfer")
	public String maketransfer(Model model)
	{
		model.addAttribute("count","0");
		return "Payee";
	}
	
	/***********************************************************
	 * Method Name: getpayee
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameter(fromacct) from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="getMyPayees")
	public String getpayee(@RequestParam("fromacct") long id,Model model,HttpSession session)
	{
		session.setAttribute("selectid", id);
		try 
		{
			ArrayList<Long> accids=OnlineService.getPayeeId(id);
			session.setAttribute("payid", accids);
			if(accids.size()!=0)
			{
				session.setAttribute("count","1");
			}
			else
			{
				session.setAttribute("count","2");
			}
			return "Payee";
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: addpayee
	 * Return type:String
	 * Parameters:Object of type Model
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="AddPayee")
	public String addpayee(Model model)
	{
		model.addAttribute("addpay","1");
		return "AddPayee";
	}
	
	/***********************************************************
	 * Method Name: addedpayee	
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,and Parameters from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Addedpayee")
	public String addedpayee(@RequestParam("fromacct") long id1,@RequestParam("payeeid") long id2,
			@RequestParam("nickname") String name,HttpSession session,Model model)
	{
		try
		{
		if(id1!=id2)
		{
		boolean valid=OnlineService.isValidAccount(id2);
		if(valid)
		{
		boolean checkpayee=OnlineService.checkPayee(id1,id2);
		if(!checkpayee)
		{
		PayeeDTO pdto=new PayeeDTO();
		pdto.setAccountId(id1);
		pdto.setPayeeId(id2);
		pdto.setNickName(name);
		session.setAttribute("pdto", pdto);
		Random rand=new Random();
		int rnum=rand.nextInt(100)*12;
		model.addAttribute("valpay","1");
		session.setAttribute("URN",rnum);
		return "AddPayee";
		}
		else
		{
			model.addAttribute("payavail","1");
			model.addAttribute("addpay","1");
			return "AddPayee";
		}
		}
		else
		{
			model.addAttribute("paynotavail","1");
			model.addAttribute("addpay","1");
			return "AddPayee";
		}
		}
		else
		{
			model.addAttribute("duplicpay","1");
			model.addAttribute("addpay","1");
			return "AddPayee";
		}
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: valpayee
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameter from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="valpayee")
	public String valpayee(@RequestParam("urn") int urn,HttpSession session,Model model)
	{
		int urn2=(int) session.getAttribute("URN");
		if(urn==urn2)
		{
		PayeeDTO pdto=(PayeeDTO) session.getAttribute("pdto");
		try 
		{
			int payid=OnlineService.insertPayee(pdto);
			if(payid>0)
			{
				return "Payeeaddsuccs";
			}
			else
			{
				model.addAttribute("payaddid","1" );
				model.addAttribute("addpay","1");
				return "AddPayee";
			}
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
		}
		else
		{
			model.addAttribute("urnfail","1");
			model.addAttribute("addpay","1");
			return "AddPayee";
		}
	}
	
	/***********************************************************
	 * Method Name: changepasswordpage
	 * Return type:String
	 * Parameters:None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="chnpss")
	public String changepasswordpage()
	{
		return "ChangePass";
	}
	
	/***********************************************************
	 * Method Name: changepass
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession and Parameters from Jsp page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="ChangePass")
	public String changepass(@RequestParam("oldpass") String oldpass,@RequestParam("newpass") String newpass,
			@RequestParam("renewpass") String renewpass,HttpSession session,Model model)
	{
		String username=(String) session.getAttribute("user");
		
		try
		{
			boolean pass=OnlineService.isValidPassword(oldpass,username);
			if(pass)
			{
				if(newpass.equals(renewpass))
				{
					boolean check = OnlineService.updatePassword( oldpass, newpass,username);
					if(check)
					{
					model.addAttribute("update", "1");
					return "ChangePass";
					}
					else
					{
					model.addAttribute("update", "0");
					return "ChangePass";
					}
					
				}
				else
				{
					model.addAttribute("update", "2");
					return "ChangePass";
				}
			}
			else
			{
				model.addAttribute("update", "3");
				return "ChangePass";
			}
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: reqcheqpage
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="cheqreq")
	public String reqcheqpage()
	{
		return "servreq";
	}
	
	/***********************************************************
	 * Method Name: Reqcheq
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameter from page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="insertservreq")
	public String Reqcheq(@RequestParam("Accountid") long accId,HttpSession session,Model model)
	{
		session.setAttribute("accid", accId);
		try 
		{
			if(!OnlineService.getCheqStatus(accId))
			{
				int servId=OnlineService.insertRequest(accId);
				model.addAttribute("Cheqreq","0");
				session.setAttribute("serv", servId);
				return "showRequest";
			
			}
			else
			{
				 model.addAttribute("Cheqreq","1");
				 return "showRequest";
				
			}
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: trackpage
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="track")
	public String trackpage()
	{
		return "tracserv";
	}
	
	/***********************************************************
	 * Method Name: trackReq
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,parameter from jsp page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="displayservice")
	public String trackReq(@RequestParam("Accountid")long accId,Model model,HttpSession session)
	{
		session.setAttribute("trakid", accId);
		try 
		{
			ArrayList<ServiceTrackerDTO> elist=OnlineService.getServiceById(accId);
			session.setAttribute("servdetails", elist);
			return "servicestat";
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: ministatepage
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="ministat")
	public String ministatepage()
	{
		return "MiniStatement";
	}

	/***********************************************************
	 * Method Name: viewoldtrnpage
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="ViewOldTran")
	public String viewoldtrnpage()
	{
		return "ViewOldTran";
	}
	
	/***********************************************************
	 * Method Name: viewtranac
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameters from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="ViewPrevTran")
	public String viewtranac(@RequestParam("Accountid")long accId,Model model,HttpSession session)
	{
		try
		{
			session.setAttribute("pid",accId);
			ArrayList<TransactionDTO> list=OnlineService.getTransaction(accId);
			session.setAttribute("transactions",list);
			return "ViewPrevTran";
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: viewtransdate
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameters from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="oldTran")
	public String viewtransdate(@RequestParam("Accountid")long mid,
			@RequestParam("startDate") String sDate,@RequestParam("endDate") String eDate,HttpSession session,Model model)
	{
		session.setAttribute("mid", mid);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(sDate,formatter);
		LocalDate endDate= LocalDate.parse(eDate,formatter);
		ArrayList<TransactionDTO> list=new ArrayList<TransactionDTO>();
		try
		{
			list=OnlineService.getTransactionByDate(Date.valueOf(startDate),Date.valueOf(endDate),mid);
			if(list.size()==0)
			{
				model.addAttribute("emptylist", "0");
				return "ViewTranByDate";
			}
			else
			{
				model.addAttribute("emptylist", "1");
				model.addAttribute("trandate", list);
				return "ViewTranByDate";
			}
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: adminleft
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="adminleftpage")
	public String adminleft()
	{
		return "AdminHome";
	}
	
	/***********************************************************
	 * Method Name: adminright
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="adminrightpage")
	public String adminright()
	{
		return "Adminwelcome";
	}
	
	/***********************************************************
	 * Method Name: newaccount
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="newAccount")
	public String newaccount(Model model,HttpSession session)
	{
		UserDTO udto=new UserDTO();
		model.addAttribute("udto",udto);
		ArrayList<String> ques;
		try 
		{
			ques = OnlineService.getAllQuestions();
			session.setAttribute("user", ques);
			return "Addonlineuser";
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: insertonline
	 * Return type:String
	 * Parameters:Object of type Model,BindingResult,HttpSession,Parameter from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Insertonline")
	public String insertonline(@ModelAttribute("udto")@Valid UserDTO udto,BindingResult result,Model model,HttpSession session)
	{
		if(result.hasErrors())
		{
			return "Addonlineuser";
		}
		else
		{
		try 
			{
				if(OnlineService.isValidloginuser(udto.getUserId()))
				{
					model.addAttribute("exists","1");
					return "Addonlineuser";
				}
				else
				{
					session.setAttribute("newudto",udto);
					model.addAttribute("adto",new AccountDTO());
					return "AddAccountDetails";
				}
			}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
		
		}
	}
	
	/***********************************************************
	 * Method Name: insertcust
	 * Return type:String
	 * Parameters:Object of type Model,BindingResult,HttpSession,Parameters from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Insertacc")
	public String insertcust(@ModelAttribute("adto")@Valid AccountDTO adt,BindingResult result,HttpSession session,Model model)
	{
		if(result.hasErrors())
		{
			return "AddAccountDetails";
		}
		else if(adt.getAccountBalance()<1)
		{
			model.addAttribute("bal","1");
			return "AddAccountDetails";
		}
		else
		{
			session.setAttribute("newadto", adt);
			model.addAttribute("cdto",new CustomerDTO());
			return "AddNewCustomer";
		}
	}
	
	/***********************************************************
	 * Method Name: insertcustomerdetails
	 * Return type:String
	 * Parameters:Object of type Model,BindingResult,HttpSession,Parameters from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="Insertcustomer")
	public String insertcustomerdetails(@ModelAttribute("cdto")@Valid CustomerDTO cdto,
			BindingResult result,HttpSession session,Model model)
	{
		if(result.hasErrors())
		{
			return "AddNewCustomer";
		}
		else
		{
		UserDTO udto=(UserDTO) session.getAttribute("newudto");
		AccountDTO adto=(AccountDTO) session.getAttribute("newadto");
		try 
		{
			if(OnlineService.checkEmail(cdto.getEmail()))
			{
				model.addAttribute("emailexits","1");
				return "AddNewCustomer";
			} 
			else if(OnlineService.checkPancard(cdto.getPancard()))
			{
				model.addAttribute("pancardexists","1");
				return "AddNewCustomer";
			}
			else if(OnlineService.checkMobilenum(cdto.getMobileNumber()))
			{
				model.addAttribute("mobileexists","1");
				return "AddNewCustomer";
			}
			else 
			{
			long id=OnlineService.addNewCustByAdmin(cdto,adto,udto);
			if(id>0)
			{
				session.setAttribute("newid",id);
				return "AddCustSuccess";
			}
			else
			{
				model.addAttribute("insertfailed","1");
				UserDTO udtos=new UserDTO();
				model.addAttribute("udto",udtos);
				ArrayList<String> ques;
				try 
				{
					ques = OnlineService.getAllQuestions();
					session.setAttribute("user", ques);
					return "Addonlineuser";
				} 
				catch (OnlineException e)
				{
					model.addAttribute("exception",e.getMessage());
					return "Error";
				}
			}
			}
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
		}
	}
	
	/***********************************************************
	 * Method Name: viewalltranspage
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="getalltrans")
	public String viewalltranspage(Model model,HttpSession session)
	{
		try 
		{
			ArrayList<Long> accids=OnlineService.getAllAccounts();
			model.addAttribute("allids",accids);
			return "Getalltrans";
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: gettransbyid
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameters from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="gettransacs")
	public String gettransbyid(@RequestParam("Accountid")long accId,Model model,HttpSession session)
	{
		try 
		{
			ArrayList<TransactionDTO> trans=OnlineService.getTransaction(accId);
			if(trans.size()==0)
			{
				model.addAttribute("tids","0");
				return "Transaactionpage";
			}
			else
			{
				model.addAttribute("transids", trans);
				return "Transaactionpage";
			}
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: getalltrans
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="getalltransaction")
	public String getalltrans(Model model,HttpSession session)
	{
		try 
		{
			ArrayList<TransactionDTO> trans=OnlineService.getAllTransactions();
			if(trans.size()==0)
			{
				model.addAttribute("tids","0");
				return "Transaactionpage";
			}
			else
			{
				model.addAttribute("transids", trans);
				return "Transaactionpage";
			}
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: idcheck
	 * Return type:String
	 * Parameters: None
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="forgot")
	public String idcheck()
	{
		return "idcheck";
	}
	
	/***********************************************************
	 * Method Name: forgot
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameters from Jsp Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="getforgotid")
	public String forgot(@RequestParam("accid")long accid,HttpSession session,Model model)
	{
		session.setAttribute("forgotid", accid);
		boolean validId;
		try 
		{
			validId = OnlineService.isValidAccountUser(accid);
			if(validId)
			{
				ArrayList<String> ques=OnlineService.getAllQuestions();
				session.setAttribute("user", ques);
				String userid=OnlineService.getUserid(accid);
				session.setAttribute("fuserid",userid);
				return "forgot";
			}
			else
			{
				model.addAttribute("notvalidid","1");
				return "idcheck";
			}
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name: checkques
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameters from Jsp PAge
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="checkques")
	public String checkques(@RequestParam("ques") String question,@RequestParam("ans")String answer,Model model,HttpSession session)
	{
		long accId=(long) session.getAttribute("forgotid");
		try 
		{
			boolean validques=OnlineService.isValidAnswer(question,answer,accId);
			if(validques)
			{
				return "newpass";
			}
			else
			{
				model.addAttribute("answerfail","1");
				return "forgot";
			}
		}
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
	
	/***********************************************************
	 * Method Name:  updatepass
	 * Return type:String
	 * Parameters:Object of type Model,HttpSession,Parameters from Jsp Request Page
	 * Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@RequestMapping(value="checkPass")
	public String updatepass(@RequestParam("pass1")String password1,@RequestParam("pass2")String password2,
			HttpSession session,Model model)
	{
		String userid=(String) session.getAttribute("fuserid");
		try 
		{
			if(password1.equals(password2))
			{
				boolean update=OnlineService.updateForgotPassword(userid, password1);
				if(update)
				{
					return "successforgotpass";
				}
				else
				{
					model.addAttribute("updatefail","1");
					return "newpass";
				}
			}
			else
			{
				model.addAttribute("passmismath","1");
				return "newpass";
			}
		} 
		catch(EmptyResultDataAccessException e)
		{
			OnlineException ee=new OnlineException("No Data Found for the Given Details");
			model.addAttribute("exception",ee.getMessage());
			return "Error";
		}
		catch(DataAccessException e)
		{
			model.addAttribute("exception","Problem with database server please try again later");
			return "Error";
		}
		catch (OnlineException e)
		{
			model.addAttribute("exception","Technical Problem try again later");
			return "Error";
		} 
	}
}
