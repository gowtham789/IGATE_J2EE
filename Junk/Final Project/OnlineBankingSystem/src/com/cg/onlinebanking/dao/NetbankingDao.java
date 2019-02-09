package com.cg.onlinebanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.onlinebanking.dto.AccountDTO;
import com.cg.onlinebanking.dto.CustomerDTO;
import com.cg.onlinebanking.dto.PayeeDTO;
import com.cg.onlinebanking.dto.ServiceTrackerDTO;
import com.cg.onlinebanking.dto.TransactionDTO;
import com.cg.onlinebanking.dto.UserDTO;
import com.cg.onlinebanking.exception.OnlineException;



public class NetbankingDao implements InetbankinDao
{

	@Override
	public int changeCustomerAddress(long id,String address) throws OnlineException
	{
		
		InitialContext ic;
		Connection conn=null;
		PreparedStatement ps1=null;
		int count = 0;
		try 
		{
		ic = new InitialContext();
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
		conn=ds.getConnection();
		ps1= conn.prepareStatement("UPDATE customer SET address=? WHERE accountid=?");
		ps1.setString(1, address);
		ps1.setLong(2, id);
		count=ps1.executeUpdate();
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps1.close();
				conn.close();
				
			}
			catch(Exception e)
			{
				
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		
		return count;
	
	}

	@Override
	public int changeCustomerMobile(long accountId, String mobNum)
			throws OnlineException 
	{
		InitialContext ic;
		Connection conn=null;
		PreparedStatement ps1=null;
		int count = 0;
		
		try
		{
		ic = new InitialContext();
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
		conn=ds.getConnection();
		ps1= conn.prepareStatement("UPDATE customer SET mobilenumber=? WHERE accountid=?");
		ps1.setString(1,mobNum);
		ps1.setLong(2, accountId);
		count=ps1.executeUpdate();

		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps1.close();
				conn.close();
				
			}
			catch(Exception e)
			{
				
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		
		return count;
	}


	@Override
	public String getServiceStatus(int serviceId) throws OnlineException 
	{
		
		Connection conn=null;
		PreparedStatement ps=null;
		String serstat=null;
		try 
		{
	
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
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
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		
		return serstat;
	}


	@Override
	public int transferFund(long from, long to, double amt)
			throws OnlineException
	{
		int fid = 0;
		Connection conn=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		PreparedStatement ps4=null;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
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
			
			ps3= conn.prepareStatement("UPDATE accountmaster SET accountbalance=accountbalance+? WHERE accountid=?");
			ps3.setDouble(1,amt);
			ps3.setLong(2,to);
			ps3.executeUpdate();
			
			ps4=conn.prepareStatement("select SEQ_FUNDTRS.currval from dual");
			ResultSet rs=ps4.executeQuery();
			if(rs.next())
			{
				fid=rs.getInt(1);
			}
			
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
			{
				try
				{
					ps1.close();
					ps2.close();
					ps3.close();
					ps4.close();
					conn.close();
					
				}
				catch(SQLException se)
				{
					OnlineException ee=new OnlineException("Connection not closed properly");
					throw ee;
				}
			}
		
		return fid;
	}


	@Override
	public int requestChequeBook(long accId) throws OnlineException 
	{
		
		int servId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
			ps = conn.prepareStatement("INSERT INTO service_tracker"
			+ " VALUES(SEQ_SERVC.nextval,'cheque book requested',?,sysdate,'Opened')");
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
	
	
		} 
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				ps1.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
    return servId;
	}


	@Override
	public ArrayList<TransactionDTO> getTransaction(long accId) throws OnlineException
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ArrayList<TransactionDTO> translist=new ArrayList<TransactionDTO>();
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
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
		} 
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		
		
    return translist;
	}


	@Override
	public ArrayList<AccountDTO> getAllAccounts() throws OnlineException
	{
		ArrayList<AccountDTO> account=new ArrayList<AccountDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
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
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
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
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
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
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		return status;
	}


