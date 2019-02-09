package com.cg.onlinebanking.dto;

public class CustomerDTO
{
	
	//declaring all variables
	
	private long accountId;
	private String custName;
	private String email;
	private String address;
	private String pancard;
	private String mobileNumber;
	
	
	//default constructor
	
	public CustomerDTO()
	{
		super();
		
	}



	//getters and setters
	public long getAccountId() {
		return accountId;
	}


	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPancard() {
		return pancard;
	}


	public void setPancard(String pancard) {
		this.pancard = pancard;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	//parameterized constructor
	public CustomerDTO(long accountId, String custName, String email,
			String address, String pancard, String mobileNumber) {
		super();
		this.accountId = accountId;
		this.custName = custName;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.mobileNumber = mobileNumber;
	}


	@Override
	public String toString() {
		return "CustomerDTO [accountId=" + accountId + ", custName=" + custName
				+ ", email=" + email + ", address=" + address + ", pancard="
				+ pancard + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
}
