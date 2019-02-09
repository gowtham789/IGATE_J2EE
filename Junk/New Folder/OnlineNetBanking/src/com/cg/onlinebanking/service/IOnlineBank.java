package com.cg.onlinebanking.service;

import java.util.ArrayList;

import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.exception.OnlineException;

public interface IOnlineBank 
{
	//method to change address of customer
	
		public int changeCustomerAddress(long accountId,String address) throws OnlineException;
		
		public CustomerDTO getCustomerById(long accId) throws OnlineException;
		
		public int changeCustomerMobile(long accountId,String mobNum) throws OnlineException;
		
		/*public boolean isValidPayee(long accId) throws OnlineException;
		
		
		public boolean updatePassword(String userId,String oldpwd,String newpwd) throws OnlineException;
		
		
		public String getServiceStatus(int serviceId) throws OnlineException;
		
		
		public boolean transferFund(long from,long to,double amt) throws OnlineException;
		
		
		public int requestChequeBook(long accId) throws OnlineException;
		
		
		public ArrayList<TransactionDTO> getTransaction(long accId) throws OnlineException;
		
		
		public ArrayList<AccountDTO> getAllAccounts() throws OnlineException;
		
		
		public boolean isValidAdmin(String user,String pwd) throws OnlineException;
		
		
		public boolean isValidAccount(long accId) throws OnlineException;
		
		
		public ArrayList<TransactionDTO> getAllTransactions() throws OnlineException;
		
		
		public AccountDTO getAccountById(long id) throws OnlineException; 
		
		int insertCustdetails(CustomerDTO p) throws OnlineException;
	
	*/
	
	
	
}
