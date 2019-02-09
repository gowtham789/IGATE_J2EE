package com.igate.obs.dto;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TransactionDTO 
{
	//declaring variables
	
	private int transactionId;
	private String transDesc;
	private Date date;
	private String transType;
	private double transAmt;
	private long accountId;
	
	
	public TransactionDTO() {
		super();
		
	}
	
	public TransactionDTO(int transactionId, String transDesc, Date date,
			String transType, double transAmt, long accountId) {
		super();
		this.transactionId = transactionId;
		this.transDesc = transDesc;
		this.date = date;
		this.transType = transType;
		this.transAmt = transAmt;
		this.accountId = accountId;
	}

	
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId
				+ ", transDesc=" + transDesc + ", date=" + date
				+ ", transType=" + transType + ", transAmt=" + transAmt
				+ ", accountId=" + accountId + "]";
	}

	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransDesc() {
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
	public double getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(double transAmt) {
		this.transAmt = transAmt;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	
	

	
	

	

}