package com.cg.onlinebanking.dto;

public class UserDTO 
{
  
	
	//declaring all variables
	
	private long accountId;
	private int userId;
	private String loginPwd;
	private String  secretQuest;
	private String transactionPwd;
	private String lockStatus;
	
	
	//getters and setters
	
	
	public long getAccountId()
	{
		return accountId;
	}
	public void setAccountId(long accountId)
	{
		this.accountId = accountId;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getLoginPwd() 
	{
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) 
	{
		this.loginPwd = loginPwd;
	}
	public String getSecretQuest()
	{
		return secretQuest;
	}
	public void setSecretQuest(String secretQuest) 
	{
		this.secretQuest = secretQuest;
	}
	public String getTransactionPwd() 
	{
		return transactionPwd;
	}
	public void setTransactionPwd(String transactionPwd) 
	{
		this.transactionPwd = transactionPwd;
	}
	public String getLockStatus() 
	{
		return lockStatus;
	}
	public void setLockStatus(String lockStatus)
	{
		this.lockStatus = lockStatus;
	}
	
	
	//parameterized constructor
	
	
	public UserDTO(long accountId, int userId, String loginPwd,
			String secretQuest, String transactionPwd, String lockStatus)
	{
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.loginPwd = loginPwd;
		this.secretQuest = secretQuest;
		this.transactionPwd = transactionPwd;
		this.lockStatus = lockStatus;
	}
	
	
	//default constructor
		public UserDTO()
	{
		super();
		
	}
	
	//printing using tostring
	
	@Override
	public String toString()
	{
		return "UserDTO [accountId=" + accountId + ", userId=" + userId
				+ ", loginPwd=" + loginPwd + ", secretQuest=" + secretQuest
				+ ", transactionPwd=" + transactionPwd + ", lockStatus="
				+ lockStatus + "]";
	}
	
	

	
}
