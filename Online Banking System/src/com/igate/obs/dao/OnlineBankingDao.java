package com.igate.obs.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.obs.dto.AccountDTO;
import com.igate.obs.dto.CustomerDTO;
import com.igate.obs.dto.PayeeDTO;
import com.igate.obs.dto.ServiceTrackerDTO;
import com.igate.obs.dto.TransactionDTO;
import com.igate.obs.dto.UserDTO;
import com.igate.obs.exception.OnlineException;
import com.igate.obs.mappers.Accountmapperid;
import com.igate.obs.mappers.CustomerMapper;
import com.igate.obs.mappers.PayeeMapper;
import com.igate.obs.mappers.QuestionMapper;
import com.igate.obs.mappers.ServiceMapper;
import com.igate.obs.mappers.TransactMapper;

@Repository("odao")
public class OnlineBankingDao extends JdbcDaoSupport implements IOnlineBanking
{
	
	@Autowired
	private DataSource MyDataSource;
	
	
	@PostConstruct
	private void initialize() 
	{
	setDataSource(MyDataSource);
	}
	
	/***********************************************************
	 * Method Name: isValiduser
	 * Return type:boolean
	 * Parameters:String,String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public boolean isValiduser(String user, String pwd) throws OnlineException 
	{
		boolean status;
		String sql="select count(*) from onlineuser where userid=? and loginpassword=? ";
		Object[] params=new Object[]{user,pwd};
		int c=getJdbcTemplate().queryForObject(sql,Integer.class,params);
		if(c>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		
		return status;
	}

	/***********************************************************
	 * Method Name: isValidAdmin
	 * Return type:boolean 
	 * Parameters: String,String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean isValidAdmin(String user, String pwd) throws OnlineException 
	{
		boolean status = false;
		String sql="select count(*) from bankadmin where username=? and password=? ";
		Object[] params=new Object[]{user,pwd};
		int c=getJdbcTemplate().queryForObject(sql,Integer.class,params);
		if(c>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
	}

	/***********************************************************
	 * Method Name: getAllAcctids
	 * Return type: ArrayList<Long> 
	 * Parameters: String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public ArrayList<Long> getAllAcctids(String userid) throws OnlineException
	{
		ArrayList<Long> adto=(ArrayList<Long>) getJdbcTemplate().query("select accountid from onlineuser where userid=? order by accountid",new Accountmapperid(),userid);
		
		return adto;
	}
	
	/***********************************************************
	 * Method Name: getBal
	 * Return type: double
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public double getBal(long id) throws OnlineException
	{
		double balance=getJdbcTemplate().queryForObject("select accountbalance from accountmaster where accountid=?",Double.class,id);
		
		return balance;
	}

	/***********************************************************
	 * Method Name: changeCustomerAddress
	 * Return type:int 
	 * Parameters:long,String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public int changeCustomerAddress(long accId, String address)
			throws OnlineException 
	{
		String sql="UPDATE customer SET address=? WHERE accountid=?";
		Object[] params=new Object[]{address,accId};
		return getJdbcTemplate().update(sql,params);
	}
	
	/***********************************************************
	 * Method Name: getCustomerById
	 * Return type:object of CustomerDTO
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public CustomerDTO getCustomerById(long accId) throws OnlineException 
	{
		String sql="SELECT * FROM Customer WHERE accountid=?";
		Object[] params=new Object[]{accId};
		return (CustomerDTO) getJdbcTemplate().queryForObject(sql,new CustomerMapper(),params);
		 
	}
	
	/***********************************************************
	 * Method Name: changeCustomerMobile
	 * Return type:int 
	 * Parameters: long,String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public int changeCustomerMobile(long accountId, String mobNum)
			throws OnlineException 
	{
		String sql="UPDATE customer SET mobilenumber=? WHERE accountid=?";
		Object[] params=new Object[]{mobNum,accountId};
		return getJdbcTemplate().update(sql,params);
	}
	
	/***********************************************************
	 * Method Name: transferFund
	 * Return type: int 
	 * Parameters: long,long,double
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public int transferFund(long from, long to, double amt)
			throws OnlineException
	{
		int fundid=getJdbcTemplate().queryForObject("select SEQ_FUNDTRS.nextval from dual",Integer.class);
		int insid=getJdbcTemplate().update("INSERT into FUND_TRANSFER VALUES(?,"
				+ "?,?,SYSDATE,?)",fundid,from,to,amt);
	
		if(insid>0)
		{
			getJdbcTemplate().update("UPDATE accountmaster SET accountbalance=accountbalance-? WHERE accountid=?",
				amt,from);
		
			getJdbcTemplate().update("UPDATE accountmaster SET accountbalance=accountbalance+? WHERE accountid=?",
				amt,to);
		}
		return fundid;
	}

	/***********************************************************
	 * Method Name: getTranspass
	 * Return type: boolean
	 * Parameters: String,long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean getTranspass(String tpass, long id) throws OnlineException 
	{
		boolean status=false;
		String sql="select count(*) from onlineuser where TRANSACTIONPASSWORD=? and accountid=?";
		Object[] params=new Object[]{tpass,id};
		int sid=getJdbcTemplate().queryForObject(sql,Integer.class,params);
		if(sid>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
	}

	/***********************************************************
	 * Method Name: insertTransact
	 * Return type:int 
	 * Parameters: object of TransactionDTO,long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public int insertTransact(TransactionDTO tdto, long id)
			throws OnlineException 
	{
		int transid=getJdbcTemplate().queryForObject("select SEQ_TRANSC.nextval from dual",Integer.class);
		String desc="Money Transferred to payee  "+id;
		String sql="INSERT INTO transactions values(?,?,sysdate,?,?,?)";
		Object[] params=new Object[]{transid,desc,tdto.getTransType(),tdto.getTransAmt(),tdto.getAccountId()};
		getJdbcTemplate().update(sql,params);
		return transid;
	}

	/***********************************************************
	 * Method Name: insertTransacred
	 * Return type:int 
	 * Parameters: object of TransactionDTO,long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public int insertTransacred(TransactionDTO tdto, long id)
			throws OnlineException 
	{
		String desc="Money Transferred from account "+id;
		String sql="INSERT INTO transactions values(?,?,sysdate,?,?,?)";
		Object[] params=new Object[]{tdto.getTransactionId(),desc,tdto.getTransType(),tdto.getTransAmt(),tdto.getAccountId()};
		return getJdbcTemplate().update(sql,params);
		
	}

	/***********************************************************
	 * Method Name: getPayeeId
	 * Return type: ArrayList<Long>
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public ArrayList<Long> getPayeeId(long id) throws OnlineException 
	{
		ArrayList<Long> accids=(ArrayList<Long>) getJdbcTemplate().query("select payeeaccountid from payee where accountid=? order by accountid",new PayeeMapper(),id);
		return accids;
	}

	/***********************************************************
	 * Method Name: insertPayee
	 * Return type:int 
	 * Parameters:object of PayeeDTO
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public int insertPayee(PayeeDTO pdto) throws OnlineException 
	{
		String sql="INSERT into payee VALUES(?,?,?)";
		Object[] params=new Object[]{pdto.getAccountId(),pdto.getPayeeId(),pdto.getNickName()};
		return getJdbcTemplate().update(sql,params);
	}

	/***********************************************************
	 * Method Name: checkPayee 
	 * Return type: boolean 
	 * Parameters: long,long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public boolean checkPayee(long fid, long tid) throws OnlineException 
	{
		boolean status=false;
		String sql="select count(*) from payee where accountid=? and payeeaccountid=?";
		Object[] params=new Object[]{fid,tid};
		int id=getJdbcTemplate().queryForObject(sql,Integer.class,params);
		if(id>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
	}

	/***********************************************************
	 * Method Name: isValidAccount
	 * Return type: boolean 
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean isValidAccount(long accId) throws OnlineException 
	{
		
		boolean status=false;
		String sql="select count(*) from accountmaster where accountid=?";
		Object[] params=new Object[]{accId};
		int id=getJdbcTemplate().queryForObject(sql,Integer.class,params);
		if(id>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
	}
	
	/***********************************************************
	 * Method Name: isValidPassword
	 * Return type: boolean
	 * Parameters:String,String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public boolean isValidPassword(String oldpwd, String uname)
			throws OnlineException 
	{
		String sql="select count(*) from onlineuser where loginpassword=? and userid=?";
		Object[] params=new Object[]{oldpwd,uname};
		int update=getJdbcTemplate().queryForObject(sql,Integer.class,params);
		if(update>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: updatePassword
	 * Return type: boolean
	 * Parameters:String,String,String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean updatePassword(String oldpwd, String newpwd, String uname)
			throws OnlineException 
	{
		String sql="UPDATE onlineuser SET loginpassword=? WHERE loginpassword=? and userid=?";
		Object[] params=new Object[]{newpwd,oldpwd,uname};
		int update=getJdbcTemplate().update(sql,params);
		if(update>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: getCheqStatus
	 * Return type: boolean
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public boolean getCheqStatus(long id) throws OnlineException
	{
		
		String sql="select count(*) from service_tracker where accountid=? and servicestatus='open'";
		Object[] params=new Object[]{id};
		int update=getJdbcTemplate().update(sql,params);
		if(update>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: insertRequest
	 * Return type:int 
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public int insertRequest(long accId) throws OnlineException 
	{
		int cid=getJdbcTemplate().queryForObject("select seq_servc.nextval from dual",Integer.class);
		String sql="INSERT INTO service_tracker VALUES(?,'check book requested',?,sysdate,'open')";
		Object[] params=new Object[]{cid,accId};
		int update=getJdbcTemplate().update(sql,params);
		return cid;
	}

	/***********************************************************
	 * Method Name: getServiceById
	 * Return type: ArrayList<ServiceTrackerDTO>  
	 * Parameters:long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public ArrayList<ServiceTrackerDTO> getServiceById(long accId)
			throws OnlineException
	{
		String sql="select * from service_tracker where accountid=? and serviceraised_date>sysdate-180 and rownum<20 order by accountid";
		Object[] params=new Object[]{accId};
		ArrayList<ServiceTrackerDTO> sdto=(ArrayList<ServiceTrackerDTO>) getJdbcTemplate().query(sql,new ServiceMapper(),params);
		return sdto;
	}

	/***********************************************************
	 * Method Name: getTransaction
	 * Return type: ArrayList<TransactionDTO> 
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public ArrayList<TransactionDTO> getTransaction(long accId)
			throws OnlineException
	{
		String sql="SELECT * FROM Transactions where accountid=? order by TRANSACTIONID";
		Object[] params=new Object[]{accId};
		ArrayList<TransactionDTO> trans=(ArrayList<TransactionDTO>) getJdbcTemplate().query(sql,new TransactMapper(),params);
		return trans;
	}

	/***********************************************************
	 * Method Name: getTransactionByDate
	 * Return type: ArrayList<TransactionDTO> 
	 * Parameters:Date,Date,long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public ArrayList<TransactionDTO> getTransactionByDate(Date startDate,
			Date endDate, long id) throws OnlineException 
	{
		String sql="SELECT * FROM Transactions where  DATEOFTRANSACTION>=? and  TO_CHAR(DATEOFTRANSACTION,'DD-MON-YY')<=? and accountid=? order by TRANSACTIONID";
		Object[] params=new Object[]{startDate,endDate,id};
		ArrayList<TransactionDTO> translist=(ArrayList<TransactionDTO>) getJdbcTemplate().query(sql,new TransactMapper(),params);
		return translist;
	}

	/***********************************************************
	 * Method Name: getAllTransactions
	 * Return type: ArrayList<TransactionDTO>
	 * Parameters: None
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public ArrayList<TransactionDTO> getAllTransactions()
			throws OnlineException 
	{
		ArrayList<TransactionDTO> translist=(ArrayList<TransactionDTO>) getJdbcTemplate().query("SELECT * FROM Transactions",new TransactMapper());
		return translist;
	}

	/***********************************************************
	 * Method Name: getAllAccounts
	 * Return type:ArrayList<Long> 
	 * Parameters: None
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public ArrayList<Long> getAllAccounts() throws OnlineException 
	{
		ArrayList<Long> adto=(ArrayList<Long>) getJdbcTemplate().query("select accountid from accountmaster order by accountid",new Accountmapperid());
		return adto;
	}

	/***********************************************************
	 * Method Name: getAllQuestions
	 * Return type: ArrayList<String>
	 * Parameters: None
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public ArrayList<String> getAllQuestions() throws OnlineException 
	{
		ArrayList<String> ques=(ArrayList<String>) getJdbcTemplate().query("SELECT unique(SECRETQUESTION) FROM onlineuser",new QuestionMapper());
		return ques;
	}

	/***********************************************************
	 * Method Name: isValidAnswer
	 * Return type: boolean
	 * Parameters: String,String,long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean isValidAnswer(String question, String answer,long id)
			throws OnlineException 
	{
		String sql="select count(*) from onlineuser where SECRETQUESTION=? and ANSWER=? and accountid=?";
		Object[] params=new Object[]{question,answer,id};
		int count=getJdbcTemplate().queryForObject(sql,Integer.class,params);
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: updateForgotPassword
	 * Return type:boolean
	 * Parameters:String,String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public boolean updateForgotPassword(String userid, String newpwd)
			throws OnlineException 
	{
		Object[] params=new Object[]{newpwd,userid};
		int count=getJdbcTemplate().update("UPDATE onlineuser SET loginpassword=? WHERE  userid=?",params);
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: isValidAccountUser
	 * Return type: boolean
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean isValidAccountUser(long accId) throws OnlineException 
	{
		int count=getJdbcTemplate().queryForObject("select count(*) from onlineuser where accountid=?",Integer.class,accId);
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: getUserid
	 * Return type: String
	 * Parameters: long
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public String getUserid(long id) throws OnlineException 
	{
		String uname=getJdbcTemplate().queryForObject("SELECT USERID FROM ONLINEUSER WHERE ACCOUNTID=?",String.class,id);
		return uname;
	}

	/***********************************************************
	 * Method Name: isValidloginuser
	 * Return type: boolean 
	 * Parameters: String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public boolean isValidloginuser(String userid) throws OnlineException 
	{
		int count=getJdbcTemplate().queryForObject("select count(*) from onlineuser where userid=?",Integer.class,userid);
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	/***********************************************************
	 * Method Name: addNewCustByAdmin
	 * Return type: long 
	 * Parameters: object of CustomerDTO,AccountDTO,UserDTO
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public long addNewCustByAdmin(CustomerDTO cust, AccountDTO account,
			UserDTO user) throws OnlineException 
	{
		long id=getJdbcTemplate().queryForObject("select SEQ_ACC.NEXTVAL from dual",Long.class);
		if(id>0)
		{
			Object[] params=new Object[]{id,account.getAccountType(),account.getAccountBalance()};
			getJdbcTemplate().update("INSERT into  accountmaster VALUES(?,?,?,sysdate)",params);
			
			Object[] onlineparams=new Object[]{id,user.getUserId(),user.getLoginPwd(),
					  user.getSecretQuest(),user.getTransactionPwd(),
					  user.getAnswer()};
			getJdbcTemplate().update("INSERT into onlineuser VALUES(?,?,?,?,?,'U',?)",onlineparams);

			Object[] custparams=new Object[]{id,cust.getCustName(),cust.getEmail(),
											 cust.getAddress(),cust.getPancard(),
											 cust.getMobileNumber()};
			getJdbcTemplate().update("INSERT into customer VALUES(?,?,?,?,?,?)",custparams);
			
			
			return id;
		}
		else
		{
			return 0;
		}
		
	}

	/***********************************************************
	 * Method Name: checkStatus
	 * Return type: String 
	 * Parameters:	String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/

	@Override
	public String checkStatus(String userid) throws OnlineException 
	{
		String status=getJdbcTemplate().queryForObject("select lockstatus from onlineuser where userid=? group by lockstatus", String.class,userid);
		return status;
	}

	/***********************************************************
	 * Method Name: checkEmail
	 * Return type:boolean
	 * Parameters:String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	@Override
	public boolean checkEmail(String email) throws OnlineException 
	{
		int count=getJdbcTemplate().queryForObject("select count(email) from customer where email=?",Integer.class,email);
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: checkMobilenum
	 * Return type:boolean
	 * Parameters:String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean checkMobilenum(String mnum) throws OnlineException 
	{
		
		int count=getJdbcTemplate().queryForObject("select count(pancard) from customer where mobilenumber=?",Integer.class,mnum);
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/***********************************************************
	 * Method Name: isValiduser
	 * Return type:boolean
	 * Parameters:String
	 * Package Name: com.igate.obs.dao
	 * @author J2EE2-Group4
	 ***********************************************************/
	
	@Override
	public boolean checkPancard(String pcard) throws OnlineException
	{
		
		int count=getJdbcTemplate().queryForObject("select count(pancard) from customer where pancard=?",Integer.class,pcard);
		if(count>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
