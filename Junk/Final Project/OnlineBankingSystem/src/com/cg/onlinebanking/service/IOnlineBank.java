package com.cg.onlinebanking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.PayeeDTO;
import com.cg.onlinebanking.dto.ServiceTrackerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.dto.UserDTO;
import com.cg.onlinebanking.exception.OnlineException;

public interface IOnlineBank 
{
	//method to change address of customer
	
		public int changeCustomerAddress(long accId,String address) throws OnlineException;
		
		
		public boolean isValidPayee(long accId) throws OnlineException;
		
		
		public String getServiceStatus(int serviceId) throws OnlineException;
		
		
		public int transferFund(long from,long to,double amt) throws OnlineException;
		
		
		public int requestChequeBook(long accId) throws OnlineException;
		
		
		public ArrayList<TransactionDTO> getTransaction(long accId) throws OnlineException;
		
		
		public ArrayList<AccountDTO> getAllAccounts() throws OnlineException;
		
		
		public CustomerDTO getCustomerById(long accId) throws OnlineException;
		
		
		public boolean isValidAdmin(String user,String pwd) throws OnlineException;
		
		
		public boolean isValidAccount(long accId) throws OnlineException;
		
		
		public ArrayList<TransactionDTO> getAllTransactions() throws OnlineException;
		
		
		public AccountDTO getAccountById(long id) throws OnlineException; 
		
		
		int insertCustdetails(CustomerDTO p) throws OnlineException;
	
		
		public boolean isValiduser(String user,String pwd) throws OnlineException;
		
		
		public ArrayList<Long> getAcctid(String uname) throws OnlineException;
	
		
		public double getBal(long id) throws OnlineException;
		
	
		public String getServiceStatus1(long accNo) throws OnlineException;
		
		
		public List<ServiceTrackerDTO> getAllServiceDetails() throws OnlineException;
		
		
		public int insertRequest(long accId) throws OnlineException;
		
		
		public List<ServiceTrackerDTO> getServiceById(long accId) throws OnlineException;
		
		
		public int changeCustomerMobile(long accountId,String mobNum) throws OnlineException;
		
		
		public boolean updatePassword(String oldpwd,String newpwd) throws OnlineException;
		
		
		public boolean isValidPassword(String oldpwd) throws OnlineException;

		
		public ArrayList<TransactionDTO> getTransactionByDate(Date startDate,Date endDate,long id) throws OnlineException;
		
		
		public ArrayList<Long> getPayeeId(long id) throws OnlineException;
		
		
		public int insertPayee(PayeeDTO pdto) throws OnlineException;
		
		
		public boolean getTranspass(String tpass, long id) throws OnlineException;
		
		
		public long addNewCustByAdmin(CustomerDTO cust,AccountDTO account,UserDTO user) throws OnlineException;
		
		
		public ArrayList<Long> getAcctids() throws OnlineException;
		
		public int insertTransact(TransactionDTO tdto,long id) throws OnlineException;
		
		public ArrayList<String> getAllQuestions() throws OnlineException;
		
		public boolean isValidAnswer(String question,String answer) throws OnlineException;
		
		public boolean updateForgotPassword(Long accid,String newpwd) throws OnlineException;
		
		public boolean isValidAccountUser(long accId) throws OnlineException;
		
		public boolean checkPayee(long fid,long tid) throws OnlineException;
		
		public String checkStatus(String userid) throws OnlineException;
		
		public boolean getCheqStatus(long id) throws OnlineException;
}
