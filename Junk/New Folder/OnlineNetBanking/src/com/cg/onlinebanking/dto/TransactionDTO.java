package com.cg.onlinebanking.dto;

import java.util.Date;

public class TransactionDTO 
{
	//declaring variables
	
	private int transactionId;
	private String transDesc;
	private Date date;
	private String transType;
	private int transAmt;
	private long accountId;
	
	
	
	//getters and setters
	
	public int getTransactionId() 
	{
		return transactionId;
	}
	public void setTransactionId(int transactionId)
	{
		this.transactionId = transactionId;
	}
	public String getTransDesc() 
	{
		return transDesc;
	}
	public void setTransDesc(String transDesc) {
		this.transDesc = transDesc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public int getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(int transAmt) {
		this.transAmt = transAmt;
	}
	
	//parameterized constructor
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public TransactionDTO(int transactionId, String transDesc, Date date,
			String transType, int transAmt, long accountId) {
		super();
		this.transactionId = transactionId;
		this.transDesc = transDesc;
		this.date = date;
		this.transType = transType;
		this.transAmt = transAmt;
		this.accountId = accountId;
	}
	
	//default constructor
	
	public TransactionDTO()
	{
		super();
		
	}
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId
				+ ", transDesc=" + transDesc + ", date=" + date
				+ ", transType=" + transType + ", transAmt=" + transAmt
				+ ", accountId=" + accountId + "]";
	}

	

}
