package com.cg.onlinebanking.service;

import java.util.ArrayList;

import com.cg.onlinebanking.dao.NetbankingDao;
import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.exception.OnlineException;

public class BankService implements IOnlineBank

{
	
	NetbankingDao ndao=new NetbankingDao();


	
	@Override
	public CustomerDTO getCustomerById(long accId) throws OnlineException 
	{
		
		return ndao.getCustomerById(accId);
	}



	@Override
	public int changeCustomerAddress(long accountId,String address) throws OnlineException {

		return ndao.changeCustomerAddress(accountId,address);
	}


	@Override
	public int changeCustomerMobile(long accountId, String mobNum) throws OnlineException {

		return ndao.changeCustomerMobile(accountId, mobNum);
	}



	


	/*@Override
	public String getServiceStatus(int serviceId) throws OnlineException {
		
		return ndao.getServiceStatus(serviceId);
	}


	@Override
	public boolean transferFund(long from, long to, double amt)
			throws OnlineException {
		
		return ndao.transferFund(from,to,amt);
	}


	@Override
	public int requestChequeBook(long accId) throws OnlineException {
		
		return ndao.requestChequeBook(accId);
	}


	@Override
	public ArrayList<TransactionDTO> getTransaction(long accId) throws OnlineException {
		
		return ndao.getTransaction(accId);
	}


	@Override
	public ArrayList<AccountDTO> getAllAccounts() throws OnlineException {
		return ndao.getAllAccounts();
	
	}


	

	

	@Override
	public boolean isValidAccount(long accId) throws OnlineException {
	
		return ndao.isValidAccount(accId);
	}


	@Override
	public ArrayList<TransactionDTO> getAllTransactions()
			throws OnlineException {
		
		return ndao.getAllTransactions();
	}

	@Override
	public AccountDTO getAccountById(long id) throws OnlineException
	{
		
		return ndao.getAccountById(id);
	}


	@Override
	public int insertCustdetails(CustomerDTO p) throws OnlineException {
		
		return ndao.insertCustdetails(p);
	}


	@Override
	public boolean updatePassword(String userId, String oldpwd, String newpwd) throws OnlineException 
	{
	
		return ndao.updatePassword(userId, oldpwd, newpwd);
	}





	@Override
	public boolean isValidPayee(long accId) throws OnlineException {
		
		return ndao.isValidPayee(accId);
	}





	@Override
	public boolean isValidAdmin(String user, String pwd) throws OnlineException
	{
		return ndao.isValidAdmin(user,pwd);
	}
	

*/
	}
	
	



