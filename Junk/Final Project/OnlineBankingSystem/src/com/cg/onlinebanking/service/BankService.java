package com.cg.onlinebanking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cg.onlinebanking.dao.InetbankinDao;
import com.cg.onlinebanking.dao.NetbankingDao;
import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.PayeeDTO;
import com.cg.onlinebanking.dto.ServiceTrackerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.dto.UserDTO;
import com.cg.onlinebanking.exception.OnlineException;
public class BankService implements IOnlineBank

{
	
	InetbankinDao ndao=new NetbankingDao();


	@Override
	public int changeCustomerAddress(long id, String address) throws OnlineException 
	{
		
		return ndao.changeCustomerAddress(id,address);
	}


	@Override
	public String getServiceStatus(int serviceId) throws OnlineException {
		
		return ndao.getServiceStatus(serviceId);
	}


	@Override
	public int transferFund(long from, long to, double amt)
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
	public CustomerDTO getCustomerById(long accId) throws OnlineException 
	{
		
		return ndao.getCustomerById(accId);
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
	public boolean isValidPayee(long accId) throws OnlineException {
		
		return ndao.isValidPayee(accId);
	}


	@Override
	public boolean isValidAdmin(String user, String pwd) throws OnlineException
	{
		return ndao.isValidAdmin(user,pwd);
	}


	@Override
	public boolean isValiduser(String user, String pwd) throws OnlineException {
		
		
		return ndao.isValiduser(user,pwd);
	}


	@Override
	public ArrayList<Long> getAcctid(String uname) throws OnlineException 
	{
		return ndao.getAcctid(uname);
	}


	@Override
	public double getBal(long id) throws OnlineException {
		
		return ndao.getBal(id);
	}


	@Override
	public String getServiceStatus1(long accNo) throws OnlineException {
	
		return ndao.getServiceStatus1(accNo);
	}


	@Override
	public int insertRequest(long accId) throws OnlineException {
		
		return ndao.insertRequest(accId);
	}


	@Override
	public List<ServiceTrackerDTO> getServiceById(long accId)
			throws OnlineException {
	
		return ndao.getServiceById(accId);
	}
	
	@Override
	public List<ServiceTrackerDTO> getAllServiceDetails()  throws OnlineException{
	
		return ndao.getAllServiceDetails();
	}

	@Override
	public int changeCustomerMobile(long accountId, String mobNum) throws OnlineException {

		return ndao.changeCustomerMobile(accountId, mobNum);
	}



	@Override
	public boolean updatePassword(String oldpwd, String newpwd) throws OnlineException 
	{
		
		return ndao.updatePassword(oldpwd, newpwd);
	}


	@Override
	public boolean isValidPassword(String oldpwd) throws OnlineException {
		
		return ndao.isValidPassword(oldpwd);
	}



	@Override
	public ArrayList<TransactionDTO> getTransactionByDate(Date startDate, Date endDate,long id) throws OnlineException 
	{
		
		return ndao.getTransactionByDate(startDate, endDate,id);
	}
	
	@Override
	public ArrayList<Long> getPayeeId(long id) throws OnlineException {
		
		return ndao.getPayeeId(id);
	}


	@Override
	public int insertPayee(PayeeDTO pdto) throws OnlineException {
		
		return ndao.insertPayee(pdto);
	}


	@Override
	public boolean getTranspass(String tpass,long id) throws OnlineException {
		
		return ndao.getTranspass(tpass,id);
	}

	@Override
	public long addNewCustByAdmin(CustomerDTO cust, AccountDTO account,UserDTO user)
			throws OnlineException 
	{
		return ndao.addNewCustByAdmin(cust, account, user);
	}

	@Override
	public ArrayList<Long> getAcctids() throws OnlineException
	{

		return ndao.getAcctids();
	}


	@Override
	public int insertTransact(TransactionDTO tdto,long id) throws OnlineException 
	{
		return ndao.insertTransact(tdto,id);
	}


	
	@Override
	public ArrayList<String> getAllQuestions() throws OnlineException {
		
		return ndao.getAllQuestions();
	}

	@Override
	public boolean isValidAnswer(String question, String answer)
			throws OnlineException {
		return ndao.isValidAnswer(question, answer);
	}

	@Override
	public boolean updateForgotPassword(Long accid, String newpwd)
			throws OnlineException {
		return  ndao.updateForgotPassword(accid, newpwd);
	}


	@Override
	public boolean isValidAccountUser(long accId) throws OnlineException {
		
		return ndao.isValidAccountUser(accId);
	}


	@Override
	public boolean checkPayee(long fid, long tid) throws OnlineException {
		
		return ndao.checkPayee(fid, tid);
	}


	@Override
	public String checkStatus(String userid) throws OnlineException
	{
		
		return ndao.checkStatus(userid);
	}


	@Override
	public boolean getCheqStatus(long id) throws OnlineException
	{
		
		return ndao.getCheqStatus(id);
	}

	
}	
	



