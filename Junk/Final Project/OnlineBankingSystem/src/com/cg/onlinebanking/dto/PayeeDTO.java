package com.cg.onlinebanking.dto;

public class PayeeDTO 
{
	
 //declaring all the variables
	
 private long accountId;
 private long payeeId; 
 private String nickName;
 
 
 //default constructor
 
 public PayeeDTO() 
 {
		super();
		
 }
 
 
 //parameterized constructor
 

public PayeeDTO(long accountId, long payeeId, String nickName) 
 {
	super();
	this.accountId = accountId;
	this.payeeId = payeeId;
	this.nickName = nickName;
}

	//getters and setters
	public long getAccountId() 
	{
	return accountId;
	}

	public void setAccountId(long accountId)
	{
		this.accountId = accountId;
	}


	
	public long getPayeeId() {
		return payeeId;
	}



	public void setPayeeId(long payeeId)
	{
		this.payeeId = payeeId;
	}



	public String getNickName()
	{
		return nickName;
	}



	public void setNickName(String nickName) 
	{
		this.nickName = nickName;
	}


//printing using to string

	@Override
	public String toString() {
		return "PayeeDTO [accountId=" + accountId + ", payeeId=" + payeeId
				+ ", nickName=" + nickName + "]";
	}
	 
 
 
}
