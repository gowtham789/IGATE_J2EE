package service_EJB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import dao.DatabaseOperations;
import dao.DatabaseOperationsInterface;
import dto_JPA.Accountmaster;
import dto_JPA.Customer;
import dto_JPA.Payee;
import dto_JPA.Servicetracker;
import dto_JPA.Transaction;
import dto_JPA.UserRegistration;
import dto_JPA.Useraccount;

public class OnlineBankingSystem implements OnlineBankingSystemInterface {
	static long AccountID=0;
	static private DatabaseOperationsInterface DOI = null;
	static {
		DOI = new DatabaseOperations();
	}

	@Override
	public String AuthenticateUser(long LoginID, String Password) {
             System.out.println(LoginID);
		try {
			ArrayList<Useraccount> user = DOI.RetrieveUserAccount(LoginID);
			if(user!=null)
			{
			if (user.get(0).getLoginPassword().equals(Password))
			{
				if(user.get(0).getLockstatus().equals("N"))
				  return "Login Successful";
				else
					return "Account Locked";
			}
			else
			{
				DOI.changeLoginAtempts(user.get(0).getLoginAttempts()+1, LoginID);
				if(DOI.RetrieveUserAccount(LoginID).get(0).getLoginAttempts() >3)
				{
					lockAccount(LoginID);
					return "Account Locked";
				}
				else
				return "in-correct Password";
			}
			}
			else
				return "in-correct user ID";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Failed";
		}
	
	}