	@Override
	public boolean isValidAccount(long accId) throws OnlineException 
	{
		
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try 
		{
	
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
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
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		return status;
	}


	@Override
	public ArrayList<TransactionDTO> getAllTransactions()
			throws OnlineException
	{
		
		ArrayList<TransactionDTO> transaction=new ArrayList<TransactionDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
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
		} 
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		
    return transaction;
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
		     cdto.setMobileNumber(rs.getString(6));
		    }
	    
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
	
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(Exception e)
			{
				
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		return cdto;
	}


	@Override
	public AccountDTO getAccountById(long id) throws OnlineException 
	{
		AccountDTO adto=new  AccountDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
			ps = conn.prepareStatement("SELECT * FROM accountmaster WHERE accountid=?");
			ps.setLong(1, id);
			ps.executeUpdate();
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
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
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
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		return adto;
	}


	@Override
	public int insertCustdetails(CustomerDTO p) throws OnlineException 
	{
		int custId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
			ps = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)");
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
		
		} 
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
    return custId;
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
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
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
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
			
		}
		return status;
	}



	@Override
	public boolean isValiduser(String user, String pwd) throws OnlineException 
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select count(*) from onlineuser where userid=? and loginpassword=? ");
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
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
			
		}
		return status;
	}



	@Override
	public ArrayList<Long> getAcctid(String uname) throws OnlineException 
	{
		ArrayList<Long> ids=new ArrayList<Long>();
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select accountid from onlineuser where userid=? order by accountid");
	        ps.setString(1, uname);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
			{
	        	ids.add(rs.getLong(1));	
	        }
	       
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		
		finally
		{
			try 
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
			
		}
		return ids;
	}



	@Override
	public double getBal(long id) throws OnlineException 
	{
		double bal = 0;
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
			
			 ps=conn.prepareStatement("select accountbalance from accountmaster where accountid=?");
		     ps.setLong(1, id);
		     ResultSet rs=ps.executeQuery();
			
		     if(rs.next())
		     {
		    	 bal=rs.getLong(1);
		     }
			
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
			
		}
		
		return bal;
	}
	
	@Override
	public List<ServiceTrackerDTO> getAllServiceDetails() throws OnlineException
	{

		List<ServiceTrackerDTO> call=new ArrayList<ServiceTrackerDTO>();
		
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps = conn.prepareStatement("select * from service_tracker");   
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ServiceTrackerDTO e=new ServiceTrackerDTO();
				e.setServiceId(rs.getInt(1));
				e.setServiceDesc(rs.getString(2));
				e.setAccountId(rs.getInt(3));
				e.setServiceRaisedDate(rs.getDate(4));
				e.setServiceStatus(rs.getString(5));
				call.add(e);
			}
		} 
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		return call;
	}


	@Override
	public String getServiceStatus1(long accNo) throws OnlineException 
	{
	
		Connection conn=null;
		PreparedStatement ps=null;
		String serstat=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps = conn.prepareStatement("SELECT servicestatus FROM service_tracker where accountid=?");
			ps.setLong(1,accNo);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	serstat=rs.getString(1);
		    }
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		
		return serstat;
	}


	@Override
	public int insertRequest(long accId) throws OnlineException 
	{
		int serId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps = conn.prepareStatement("INSERT INTO service_tracker"
						+ " VALUES(seq_servc.nextval,'check book requested',?,sysdate,'open')");
			ps.setLong(1,accId);
			ps.executeUpdate();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT seq_servc.currval FROM dual");
			
			if(rs.next())
			{
				serId=rs.getInt(1);
			}
	
		}
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
    return serId;
	}


	@Override
	public List<ServiceTrackerDTO> getServiceById(long accId) throws OnlineException 
	{
		
		List<ServiceTrackerDTO> call=new ArrayList<ServiceTrackerDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps = conn.prepareStatement("select * from service_tracker where accountid=? and serviceraised_date>sysdate-180 and rownum<20");   
			ps.setLong(1,accId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ServiceTrackerDTO e=new ServiceTrackerDTO();
				e.setServiceId(rs.getInt(1));
				e.setServiceDesc(rs.getString(2));
				e.setAccountId(rs.getInt(3));
				e.setServiceRaisedDate(rs.getDate(4));
				e.setServiceStatus(rs.getString(5));
				call.add(e);
			}
		} 
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		return call;
	}
	
	@Override
	public ArrayList<Long> getPayeeId(long id) throws OnlineException 
	{
		ArrayList<Long> pids=new ArrayList<Long>();
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select payeeaccountid from payee where accountid=?");
	        ps.setLong(1, id);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
			{
	        	pids.add(rs.getLong(1));	
	        }
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try 
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
			
		}
		return pids;
	}



	@Override
	public int insertPayee(PayeeDTO pdto) throws OnlineException 
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int fid=0;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
			ps=conn.prepareStatement("INSERT into payee VALUES(?,?,?)");
			ps.setLong(1, pdto.getAccountId());
			ps.setLong(2, pdto.getPayeeId());
			ps.setString(3, pdto.getNickName());
			fid=ps.executeUpdate();
		}
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try 
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
			
		}
		return fid;
	}



	@Override
	public boolean getTranspass(String tpass,long id) throws OnlineException
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select count(*) from onlineuser where TRANSACTIONPASSWORD=? and accountid=?");
	        ps.setString(1, tpass);
	        ps.setLong(2, id);
	        ResultSet rs=ps.executeQuery();
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
			status=true;
			
			else 
			status=false;
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try 
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
			
		}
		
		return status;
	}
	
	
	@Override
	public ArrayList<TransactionDTO> getTransactionByDate(Date startDate, Date endDate,long id) throws OnlineException
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ArrayList<TransactionDTO> translist=new ArrayList<TransactionDTO>();
		InitialContext ic;
		try
		{
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps = conn.prepareStatement("SELECT * FROM Transactions where  DATEOFTRANSACTION>? and  DATEOFTRANSACTION<?"
					+ " and accountid=?");
			ps.setDate(1, (java.sql.Date) startDate);
			ps.setDate(2, (java.sql.Date) endDate);
			ps.setLong(3, id);
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
		} 
		
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
			
    return translist;
	}
		
	@Override
	public long addNewCustByAdmin(CustomerDTO cust, AccountDTO account,UserDTO user)
			throws OnlineException
	{
		
		Connection conn=null;
		long id = 0;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
			
			ps2=conn.prepareStatement("INSERT into  accountmaster VALUES(SEQ_ACC.NEXTVAL,?,?,sysdate)");
			ps2.setString(1,account.getAccountType());
			ps2.setDouble(2, account.getAccountBalance());
			ps2.executeUpdate();
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT SEQ_ACC.currval FROM dual");
			if(rs.next())
			{
				id=rs.getLong(1);
			
			}
			
			ps1=conn.prepareStatement("INSERT into customer VALUES(?,?,?,?,?,?)");
			ps1.setLong(1, id);
			ps1.setString(2, cust.getCustName());
			ps1.setString(3, cust.getEmail());
			ps1.setString(4,cust.getAddress());
			ps1.setString(5, cust.getPancard());
			ps1.setString(6,cust.getMobileNumber());
			ps1.executeUpdate();
			
			ps3=conn.prepareStatement("INSERT into onlineuser VALUES(?,?,?,?,?,?,?)");
			ps3.setLong(1,id);
			ps3.setString(2,user.getUserId());
			ps3.setString(3, user.getLoginPwd());
			ps3.setString(4, user.getSecretQuest());
			ps3.setString(5, user.getTransactionPwd());
			ps3.setString(6, user.getLockStatus());
			ps3.setString(7, user.getAnswer());
			ps3.executeUpdate();
		}

		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps1.close();
				ps2.close();
				ps3.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		
	}
		return id;
	}

	@Override
	public ArrayList<Long> getAcctids() throws OnlineException
	{
		ArrayList<Long> ids=new ArrayList<Long>();
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select accountid from onlineuser order by accountid");
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
			{
	        	ids.add(rs.getLong(1));	
	        }
	       
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{			
			try 
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
			
		}
		
		return ids;
	}

	@Override
	public boolean isValidPassword(String oldpwd) throws OnlineException 
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		InitialContext ic;
		try
		{
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps=conn.prepareStatement("select count(*) from onlineuser where loginpassword=?");
			ps.setString(1, oldpwd);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
			count=rs.getInt(1);
			}
			
			if (count>0)
				
			status=true;
			
			else
				status=false;
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		return status;
	}

	@Override
	public boolean updatePassword(String oldpwd, String newpwd)
			throws OnlineException 
	{
		int count=0;
		Connection conn=null;
		PreparedStatement ps1=null;
		boolean status=false;
		InitialContext ic;
		try
		{
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps1= conn.prepareStatement("UPDATE onlineuser SET loginpassword=? WHERE loginpassword=?");
			ps1.setString(1,newpwd);
			ps1.setString(2,oldpwd);
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
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps1.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
	return status;
	}

	@Override
	public int insertTransact(TransactionDTO tdto,long id) throws OnlineException 
	{
		int tid=0;
		String desc="Money Transafeered to payee  "+id;
		String type="C";
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();
			ps = conn.prepareStatement("INSERT INTO transactions values"
					+ "(SEQ_TRANSC.nextval,?,sysdate,?,?,?)");
			ps.setString(1, desc);
			ps.setString(2,type);
			ps.setDouble(3, tdto.getTransAmt());
			ps.setLong(4,tdto.getAccountId());
			tid=ps.executeUpdate();
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		return tid;
	}
	
	
	@Override
	public ArrayList<String> getAllQuestions() throws OnlineException
	{
		ArrayList<String> account=new ArrayList<String>();
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
	
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=ds.getConnection();	
			ps = conn.prepareStatement("SELECT unique(SECRETQUESTION) FROM onlineuser");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				account.add(rs.getString(1));
				
			}
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		
		return account;
	}

	@Override
	public boolean isValidAnswer(String question, String answer)
			throws OnlineException 
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
		
			
	        ps=conn.prepareStatement("select count(*) from onlineuser where SECRETQUESTION=? and ANSWER=? ");
	        ps.setString(1, question);
	        ps.setString(2, answer);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
				
			status=true;
			
			else status=false;
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		finally
		{

			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		return status;
	}

	@Override
	public boolean updateForgotPassword(Long accid, String newpwd) throws OnlineException {
		int count=0;
		Connection conn=null;
		PreparedStatement ps1=null;
		boolean status=false;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
			ps1= conn.prepareStatement("UPDATE onlineuser SET loginpassword=? WHERE  ACCOUNTID=?");
			ps1.setString(1,newpwd);
			ps1.setLong(2,accid);

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
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
			finally
			{
				try
				{
					ps1.close();
					conn.close();
					
				}
				catch(SQLException se)
				{
					OnlineException ee=new OnlineException("Connection not closed properly");
					throw ee;
				}
	    
	   
		}
	return status;
	}

	@Override
	public boolean isValidAccountUser(long accId) throws OnlineException {
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;	
		try
		{		
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
		
	        ps=conn.prepareStatement("select count(*) from onlineuser where accountid=? ");
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
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
			}
		}
		return status;
	}

	@Override
	public boolean checkPayee(long fid, long tid) throws OnlineException 
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select count(*) from payee where accountid=? and payeeaccountid=? ");
	        ps.setLong(1, fid);
	        ps.setLong(2, tid);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
				
			status=true;
			
			else status=false;
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table or data does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		return status;
	}

	@Override
	public String checkStatus(String userid) throws OnlineException
	{
		String status = null;
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select lockstatus from onlineuser where userid=? group by lockstatus");
	        ps.setString(1, userid);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			status=rs.getString(1);
			}
	        
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table or data does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		
		return status;
	}

	@Override
	public boolean getCheqStatus(long id) throws OnlineException 
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/ProjectDs");
			conn=(ds).getConnection();
	        ps=conn.prepareStatement("select count(*) from service_tracker where accountid=? and servicestatus='open'");
	        ps.setLong(1, id);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
				
			status=true;
			
			else status=false;
		}
		catch (SQLException e)
		{
			OnlineException ee=new OnlineException("Table or data does not exists or invalid column name");
			throw ee;
		}
		catch(NamingException e)
		{
			OnlineException ee=new OnlineException("Please Check Your Datasource");
			throw ee;
		}
		
		finally
		{
			try
			{
				ps.close();
				conn.close();
				
			}
			catch(SQLException se)
			{
				OnlineException ee=new OnlineException("Connection not closed properly");
				throw ee;
				
			}
		}
		return status;
	}
	
}