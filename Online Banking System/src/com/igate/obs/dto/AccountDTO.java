package com.igate.obs.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class AccountDTO
{
	
	//declaring all variables
	
	private long accountId;
	
	@NotEmpty(message="Please Select Account Type")
	private String accountType; 

	private double accountBalance;
	private Date openDate ;
	
	
	//getters and setters
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
	//default constructor
	
	public AccountDTO() 
	{
		super();
		
	}
	
	//parameterized constructor
	
	
	public AccountDTO(long accountId, String accountType, double accountBalance,
			Date openDate) 
	{
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
	}
	
	
	//printing using tostring
	
	@Override
	public String toString() 
	{
		return "Account [accountId=" + accountId + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance
				+ ", openDate=" + openDate + "]";
	}

	
	
}
