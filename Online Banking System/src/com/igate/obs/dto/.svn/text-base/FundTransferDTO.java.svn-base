package com.igate.obs.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FundTransferDTO 
{
	//declaring all the variables
	
	private int fundtransferId;
	private long accountId; 
	private	int	payeeId;
	private	Date dateofTransfer;
	private	int	transferAmount;
	
	//default constructor
	
	public FundTransferDTO() 
	{
		super();
		
	}
	
	
	
	//parameterized constructor
	
	public FundTransferDTO(int fundtransferId, long accountId, int payeeId,
			Date dateofTransfer, int transferAmount) 
	{
		super();
		this.fundtransferId = fundtransferId;
		this.accountId = accountId;
		this.payeeId = payeeId;
		this.dateofTransfer = dateofTransfer;
		this.transferAmount = transferAmount;
	}

	//getters and setters
	public int getFundtransferId() {
		return fundtransferId;
	}
	
	public void setFundtransferId(int fundtransferId) {
		this.fundtransferId = fundtransferId;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public int getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}
	public Date getDateofTransfer() {
		return dateofTransfer;
	}
	public void setDateofTransfer(Date dateofTransfer) {
		this.dateofTransfer = dateofTransfer;
	}
	public int getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}


	//printing using tostring
	
	@Override
	public String toString() {
		return "FundTransferDTO [fundtransferId=" + fundtransferId
				+ ", accountId=" + accountId + ", payeeId=" + payeeId
				+ ", dateofTransfer=" + dateofTransfer + ", transferAmount="
				+ transferAmount + "]";
	}

	
	
	
	
}
