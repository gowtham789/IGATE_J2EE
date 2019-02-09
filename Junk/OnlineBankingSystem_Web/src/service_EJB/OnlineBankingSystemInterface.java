package service_EJB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dto_JPA.Accountmaster;
import dto_JPA.Customer;
import dto_JPA.Payee;
import dto_JPA.Servicetracker;
import dto_JPA.Transaction;
import dto_JPA.UserRegistration;
import dto_JPA.Useraccount;

public interface OnlineBankingSystemInterface {
	public boolean ConfirmUser(long userId);
	public ArrayList<Accountmaster> retrieveAllAccount();
	public ArrayList<UserRegistration> retrieveUserRegistrations();
	public boolean addNewUserRegistration(String accountType,String Address,String CustomerName,String Email,String LockStatus,String LoginPassword,long MobileNumber,String PanCard,String SecretAnswer,String SecretQuestion,String TransactionPassword,long userID);
	public boolean ConfirmPayee(long PayeeAccountID);
	public ArrayList<Payee> viewPayee(long AccountID);
	public boolean addPayee(long AccountID ,String NickName, long PayeeAccountID);
	public ArrayList<Useraccount> ViewUserInfo(long userID);
	public String lockAccount(long userID);
	public String AuthenticateUser(long LoginID,String Password);
	public boolean RegisterUser(String Address , String Name ,
								String email , String PanCardNum,
								String AccountType,
								String Password , String SecurityQuestion , 
								String Answer,String TransactionPassword,
								long UserID,long mobileNumber);
	
   public String ForgotPassword(long userID , String SecurityQuestion, String SecurityAnswer);
   public ArrayList<Transaction> GenerateStatement(long AccountID);
   public ArrayList<Transaction> GenerateStatement(long AccountID,int NumOfTransactions);
   public ArrayList<Transaction> GenerateStatement(long AccountID,Date Start,Date End);
   public Customer ViewCustomerInfo(long AccountID);
   public boolean UpdateCustomerInfo(String Address,long MobileNuber,String email,long AccountID);
   public Accountmaster ViewAccountInfo(long AccountID);
   public Servicetracker viewSerivceDetails(long ServiceID);
   public ArrayList<Servicetracker> viewallRequests(long AccountID);
   public boolean RaiseServiceRequest (long accountID,String ServiceDesc , String ServiceStatus);
   public boolean addTransactionHistory(long accountID , String transactionType , float amount , String transactionDesc);
   public boolean accountDebit(float Balance,long AccountID, long payeeAccountID);
   public boolean accountDebitSameBank(float Balance,long AccountID, long payeeAccountID);
   public boolean accountCredit(float Balance,long AccountID, long payeeAccountID);
}
