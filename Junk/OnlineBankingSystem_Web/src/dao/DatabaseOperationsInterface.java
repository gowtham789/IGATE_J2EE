package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dto_JPA.*;

public interface DatabaseOperationsInterface {
	public boolean deleteRegistration(long UserId) throws SQLException;
	public ArrayList<UserRegistration> retrieveUserRegistrations() throws SQLException;
	public boolean addNewUserRegistration(String accountType,String Address,String CustomerName,String Email,String LockStatus,String LoginPassword,long MobileNumber,String PanCard,String SecretAnswer,String SecretQuestion,String TransactionPassword,long userID);
	public boolean ChangePassword(String password , long userID) throws SQLException;
	public boolean changeLoginAtempts(int loginAttempts , long userID) throws SQLException;
	public boolean changeAccountLockStatus(String status , long UserID) throws SQLException;
	public boolean addCustomer(Customer customer);

	public Customer retrieveCustomer(long AccountID) throws SQLException;

	public boolean addUserAccount(Useraccount user);

	public ArrayList<Useraccount> RetrieveUserAccount(long userid)
			throws SQLException;

	public boolean addAccountMaster(Accountmaster account);

	public Accountmaster retrieveAccount(long AccountID) throws SQLException;
	
	public ArrayList<Customer> retrieveAllCustomers() throws SQLException;
	public ArrayList<Accountmaster> retrieveAllAccount() throws SQLException;
	
	public boolean updateAccountBalance(float Updatedbalance , long AccountID) throws SQLException;

	public ArrayList<Payee> RetrievePayee(long accountID) throws SQLException;

	public boolean addPayee(Payee payee);
	
	public boolean ConfirmPayee(long payeeAccountID) throws SQLException;

	public Servicetracker RetrieveServiceInfo(long ServiceID) throws SQLException;

	public ArrayList<Servicetracker> RetrieveService(long AccountID)
			throws SQLException;

	public boolean addNewService(Servicetracker service);

	public ArrayList<Transaction> RetrieveAllTransaction(long AccountID) throws SQLException;

	public ArrayList<Transaction> RetrieveAllTransaction(long AccountID,
			int NumOfTransation) throws SQLException;

	public ArrayList<Transaction> RetrieveAllTransaction(long AccountID,
			Date Start, Date End) throws SQLException;

	public boolean addNewTransaction(Transaction transaction);

	public boolean updateCutomerInfo(String email, long MobileNumber,
			String address, long AccountID) throws SQLException;
}
