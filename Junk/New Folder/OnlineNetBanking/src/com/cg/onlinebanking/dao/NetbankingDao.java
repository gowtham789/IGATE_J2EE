package com.cg.onlinebanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.exception.OnlineException;

public class NetbankingDao implements InetbankinDao
{
	
	@Override
	public int changeCustomerAddress(long accountId, String address) throws OnlineException
	{
		
		InitialContext ic;
		Connection conn=null;
		PreparedStatement ps1=null;
		int count = 0;
		
		try {
			ic = new InitialContext();
		
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
		conn=ds.getConnection();
		ps1= conn.prepareStatement("UPDATE customer SET address=? WHERE accountid=?");
		ps1.setString(1, address);
		ps1.setLong(2, accountId);
		count=ps1.executeUpdate();

		}


		catch (SQLException|NamingException e)
		{
			throw new OnlineException(e.getMessage());
		} 
		
		finally
		{
			try
			{
				conn.close();
				ps1.close();
			}
			catch(Exception e)
			{
				
				throw new OnlineException(e.getMessage());
			}
		}
		
		return count;
	
	}
	
	@Override
	public CustomerDTO getCustomerById(long accId) throws OnlineException
	{
		CustomerDTO cdto=new CustomerDTO();
		InitialContext ic;
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
		ic = new InitialContext();
		
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
		conn=ds.getConnection();
		ps = conn.prepareStatement("SELECT * FROM Customer WHERE accountid=?");
		ps.setLong(1, accId);
		ps.executeUpdate();
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	
	     cdto.setAccountId(rs.getLong(1));
	     cdto.setCustName(rs.getString(2));
	     cdto.setEmail(rs.getString(3));
	     cdto.setAddress(rs.getString(4));
	     cdto.setPancard(rs.getString(5));
	     cdto.setMobilenumber(rs.getString(6));
		
	    }
	    
		}
	catch (SQLException|NamingException e)
	{
		throw new OnlineException(e.getMessage());
	} 
	
	finally
	{
		try
		{
			conn.close();
			ps.close();
		}
		catch(Exception e)
		{
			
			throw new OnlineException(e.getMessage());
		}
	}
		System.out.println(cdto);
		return cdto;
		
		
	}

	@Override
	public int changeCustomerMobile(long accountId, String mobNum)
			throws OnlineException {
		InitialContext ic;
		Connection conn=null;
		PreparedStatement ps1=null;
		int count = 0;
		
		try {
			ic = new InitialContext();
		
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
		conn=ds.getConnection();
		System.out.println("hi");
		ps1= conn.prepareStatement("UPDATE customer SET mobilenumber=? WHERE accountid=?");
		ps1.setString(1,mobNum);
		ps1.setLong(2, accountId);
		count=ps1.executeUpdate();
		System.out.println("hello");

		}


		catch (SQLException|NamingException e)
		{
			throw new OnlineException(e.getMessage());
		} 
		
		finally
		{
			try
			{
				conn.close();
				ps1.close();
			}
			catch(Exception e)
			{
				
				throw new OnlineException(e.getMessage());
			}
		}
		
		return count;
	}

}



	/* @Override
	public String getServiceStatus(int serviceId) throws OnlineException 
	{
		
		Connection conn=null;
		PreparedStatement ps=null;
		String serstat=null;
		try 
		{
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT servicestatus FROM service_tracker where serviceid=?");
		
		ps.setInt(1,serviceId);
	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	serstat=rs.getString(1);
	    }
		}
		catch (SQLException e) 
		{
		
			throw new OnlineException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new OnlineException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		
		return serstat;
	}


	@Override
	public boolean transferFund(long from, long to, double amt)
			throws OnlineException
	{
		
		
		boolean status=false;
		int count;
		Connection conn=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		try
		{

			conn = DbConnection.getConnection();
			
			ps1=conn.prepareStatement("INSERT into FUND_TRANSFER VALUES(SEQ_FUNDTRS.NEXTVAL,"
					+ "?,?,SYSDATE,?)");
			ps1.setLong(1,from);
			ps1.setLong(2,to);
			ps1.setDouble(3, amt);
			ps1.executeUpdate();
			ps2= conn.prepareStatement("UPDATE accountmaster SET accountbalance=accountbalance-? WHERE accountid=?");
			ps2.setDouble(1,amt);
			ps2.setLong(2,from);
			ps2.executeUpdate();
			
			ps3= conn.prepareStatement("UPDATE accountmaster SET accountbalance=accountbalance+? WHERE accountid=(select accountid from payee where payeeaccountid=?)");
			ps3.setDouble(1,amt);
			ps3.setLong(2,to);
			ps3.executeUpdate();
			
			count=ps3.executeUpdate();
			
			System.out.println(count);
			if(count>0)
				status=true;
			else
				status=false;
	
		}


			catch (SQLException e) 
			{
		    	
				throw new OnlineException(e.getMessage());
			}
			finally
			{
				try
				{
					conn.close();
					ps1.close();
				}
				catch(SQLException se)
				{
					throw new OnlineException("Get "+se.getMessage());
					//Throw User defined exception here
				}
	    
	    		
	}
		
		
		
		
		return status;
	}


	@Override
	public int requestChequeBook(long accId) throws OnlineException 
	{
		
		logger.info("Inserting service tracker details ...."+accId);
		
		
		int servId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("INSERT INTO service_tracker"
				+ " VALUES(SEQ_SERVC.nextval,'cheque book requested',?,sysdate,'processing')");
	ps.setLong(1, accId);
	
	
	ps.executeUpdate();
	
	ps1=conn.prepareStatement("SELECT seq_servc.currval FROM dual");
	ResultSet rs=ps1.executeQuery();
	
	if(rs.next())
	{
		servId=rs.getInt(1);
	}
	
	if(servId>0)
	{
		servId=1;
	}
	else
	{
		servId=0;
	}
	logger.info("Inserted Successfully ...."+servId);
	
	} catch (SQLException e) {
		logger.error("Error while Inserting ...."+e.getMessage());
			throw new OnlineException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new OnlineException(se.getMessage());
				//Throw User defined exception here
			}
		}
    return servId;
	}


	@Override
	public ArrayList<TransactionDTO> getTransaction(long accId) throws OnlineException
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		ArrayList<TransactionDTO> translist=new ArrayList<TransactionDTO>();
		try {
			
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM Transactions where accountid=?");
		ps.setLong(1, accId);
	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	TransactionDTO trans=new TransactionDTO();
	    trans.setTransactionId(rs.getInt(1));
	    trans.setTransDesc(rs.getString(2));
	    trans.setDate(rs.getDate(3));
	    trans.setTransType(rs.getString(4));
	    trans.setTransAmt(rs.getInt(5));
	    trans.setAccountId((rs.getLong(6)));
	    translist.add(trans);
	    }
	} catch (SQLException e) {
		logger.error("Error while fetching ...."+e.getMessage());
			throw new OnlineException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new OnlineException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		
		 return translist;
	}


	@Override
	public ArrayList<AccountDTO> getAllAccounts() throws OnlineException {
		
       
		ArrayList<AccountDTO> account=new ArrayList<AccountDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM AccountMaster");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	AccountDTO acc=new AccountDTO();
	    	acc.setAccountId(rs.getLong(1));
	    	acc.setAccountType(rs.getString(2));
	    	acc.setAccountBalance(rs.getDouble(3));
	    	acc.setOpenDate(rs.getDate(4));
	    	account.add(acc);
	    }
		}
		catch (SQLException e) 
		{
		
			throw new OnlineException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new OnlineException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		 return account;
	}


	@Override
	public boolean isValidAdmin(String user,String pwd) throws OnlineException {
		
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		
		
		try
		{
			conn = DbConnection.getConnection();
	        ps=conn.prepareStatement("select count(*) from bankadmin where username=? and password=? ");
	        ps.setString(1, user);
	        ps.setString(2, pwd);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
				
			status=true;
			
			else status=false;
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
		
		finally
		{
			
		}
		return status;
	}


	@Override
	public boolean isValidAccount(long accId) throws OnlineException {
		
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		
		
		try
		{
			conn = DbConnection.getConnection();
	        ps=conn.prepareStatement("select count(*) from accountmaster where accountid=? ");
	        ps.setLong(1, accId);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
				
			status=true;
			
			else status=false;
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
		
		finally
		{
			
		}
		return status;
	}


	@Override
	public ArrayList<TransactionDTO> getAllTransactions()
			throws OnlineException {
		
		logger.info("Fetching all Transaction details");
		
		ArrayList<TransactionDTO> transaction=new ArrayList<TransactionDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM Transactions");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	TransactionDTO trans=new TransactionDTO();
	    trans.setTransactionId(rs.getInt(1));
	    trans.setTransDesc(rs.getString(2));
	    trans.setDate(rs.getDate(3));
	    trans.setTransType(rs.getString(4));
	    trans.setTransAmt(rs.getInt(5));
	    trans.setAccountId((rs.getLong(6)));
	    	transaction.add(trans);
	    }
	} catch (SQLException e) {
		logger.error("Error while fetching ...."+e.getMessage());
			throw new OnlineException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new OnlineException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		logger.info(transaction.size()+" transaction(s) fetched");
		logger.info("----Transaction  Details---");
		logger.info(transaction);
    return transaction;
	}


	

	@Override
	public AccountDTO getAccountById(long id) throws OnlineException 
	{
		AccountDTO adto=new  AccountDTO();
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		System.out.println("in method");
		try
		{
	
		conn = DbConnection.getConnection();
		System.out.println(conn);
		ps = conn.prepareStatement("SELECT * FROM accountmaster WHERE accountid=?");
		ps.setLong(1, id);
		count=ps.executeUpdate();
		System.out.println(count);
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	
	     adto.setAccountId(rs.getLong(1));
	     adto.setAccountType(rs.getString(2));
	     adto.setAccountBalance(rs.getDouble(3));
	     adto.setOpenDate(rs.getDate(4));
		
	    }
	    
		}
		catch (SQLException e) 
		{
			throw new OnlineException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new OnlineException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		return adto;
	}


	@Override
	public int insertCustdetails(CustomerDTO p) throws OnlineException {

		logger.info("Inserting Customer details ...."+p);
		
		
		int custId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("INSERT INTO customer"
				+ " VALUES(?,?,?,?,?)");
	ps.setLong(1,p.getAccountId());
	ps.setString(2, p.getCustName());
	ps.setString(3, p.getEmail());
	ps.setString(4,p.getAddress());
	ps.setString(5, p.getPancard());
	
	
	ps.executeUpdate();
	
	ps1=conn.prepareStatement("SELECT count(*) FROM customer where pancard=?");
	ps1.setString(1, p.getPancard());
	ResultSet rs=ps1.executeQuery();
	
	if(rs.next())
	{
		custId=rs.getInt(1);
	}
	
	if(custId>0)
	{
		custId=1;
	}
	else
	{
		custId=0;
	}
	logger.info("Inserted Successfully ...."+custId);
	
	} catch (SQLException e) {
		logger.error("Error while Inserting ...."+e.getMessage());
			throw new OnlineException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new OnlineException(se.getMessage());
				//Throw User defined exception here
			}
		}
    return custId;
	}


	@Override
	public boolean updatePassword(String userId, String oldpwd, String newpwd) throws OnlineException 
	{
		int count=0;
		Connection conn=null;
		PreparedStatement ps1=null;
		boolean status=false;
		try
		{
			
			conn = DbConnection.getConnection();
			ps1= conn.prepareStatement("UPDATE onlineuser SET loginpassword=? WHERE userid=? and loginpassword=?");
			ps1.setString(1,newpwd);
			ps1.setString(2,userId);
			ps1.setString(3,oldpwd);
			count=ps1.executeUpdate();
			
			if(count>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
		}
		catch (SQLException e) 
			{
		    	logger.error("Error while updating ...."+e.getMessage());
				throw new OnlineException(e.getMessage());
			}
			finally
			{
				try
				{
					conn.close();
					ps1.close();
				}
				catch(SQLException se)
				{
					throw new OnlineException("Get "+se.getMessage());
					//Throw User defined exception here
				}
	    
	    logger.info(" Updation Successfull for id ...."+userId);
		}
	return status;
	}


	@Override
	public boolean isValidPayee(long accId) throws OnlineException 
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		
		
		try
		{
			conn = DbConnection.getConnection();
	        ps=conn.prepareStatement("select count(*) from payee where PAYEEACCOUNTID=?");
	        ps.setLong(1, accId);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
				
			status=true;
			
			else status=false;
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
		
		finally
		{
			
		}
		return status;
	}
}*/