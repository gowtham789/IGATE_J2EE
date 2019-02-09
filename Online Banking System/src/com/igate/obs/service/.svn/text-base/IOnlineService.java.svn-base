package com.igate.obs.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igate.obs.dto.AccountDTO;
import com.igate.obs.dto.CustomerDTO;
import com.igate.obs.dto.PayeeDTO;
import com.igate.obs.dto.ServiceTrackerDTO;
import com.igate.obs.dto.TransactionDTO;
import com.igate.obs.dto.UserDTO;
import com.igate.obs.exception.OnlineException;

public interface IOnlineService 
{

	public boolean isValiduser(String user,String pwd) throws OnlineException;
	
	public boolean isValidAdmin(String user,String pwd) throws OnlineException;
	
	public ArrayList<Long> getAllAcctids(String userid) throws OnlineException;
	
	public double getBal(long id) throws OnlineException;
	
	public int changeCustomerAddress(long accId,String address) throws OnlineException;
	
	public CustomerDTO getCustomerById(long accId) throws OnlineException;
	
	public int changeCustomerMobile(long accountId,String mobNum) throws OnlineException;
	
	public int transferFund(long from,long to,double amt) throws OnlineException;
	
	public boolean getTranspass(String tpass, long id) throws OnlineException;
	
	public int insertTransact(TransactionDTO tdto,long id) throws OnlineException;
	
	public int insertTransacred(TransactionDTO tdto,long id) throws OnlineException;
	
	public ArrayList<Long> getPayeeId(long id) throws OnlineException;
	
	public int insertPayee(PayeeDTO pdto) throws OnlineException;
	
	public boolean checkPayee(long fid,long tid) throws OnlineException;
	
	public boolean isValidAccount(long accId) throws OnlineException;
	
	public boolean isValidPassword(String oldpwd,String uname) throws OnlineException;
	
	public boolean updatePassword(String oldpwd,String newpwd,String uname) throws OnlineException;
	
	public boolean getCheqStatus(long id) throws OnlineException;
	
	public int insertRequest(long accId) throws OnlineException;
	
	public ArrayList<ServiceTrackerDTO> getServiceById(long accId) throws OnlineException;
	
	public ArrayList<TransactionDTO> getTransaction(long accId) throws OnlineException;
	
	public ArrayList<TransactionDTO> getTransactionByDate(Date startDate,Date endDate,long id) throws OnlineException;
	
	public ArrayList<TransactionDTO> getAllTransactions() throws OnlineException;
	
	public ArrayList<Long> getAllAccounts() throws OnlineException;
	
	public ArrayList<String> getAllQuestions() throws OnlineException;
	
	public boolean isValidAnswer(String question,String answer,long id) throws OnlineException;
	
	public boolean updateForgotPassword(String userid,String newpwd) throws OnlineException;
	
	public boolean isValidAccountUser(long accId) throws OnlineException;
	
	public String getUserid(long id) throws OnlineException;
	
	public boolean isValidloginuser(String userid) throws OnlineException;
	
	public long addNewCustByAdmin(CustomerDTO cust,AccountDTO account,UserDTO user) throws OnlineException;
	
	public String checkStatus(String userid) throws OnlineException;
	
	public boolean checkEmail(String email) throws OnlineException;
	
	public boolean checkMobilenum(String mnum) throws OnlineException;
	
	public boolean checkPancard(String pcard) throws OnlineException;
}
