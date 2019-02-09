package com.cg.onlinebanking.dto;

import java.util.Date;

public class ServiceTrackerDTO 
{

	//declaring all variables 
	
	private int serviceId;
	private String serviceDesc;
	private long accountId;
	private Date serviceRaisedDate;
	
	//default constructor
	
	public ServiceTrackerDTO() 
	{
		
		super();
		
	}
	
	
	//parameterized constructor
	
	
	public ServiceTrackerDTO(int serviceId, String serviceDesc, int accountId,
			Date serviceRaisedDate, String serviceStatus) 
	{
		super();
		this.serviceId = serviceId;
		this.serviceDesc = serviceDesc;
		this.accountId = accountId;
		this.serviceRaisedDate = serviceRaisedDate;
		this.serviceStatus = serviceStatus;
	}
	
	//getters and setters
	public int getServiceId()
	{
		return serviceId;
	}
	public void setServiceId(int serviceId) 
	{
		this.serviceId = serviceId;
	}
	public String getServiceDesc() 
	{
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc)
	{
		this.serviceDesc = serviceDesc;
	}
	public long getAccountId() 
	{
		return accountId;
	}
	public void setAccountId(long accountId) 
	{
		this.accountId = accountId;
	}
	public Date getServiceRaisedDate()
	{
		return serviceRaisedDate;
	}
	public void setServiceRaisedDate(Date serviceRaisedDate) 
	{
		this.serviceRaisedDate = serviceRaisedDate;
	}
	public String getServiceStatus() 
	{
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) 
	{
		this.serviceStatus = serviceStatus;
	}
	private String serviceStatus ;

	//printing using tostring
	@Override
	public String toString()
	{
		return "ServiceTrackerDTO [serviceId=" + serviceId + ", serviceDesc="
				+ serviceDesc + ", accountId=" + accountId
				+ ", serviceRaisedDate=" + serviceRaisedDate
				+ ", serviceStatus=" + serviceStatus + "]";
	}
	
	
	
}
