package com.igate.obs.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.obs.dao.IOnlineBanking;
import com.igate.obs.dto.AccountDTO;
import com.igate.obs.dto.CustomerDTO;
import com.igate.obs.dto.PayeeDTO;
import com.igate.obs.dto.ServiceTrackerDTO;
import com.igate.obs.dto.TransactionDTO;
import com.igate.obs.dto.UserDTO;
import com.igate.obs.exception.OnlineException;

@Service("OnlineService")
public class OnlineBankingService implements IOnlineService
{

	@Autowired
	IOnlineBanking odao;
	
	
	@Override
	public boolean isValiduser(String user, String pwd) throws OnlineException {
		
		return odao.isValiduser(user, pwd);
	}

	@Override
	public boolean isValidAdmin(String user, String pwd) throws OnlineException {
		
		return odao.isValidAdmin(user, pwd);
	}

	@Override
	public ArrayList<Long> getAllAcctids(String userid) throws OnlineException {
		
		return odao.getAllAcctids(userid);
	}

	@Override
	public double getBal(long id) throws OnlineException {
		
		return odao.getBal(id);
	}

	@Override
	public int changeCustomerAddress(long accId, String address)
			throws OnlineException {
		
		return odao.changeCustomerAddress(accId, address);
	}

	@Override
	public CustomerDTO getCustomerById(long accId) throws OnlineException {
		
		return odao.getCustomerById(accId);
	}

	@Override
	public int changeCustomerMobile(long accountId, String mobNum)
			throws OnlineException {
		
		return odao.changeCustomerMobile(accountId, mobNum);
	}

	@Override
	public int transferFund(long from, long to, double amt)
			throws OnlineException {
		
		return odao.transferFund(from, to, amt);
	}

	@Override
	public boolean getTranspass(String tpass, long id) throws OnlineException {
		
		return odao.getTranspass(tpass, id);
	}

	@Override
	public int insertTransact(TransactionDTO tdto, long id)
			throws OnlineException {
		
		return odao.insertTransact(tdto, id);
	}

	@Override
	public int insertTransacred(TransactionDTO tdto, long id)
			throws OnlineException {
		
		return odao.insertTransacred(tdto, id);
	}

	@Override
	public ArrayList<Long> getPayeeId(long id) throws OnlineException 
	{
		
		return odao.getPayeeId(id);
	}

	@Override
	public int insertPayee(PayeeDTO pdto) throws OnlineException 
	{
		
		return odao.insertPayee(pdto);
	}

	@Override
	public boolean checkPayee(long fid, long tid) throws OnlineException 
	{
		
		return odao.checkPayee(fid, tid);
	}

	@Override
	public boolean isValidAccount(long accId) throws OnlineException 
	{
		
		return odao.isValidAccount(accId);
	}

	@Override
	public boolean isValidPassword(String oldpwd, String uname)
			throws OnlineException {
		
		return odao.isValidPassword(oldpwd, uname);
	}

	@Override
	public boolean updatePassword(String oldpwd, String newpwd, String uname)
			throws OnlineException {
		
		return odao.updatePassword(oldpwd, newpwd, uname);
	}

	@Override
	public boolean getCheqStatus(long id) throws OnlineException 
	{
		
		return odao.getCheqStatus(id);
	}

	@Override
	public int insertRequest(long accId) throws OnlineException 
	{
	
		return odao.insertRequest(accId);
	}

	@Override
	public ArrayList<ServiceTrackerDTO> getServiceById(long accId)
			throws OnlineException 
	{

		return odao.getServiceById(accId);
	}

	@Override
	public ArrayList<TransactionDTO> getTransaction(long accId)
			throws OnlineException 
	{
		
		return odao.getTransaction(accId);
	}

	@Override
	public ArrayList<TransactionDTO> getTransactionByDate(Date startDate,
			Date endDate, long id) throws OnlineException 
	{
		
		return odao.getTransactionByDate(startDate, endDate, id);
	}

	@Override
	public ArrayList<TransactionDTO> getAllTransactions()
			throws OnlineException 
	{
		
		return odao.getAllTransactions();
	}

	@Override
	public ArrayList<Long> getAllAccounts() throws OnlineException 
	{
	
		return odao.getAllAccounts();
	}

	@Override
	public ArrayList<String> getAllQuestions() throws OnlineException {
		
		return odao.getAllQuestions();
	}

	@Override
	public boolean isValidAnswer(String question, String answer,long id)
			throws OnlineException 
	{
		
		return odao.isValidAnswer(question, answer,id);
	}

	@Override
	public boolean updateForgotPassword(String userid, String newpwd)
			throws OnlineException
	{
		
		return odao.updateForgotPassword(userid, newpwd);
	}

	@Override
	public boolean isValidAccountUser(long accId) throws OnlineException 
	{
		
		return odao.isValidAccountUser(accId);
	}

	@Override
	public String getUserid(long id) throws OnlineException 
	{
	
		return odao.getUserid(id);
	}

	@Override
	public boolean isValidloginuser(String userid) throws OnlineException 
	{
		
		return odao.isValidloginuser(userid);
	}

	@Override
	public long addNewCustByAdmin(CustomerDTO cust, AccountDTO account,
			UserDTO user) throws OnlineException 
	{
		
		return odao.addNewCustByAdmin(cust, account, user);
	}

	@Override
	public String checkStatus(String userid) throws OnlineException 
	{
		
		return odao.checkStatus(userid);
	}

	@Override
	public boolean checkEmail(String email) throws OnlineException {
		
		return odao.checkEmail(email);
	}

	@Override
	public boolean checkMobilenum(String mnum) throws OnlineException {
		
		return odao.checkMobilenum(mnum);
	}

	@Override
	public boolean checkPancard(String pcard) throws OnlineException {
		
		return odao.checkPancard(pcard);
	}
	
}