	@Override
	public boolean RegisterUser(String Address, String Name,
			String email, String PanCardNum, String AccountType,
			String Password, String SecurityQuestion, String Answer,
			String TransactionPassword, long UserID, long mobileNumber) {
		
		Customer customer = new Customer();
		
		customer.setAddress(Address);
		customer.setCustomerName(Name);
		customer.setEmail(email);
		customer.setPancard(PanCardNum);
		customer.setMobileNumber(mobileNumber);
		if (DOI.addCustomer(customer) == false) {
			System.out
					.println("Acount is already present\n linking the user to the account ..");

		}
		
		try {
			for ( Customer customerz: DOI.retrieveAllCustomers())
			{
				if( AccountID < customerz.getAccountId())
				{
					AccountID=customerz.getAccountId();
				}
			}
		} catch (SQLException e) {
			AccountID=0;
			e.printStackTrace();
			
		}
		Accountmaster account = new Accountmaster();
		account.setAccountBalance(0);
		account.setAccountId(AccountID);
		account.setAccounttype(AccountType);
		account.setOpenDate(new GregorianCalendar().getTime());
		DOI.addAccountMaster(account);

		Useraccount user = new Useraccount();
		user.setAccountId(AccountID);
		user.setLockstatus("N");
		user.setLoginPassword(Password);
		user.setSecretQuestion(SecurityQuestion);
		user.setTransactionPassword(TransactionPassword);
		user.setUserId(UserID);
		user.setSecretAnswer(Answer);
		user.setLoginAttempts(0);
		if (DOI.addUserAccount(user) == false) {
			System.out.println("Account is already linked to a user");
			AccountID=0;
			try {
				DOI.deleteRegistration(UserID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		AccountID=0;
		try {
			DOI.deleteRegistration(UserID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String ForgotPassword(long userID, String SecurityQuestion,
			String SecurityAnswer) {
		try {
			if (DOI.RetrieveUserAccount(userID) == null) {
				System.out.println("User ID Does not exist");
				return "Incorrect ID";
			} else {
				if (DOI.RetrieveUserAccount(userID).get(0).getSecretQuestion()
						.equalsIgnoreCase(SecurityQuestion)) {
					System.out.println(DOI.RetrieveUserAccount(userID).get(0)
							.getSecretAnswer());
					if (DOI.RetrieveUserAccount(userID).get(0)
							.getSecretAnswer().equalsIgnoreCase(SecurityAnswer)) {
						DOI.ChangePassword("sbq500#", userID);
						return "sbq500#";
					
					} else {
						System.out.println("incorrect answer");
						return "Incorrect Answer";
					}
				} else {
					System.out.println("Incorrect Security Question");
					return "Incorrect Question";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Exception Rose";
		}

	}

	@Override
	public ArrayList<Transaction> GenerateStatement(long AccountID) {
		try {
			return DOI.RetrieveAllTransaction(AccountID);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Transaction> GenerateStatement(long AccountID,
			int NumOfTransactions) {
		ArrayList<Transaction> transactions = null;
		try {
			transactions = DOI.RetrieveAllTransaction(AccountID,
					NumOfTransactions);
			if (transactions != null)
				return transactions;
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ArrayList<Transaction> GenerateStatement(long AccountID, Date Start,
			Date End) {
		ArrayList<Transaction> transactions = null;
		try {
			transactions = DOI.RetrieveAllTransaction(AccountID, Start, End);
			if (transactions != null)
				return transactions;
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer ViewCustomerInfo(long AccountID) {
		try {
			return DOI.retrieveCustomer(AccountID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Accountmaster ViewAccountInfo(long AccountID) {
		try {
			return DOI.retrieveAccount(AccountID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean UpdateCustomerInfo(String Address, long MobileNuber,
			String email, long AccountID) {
		try {
			return DOI
					.updateCutomerInfo(email, MobileNuber, Address, AccountID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Servicetracker viewSerivceDetails(long ServiceID) {
		try {
			return DOI.RetrieveServiceInfo(ServiceID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Servicetracker> viewallRequests(long AccountID) {
		try {
			return DOI.RetrieveService(AccountID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean RaiseServiceRequest(long accountID, String ServiceDesc,
			String ServiceStatus) {
		try {
			if (DOI.retrieveAccount(accountID) != null) {
				Servicetracker service = new Servicetracker();
				service.setAccountId(accountID);
				service.setServiceDescription(ServiceDesc);
				
				service.setServiceStatus(ServiceStatus);
				return DOI.addNewService(service);
			} else {
				System.out.println("Invalid Account number");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addTransactionHistory(long accountID,
			String transactionType, float amount, String transactionDesc) {
		try {
			if (DOI.retrieveAccount(accountID) != null) {
				Transaction transaction = new Transaction();
				transaction.setAccountNo(accountID);
				transaction.setTranamount(amount);
				transaction.setTranDescription(transactionDesc);
				transaction.setTransactiontype(transactionType);
				return DOI.addNewTransaction(transaction);
			} else {
				System.out.println("Acoount number doesnt exist");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean accountDebit(float Balance, long AccountID,
			long PayeeAccountID) {
		try {
			Accountmaster accountinfo = DOI.retrieveAccount(AccountID);
			if (accountinfo == null) {
				System.out.println("Invalid Account number");
				return false;
			} else {
				if (accountinfo.getAccountBalance() < accountinfo
						.getAccountBalance() - Balance) {
					System.out.println("In-sufficient Funds in Account");
					return false;
				} else {
					if (DOI.updateAccountBalance(
							accountinfo.getAccountBalance() - Balance,
							AccountID)) {
						if (addTransactionHistory(
								AccountID,
								"Debit",
								Balance,
								"Amount has been debited to"
										+ Long.toString(PayeeAccountID))) {
							return true;
						} else
							return false;
					} else
						return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean accountDebitSameBank(float Balance, long AccountID,
			long payeeAccountID) {
		try {
			Accountmaster accountinfo = DOI.retrieveAccount(AccountID);
			Accountmaster payeeaccountinfo = DOI.retrieveAccount(payeeAccountID);
			if (accountinfo == null || payeeaccountinfo ==null ) {
				System.out.println("Invalid Payee or Account number");
				return false;
			} else {
				if (accountinfo.getAccountBalance() < accountinfo
						.getAccountBalance() - Balance) {
					System.out.println("In-sufficient Funds in Account");
					return false;
				} else {
					if (DOI.updateAccountBalance(accountinfo.getAccountBalance() - Balance,AccountID)
							&& accountCredit(Balance,payeeAccountID,AccountID)
						) 
					{
						if (addTransactionHistory(AccountID,"Debit",Balance,"Amount has been debited to"+ Long.toString(payeeAccountID))) {
							return true;
						} else
							return false;
					} else
						return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean accountCredit(float Balance, long AccountID,
			long payeeAccountID) {
		try {
			Accountmaster accountinfo = DOI.retrieveAccount(AccountID);
			if (accountinfo == null) {
				System.out.println("Invalid Account number");
				return false;
			} else {
				
					if (DOI.updateAccountBalance(
							accountinfo.getAccountBalance() + Balance,
							AccountID)) {
						if (addTransactionHistory(
								AccountID,
								"Credit",
								Balance,
								"Amount has been Credited by"
										+ Long.toString(payeeAccountID))) {
							return true;
						} else
							return false;
					} else
						return false;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public String lockAccount(long userID) {
		try {
			ArrayList<Useraccount> users = DOI.RetrieveUserAccount(userID);
			if (users == null) {
				System.out.println("Invalid User ID");
				return "User Doesn't Exist";
			} else {
				if(DOI.changeAccountLockStatus("Y", userID))
				{
					return "account Locked";
				}
				else
				{
					return "account couldn't be locked";
				}
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "Exception";
		}
	}

	@Override
	public ArrayList<Useraccount> ViewUserInfo(long userID) {
		try {
			return DOI.RetrieveUserAccount(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addPayee(long AccountID, String NickName, long PayeeAccountID) {
		try {
			Customer user = DOI.retrieveCustomer(AccountID);
			if (user == null) {
				System.out.println("Invalid User ID");
				return false;
			} else {
				Payee payee=new Payee();
				payee.setAccountId(AccountID);
				payee.setNickName(NickName);
				payee.setPayeeAccountId(PayeeAccountID);				
				return DOI.addPayee(payee);
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Payee> viewPayee(long AccountID) {
		try {
			Customer user = DOI.retrieveCustomer(AccountID);
			if (user == null) {
				System.out.println("Invalid User ID");
				return null;
			} else {
				return DOI.RetrievePayee(AccountID);
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean ConfirmPayee(long PayeeAccountID) {
       try {
		return DOI.ConfirmPayee(PayeeAccountID);
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
		
	}

	}

	@Override
	public ArrayList<UserRegistration> retrieveUserRegistrations() {
		try {
			return DOI.retrieveUserRegistrations();
		} catch (SQLException e) {	
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addNewUserRegistration(String accountType,
			String Address, String CustomerName, String Email,
			String LockStatus, String LoginPassword, long MobileNumber,
			String PanCard, String SecretAnswer, String SecretQuestion,
			String TransactionPassword, long userID) {
		return DOI.addNewUserRegistration(accountType, Address, CustomerName, Email, LockStatus, LoginPassword, MobileNumber, PanCard, SecretAnswer, SecretQuestion, TransactionPassword, userID);
	}

	@Override
	public ArrayList<Accountmaster> retrieveAllAccount() {
		
		try {
			return DOI.retrieveAllAccount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean ConfirmUser(long userId) {
		for(UserRegistration user: retrieveUserRegistrations())
		{
			if(user.getUserId() == userId)
			{
				RegisterUser(user.getAddress(), user.getCustomerName(), user.getEmail(), user.getPancard(), user.getAccounttype(), user.getLoginPassword(), user.getSecretQuestion(), user.getSecretAnswer(), user.getTransactionPassword(), user.getUserId(), user.getMobileNumber());		
			}
		}
		return false;
	}

}
