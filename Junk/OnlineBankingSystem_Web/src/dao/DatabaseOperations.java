package dao;

import dto_JPA.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseOperations implements DatabaseOperationsInterface {
	static Connection conn = null;
	static {
		System.out.println("Establishing Database Connection");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driverload Success");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@NDAOracle.igatecorp.com:1521:ORCL11g", "lab08trg11",
					"lab08oracle");
			System.out.println("Connection Sucessful");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Useraccount> RetrieveUserAccount(long userid)
			throws SQLException {
	//	conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		String sql = "SELECT * FROM Useraccount where user_Id= ? ";
		statement = conn.prepareStatement(sql);
		statement.setLong(1, userid);
		statement1 = conn.prepareStatement(sql);
		statement1.setLong(1, userid);
		ResultSet userInfo = statement.executeQuery();
		ResultSet UserIDCheck = statement1.executeQuery();
		ArrayList<Useraccount> users = null;
		if (UserIDCheck.next() == true) {
			users = new ArrayList<Useraccount>();
			while (userInfo.next()) {
				Useraccount user = new Useraccount();
				user.setAccountId(userInfo.getLong("account_id"));
				user.setLockstatus(userInfo.getString("lockstatus"));
				user.setLoginPassword(userInfo.getString("login_Password"));
				user.setSecretQuestion(userInfo.getString("Secret_Question"));
				user.setTransactionPassword(userInfo
						.getString("Transaction_Password"));
				user.setSecretAnswer(userInfo.getString("Secret_Answer"));
				user.setUserId(userid);
				user.setLoginAttempts(userInfo.getInt("Login_Attempts"));
				users.add(user);
			}
		}
		userInfo.close();
		UserIDCheck.close();
		statement.close();
		statement1.close();
		return users;
	}

	@Override
	public boolean addUserAccount(Useraccount user) {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql;
		sql = "Select Account_ID from Useraccount where Account_ID=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, user.getAccountId());
			if (statement.executeQuery().next() == true) {
				System.out.println("Account_ID already linked to a user");
				statement.close();
				return false;
			} else {
				sql = "insert into Useraccount values(?,?,?,?,?,?,?,?)";
				statement = conn.prepareStatement(sql);
				statement.setLong(1, user.getAccountId());
				statement.setLong(2, user.getUserId());
				statement.setString(3, user.getLoginPassword());
				statement.setString(4, user.getSecretQuestion());
				statement.setString(5, user.getTransactionPassword());
				statement.setString(6, user.getLockstatus());
				statement.setString(7, user.getSecretAnswer());
				statement.setInt(8, user.getLoginAttempts());
				System.out.println(statement.executeUpdate());
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public ArrayList<Payee> RetrievePayee(long accountID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		String sql = "SELECT * FROM payee where Account_ID= ? ";
		statement = conn.prepareStatement(sql);
		statement.setLong(1, accountID);
		statement1 = conn.prepareStatement(sql);
		statement1.setLong(1, accountID);
		ResultSet payeeInfo = statement.executeQuery();
		ResultSet payeeCheck = statement1.executeQuery();
		ArrayList<Payee> payees = null;
		if (payeeCheck.next() == true) {
			payees = new ArrayList<Payee>();
			while (payeeInfo.next()) {
				Payee payee = new Payee();
				payee.setAccountId(payeeInfo.getLong("account_id"));
				payee.setNickName(payeeInfo.getString("nick_name"));
				payee.setPayeeAccountId(payeeInfo.getLong("payee_account_id"));
				payee.setStatus(payeeInfo.getString("status"));
				payees.add(payee);
			}
		}
		payeeInfo.close();
		payeeCheck.close();
		statement.close();
		statement1.close();
		return payees;
	}

	@Override
	public boolean addPayee(Payee payee) {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		
		String sql;
		sql = "Select Account_ID from Customer where Account_ID=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, payee.getAccountId());
			if (statement.executeQuery().next() == true) {
				statement.setLong(1, payee.getPayeeAccountId());
				if(statement.executeQuery().next() == true)
				{
				System.out.println("Account_ID Exists .. Adding Payee");
				sql = "insert into payee values(?,?,?,?)";
				statement = conn.prepareStatement(sql);
				statement.setLong(1, payee.getAccountId());
				statement.setLong(2, payee.getPayeeAccountId());
				statement.setString(3, payee.getNickName());
				statement.setString(4,"PENDING");
				System.out.println(statement.executeUpdate());
				return true;
				}
				else
				{
					return false;
				}
			} else {
				System.out.println("Invalid Account number ... Can't add a payee to a invalid Account Number");
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Servicetracker RetrieveServiceInfo(long ServiceID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		Servicetracker service = null;
		String sql;
		sql = "Select * from ServiceTracker where service_ID=?";
		statement = conn.prepareStatement(sql);
		statement1 = conn.prepareStatement(sql);
		statement.setLong(1, ServiceID);
		statement1.setLong(1, ServiceID);
		ResultSet serviceCheck = statement1.executeQuery();
		if (serviceCheck.next() == true) {
			service = new Servicetracker();
			ResultSet serviceinfo = statement.executeQuery();
			while (serviceinfo.next()) {
				service.setAccountId(serviceinfo.getLong("Account_ID"));
				service.setServiceDescription(serviceinfo
						.getString("service_description"));
				service.setServiceId(serviceinfo.getLong("service_id"));
				service.setServiceRaisedDate(serviceinfo
						.getDate("service_raised_date"));
				service.setServiceStatus(serviceinfo
						.getString("service_status"));
			}
			return service;
		} else {
			System.out
					.println("Service details for the Given service ID Doesnt Exist");
			return null;
		}
	}

	@Override
	public boolean addNewService(Servicetracker service) {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql;
		sql = "Select Account_ID from Customer where Account_ID=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, service.getAccountId());
			if (statement.executeQuery().next() == true) {
				System.out.println("Account_ID Exists .. Generating Service request");
				sql = "insert into servicetracker"
						+ " (service_description,account_id,service_status)"
						+ "values(?,?,?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, service.getServiceDescription());
				statement.setLong(2, service.getAccountId());
				statement.setString(3, service.getServiceStatus());
				System.out.println(statement.executeUpdate());
				return true;
			} else {
				System.out.println("Invalid Account number ... Can't raise a service request");
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Transaction> RetrieveAllTransaction(long AccountID) throws SQLException {
		
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		String sql = "SELECT * FROM Transactions where Account_no= ? ";
		statement = conn.prepareStatement(sql);
		statement.setLong(1, AccountID);
		statement1 = conn.prepareStatement(sql);
		statement1.setLong(1, AccountID);
		ResultSet transactionInfo = statement.executeQuery();
		ResultSet transactionCheck = statement1.executeQuery();
		ArrayList<Transaction> Transactions = null;
		if (transactionCheck.next() == true) {
			Transactions = new ArrayList<Transaction>();
			while (transactionInfo.next()) {
				Transaction transaction = new Transaction();
				transaction.setAccountNo(transactionInfo.getLong("account_no"));
				transaction.setDateoftransaction(transactionInfo
						.getDate("DATEOFTRANSACTION"));
				transaction.setTranamount(transactionInfo
						.getFloat("TRANAMOUNT"));
				transaction.setTranDescription(transactionInfo
						.getString("TRAN_DESCRIPTION"));
				transaction.setTransactionId(transactionInfo
						.getLong("Transaction_ID"));
				transaction.setTransactiontype(transactionInfo
						.getString("TransactionType"));
				Transactions.add(transaction);
			}
		}
		transactionInfo.close();
		transactionCheck.close();
		statement.close();
		statement1.close();
		return Transactions;
	}
	@Override
	public boolean addNewTransaction(Transaction transaction) {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql;
		sql = "Select Account_ID from Customer where Account_ID=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, transaction.getAccountNo());
			if (statement.executeQuery().next() == true) {
				System.out.println("Account_ID Exists .. Generating transaction request");
				sql = "insert into transactions"
						+ " (tran_description,transactiontype,tranamount,account_no)"
						+ "values(?,?,?,?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, transaction.getTranDescription());
				statement.setLong(4, transaction.getAccountNo());
				statement.setString(2,transaction.getTransactiontype());
				statement.setFloat(3,transaction.getTranamount());
				System.out.println(statement.executeUpdate());
				return true;
			} else {
				System.out.println("Invalid Account number ... Can't raise a complete transaction request");
				statement.close();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Transaction> RetrieveAllTransaction(long AccountID,
		
			int NumOfTransation) throws SQLException {
		
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		int transCountTracker = 0;
		String sql = "SELECT * FROM Transactions where Account_no= ? ";
		statement = conn.prepareStatement(sql);
		statement.setLong(1, AccountID);
		statement1 = conn.prepareStatement(sql);
		statement1.setLong(1, AccountID);
		statement2 = conn.prepareStatement(sql);
		statement2.setLong(1, AccountID);
		ResultSet transactionSizeCheck = statement.executeQuery();
		int size=0;
		while(transactionSizeCheck.next() == true)
		{
			size++;
		}
		size=size-10;
		ResultSet transactionInfo = statement.executeQuery();
		ResultSet transactionCheck = statement1.executeQuery();
		ArrayList<Transaction> Transactions = null;
		if (transactionCheck.next() == true) {
			Transactions = new ArrayList<Transaction>();
			
			while (transactionInfo.next() ) {
				if(transCountTracker > size)
				{
				Transaction transaction = new Transaction();
				transaction.setAccountNo(transactionInfo.getLong("account_no"));
				transaction.setDateoftransaction(transactionInfo
						.getDate("DATEOFTRANSACTION"));
				transaction.setTranamount(transactionInfo
						.getFloat("TRANAMOUNT"));
				transaction.setTranDescription(transactionInfo
						.getString("TRAN_DESCRIPTION"));
				transaction.setTransactionId(transactionInfo
						.getLong("Transaction_ID"));
				transaction.setTransactiontype(transactionInfo
						.getString("TransactionType"));
				Transactions.add(transaction);
				}
				transCountTracker++;
			}
		}
		transactionInfo.close();
		transactionCheck.close();
		statement.close();
		statement1.close();
		return Transactions;
	}

	@Override
	public ArrayList<Transaction> RetrieveAllTransaction(long AccountID,
			Date Start, Date End) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		String sql = "SELECT * FROM Transactions where DATEOFTRANSACTION Between ? AND ? ";
		statement = conn.prepareStatement(sql);
		System.out.println(Start);
		System.out.println(End);
		System.out.println(new java.sql.Date(Start.getTime()));
		System.out.println(new java.sql.Date(End.getTime()));
		statement.setDate(1, new java.sql.Date(Start.getTime()));
		statement.setDate(2, new java.sql.Date(End.getTime()));
		statement1 = conn.prepareStatement(sql);
		statement1.setDate(1, new java.sql.Date(Start.getTime()));
		statement1.setDate(2, new java.sql.Date(End.getTime()));
		ResultSet transactionInfo = statement.executeQuery();
		ResultSet transactionCheck = statement1.executeQuery();
		ArrayList<Transaction> Transactions = null;
		if (transactionCheck.next() == true) {
			System.out.println("Hello");
			Transactions = new ArrayList<Transaction>();
			while (transactionInfo.next()) {
				Transaction transaction = new Transaction();
				transaction.setAccountNo(transactionInfo.getLong("account_no"));
				transaction.setDateoftransaction(transactionInfo
						.getDate("DATEOFTRANSACTION"));
				transaction.setTranamount(transactionInfo
						.getFloat("TRANAMOUNT"));
				transaction.setTranDescription(transactionInfo
						.getString("TRAN_DESCRIPTION"));
				transaction.setTransactionId(transactionInfo
						.getLong("Transaction_ID"));
				transaction.setTransactiontype(transactionInfo
						.getString("TransactionType"));
				Transactions.add(transaction);
			}
		}
		transactionInfo.close();
		transactionCheck.close();
		statement.close();
		statement1.close();
		return Transactions;
	}

	@Override
	public boolean addAccountMaster(Accountmaster account) {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql;
		sql = "Select Account_ID from AccountMaster where Account_ID=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, account.getAccountId());
			if (statement.executeQuery().next() == true) {
				System.out
						.println("Account_ID already Present in Account Master \n Linking the user to account");
				statement.close();
				return true;
			} else {
				System.out.println("Fuck yaa");
				sql = "insert into AccountMaster values(?,?,?,?)";
				statement = conn.prepareStatement(sql);
				statement.setLong(1, account.getAccountId());
				statement.setString(2, account.getAccounttype());
				statement.setFloat(3, account.getAccountBalance());
				statement.setDate(4, new java.sql.Date(account.getOpenDate()
						.getTime()));
				System.out.println(statement.executeUpdate());
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Accountmaster retrieveAccount(long AccountID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		Accountmaster account = null;
		String sql;
		sql = "Select * from AccountMaster where Account_ID=?";
		statement = conn.prepareStatement(sql);
		statement1 = conn.prepareStatement(sql);
		statement.setLong(1, AccountID);
		statement1.setLong(1, AccountID);
		ResultSet accountCheck = statement1.executeQuery();
		if (accountCheck.next() == true) {
			account = new Accountmaster();
			ResultSet accountinfo = statement.executeQuery();
			while (accountinfo.next()) {
				account.setAccountId(accountinfo.getLong("Account_ID"));
				account.setAccounttype(accountinfo.getString("accounttype"));
				account.setAccountBalance(accountinfo
						.getFloat("account_balance"));
				account.setOpenDate(accountinfo.getDate("open_date"));
			}
			return account;
		} else {
			System.out
					.println("Acount details for the Given Account ID Doesnt Exist");
			return null;
		}
	}

	@Override
	public boolean addCustomer(Customer customer) {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql;
		sql = "Select Account_ID from Customer where Account_ID=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, customer.getAccountId());
			if (statement.executeQuery().next() == true) {
				System.out.println("Account_ID already Exists");
				statement.close();
				return false;
			} else {
				sql = "insert into Customer(customer_name,email,address,pancard,mobile_number) values(?,?,?,?,?)";
				statement = conn.prepareStatement(sql);		
				statement.setString(1, customer.getCustomerName());
				statement.setString(2, customer.getEmail());
				statement.setString(3, customer.getAddress());
				statement.setString(4, customer.getPancard());
				statement.setLong(5, customer.getMobileNumber());
				System.out.println(statement.executeUpdate());
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer retrieveCustomer(long AccountID) throws SQLException {
		//conn= DBUtil.getConnection();
		System.out.println(AccountID);
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		Customer customer = null;
		String sql;
		sql = "Select * from Customer where Account_ID=?";
		statement = conn.prepareStatement(sql);
		statement1 = conn.prepareStatement(sql);
		statement.setLong(1, AccountID);
		statement1.setLong(1, AccountID);
		ResultSet customerCheck = statement1.executeQuery();
		System.out.println(customerCheck);
		if (customerCheck.next() == true) {
			customer = new Customer();
			ResultSet customerinfo = statement.executeQuery();
			while (customerinfo.next()) {
				customer.setAccountId(customerinfo.getLong("Account_ID"));
				customer.setAddress(customerinfo.getString("Address"));
				customer.setCustomerName(customerinfo
						.getString("customer_name"));
				customer.setEmail(customerinfo.getString("email"));
				customer.setPancard(customerinfo.getString("pancard"));
				customer.setMobileNumber(customerinfo.getLong("mobile_number"));
			}
			return customer;
		} else {
			System.out
					.println("Customer details for the Given Account ID Doesnt Exist");
			return null;
		}
	}

	@Override
	public boolean updateCutomerInfo(String email, long MobileNumber,
			String address, long accountID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "update Customer set email=?,address=?,mobile_number=? where account_id=?";
		statement = conn.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, address);
		statement.setLong(3, MobileNumber);
		statement.setLong(4, accountID);
		if (statement.executeUpdate() >= 1)
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<Servicetracker> RetrieveService(long AccountID)
			throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		ArrayList<Servicetracker> services = null;
		String sql;
		sql = "Select * from ServiceTracker where Account_ID=?";
		statement = conn.prepareStatement(sql);
		statement1 = conn.prepareStatement(sql);
		statement.setLong(1, AccountID);
		statement1.setLong(1, AccountID);
		ResultSet serviceCheck = statement1.executeQuery();
		if (serviceCheck.next() == true) {
			services = new ArrayList<Servicetracker>();
			ResultSet serviceinfo = statement.executeQuery();
			while (serviceinfo.next()) {
				Servicetracker service = new Servicetracker();
				service.setAccountId(serviceinfo.getLong("Account_ID"));
				service.setServiceDescription(serviceinfo
						.getString("service_description"));
				service.setServiceId(serviceinfo.getLong("service_id"));
				service.setServiceRaisedDate(serviceinfo
						.getDate("service_raised_date"));
				service.setServiceStatus(serviceinfo
						.getString("service_status"));
				services.add(service);
			}
			return services;
		} else {
			System.out
					.println("Service details for the Given Account ID Doesnt Exist");
			return null;
		}
	}

	@Override
	public boolean updateAccountBalance(float Updatedbalance,long AccountID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "update accountmaster set account_balance=? where account_id=?";
		statement = conn.prepareStatement(sql);
		statement.setFloat(1, Updatedbalance);
		statement.setLong(2, AccountID);
		if (statement.executeUpdate() >= 1)
		{
			statement.close();
			return true;
		}
		else
		{
			statement.close();
			return false;
		}	
		}

	@Override
	public boolean changeAccountLockStatus(String status,long userID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "update UserAccount set lockstatus=? where user_id=?";
		statement = conn.prepareStatement(sql);
		statement.setString(1, status);
		statement.setLong(2, userID);
		if (statement.executeUpdate() >= 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean changeLoginAtempts(int loginAttempts , long userID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "update UserAccount set login_attempts=? where user_id=?";
		statement = conn.prepareStatement(sql);
		statement.setInt(1, loginAttempts);
		statement.setLong(2, userID);
		if (statement.executeUpdate() >= 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean ChangePassword(String password, long userID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "update UserAccount set login_password=? where user_id=?";
		statement = conn.prepareStatement(sql);
		statement.setString(1, password);
		statement.setLong(2, userID);
		if (statement.executeUpdate() >= 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean ConfirmPayee(long payeeAccountID) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql = "update payee set status='COMPLETE' where Payee_Account_ID=?";
		statement = conn.prepareStatement(sql);
		statement.setLong(1,payeeAccountID);
		if (statement.executeUpdate() >= 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean addNewUserRegistration(String accountType,
			String Address, String CustomerName, String Email,
			String LockStatus, String LoginPassword, long MobileNumber,
			String PanCard, String SecretAnswer, String SecretQuestion,
			String TransactionPassword, long userID) {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		String sql;
		
		try {
			
				sql = "insert into User_Registration values(?,?,?,?,?,?,?,?,?,?,?,?)";
				statement = conn.prepareStatement(sql);
			
				statement.setLong(1,userID);
				statement.setString(2,LoginPassword);
				statement.setString(3,SecretQuestion);
				statement.setString(4,TransactionPassword);
				statement.setString(5,LockStatus);
				statement.setString(6,SecretAnswer);
				statement.setString(7,accountType);
				statement.setString(8,CustomerName);
				statement.setString(9,Email);
				statement.setString(10,Address);
				statement.setString(11,PanCard);
				statement.setLong(12,MobileNumber);
				System.out.println(statement.executeUpdate());
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<UserRegistration> retrieveUserRegistrations() throws SQLException {
		//conn= DBUtil.getConnection();
		Statement statement = null;
		String sql = "SELECT * FROM user_registration";
		statement = conn.createStatement();
		ResultSet userRegistrationInfo = statement.executeQuery(sql);
		ArrayList<UserRegistration> users = null;		
		users = new ArrayList<UserRegistration>();
			while (userRegistrationInfo.next()) {
				UserRegistration user = new UserRegistration();
				
				user.setAccounttype(userRegistrationInfo.getString("account_type"));
				user.setAddress(userRegistrationInfo.getString("address"));
				user.setCustomerName(userRegistrationInfo.getString("customer_name"));
				user.setEmail(userRegistrationInfo.getString("email"));
				user.setLockstatus("N");
				user.setLoginPassword(userRegistrationInfo.getString("login_password"));
				user.setMobileNumber(userRegistrationInfo.getLong("mobile_number"));
				user.setPancard(userRegistrationInfo.getString("pancard"));
				user.setSecretAnswer(userRegistrationInfo.getString("secret_answer"));
				user.setSecretQuestion(userRegistrationInfo.getString("secret_question"));
				user.setTransactionPassword(userRegistrationInfo.getString("transaction_password"));
				user.setUserId(userRegistrationInfo.getLong("user_id"));
				users.add(user);
			
		}
			userRegistrationInfo.close();
		
		statement.close();
		
		return users;
	}

	@Override
	public ArrayList<Accountmaster> retrieveAllAccount() throws SQLException {
		//conn= DBUtil.getConnection();
		Statement statement = null;
		ArrayList<Accountmaster> accounts = null;
		String sql;
		sql = "Select * from AccountMaster";
		statement = conn.createStatement();
		
			accounts = new ArrayList<Accountmaster>();
			ResultSet accountinfo = statement.executeQuery(sql);
			while (accountinfo.next()) {
				Accountmaster account= new Accountmaster();
				account.setAccountId(accountinfo.getLong("Account_ID"));
				account.setAccounttype(accountinfo.getString("accounttype"));
				account.setAccountBalance(accountinfo
						.getFloat("account_balance"));
				account.setOpenDate(accountinfo.getDate("open_date"));
				accounts.add(account);
		} 
			return accounts;
	}

	@Override
	public ArrayList<Customer> retrieveAllCustomers() throws SQLException {
		//conn= DBUtil.getConnection();
		Statement statement = null;
		ArrayList<Customer> customers = null;
		String sql;
		sql = "Select * from customer";
		statement = conn.createStatement();
		
			customers = new ArrayList<Customer>();
			ResultSet accountinfo = statement.executeQuery(sql);
			while (accountinfo.next()) {
				Customer customer= new Customer();
				customer.setAccountId(accountinfo.getLong("Account_ID"));
				
				customers.add(customer);
		} 
			return customers;
	}

	@Override
	public boolean deleteRegistration(long UserId) throws SQLException {
		//conn= DBUtil.getConnection();
		PreparedStatement statement = null;
		
		String sql;
		sql = "delete from user_registration where user_id =?";
		
		statement = conn.prepareStatement(sql);
		statement.setLong(1, UserId);
		if(statement.executeUpdate() >=1)
					return true;
		else
			return false;
	}

}
