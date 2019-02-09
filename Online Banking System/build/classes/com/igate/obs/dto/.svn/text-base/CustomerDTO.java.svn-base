package com.igate.obs.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTO
{
	
	//declaring all variables
	
	private long accountId;
	
	@NotEmpty(message="Please Enter Customer Name")
	@Pattern(regexp = "[A-Z][a-zA-Z]+", message = "Name should Start with capital letter")
	private String custName;
	
	@NotEmpty(message="Please Enter Customer Email")
	@Pattern(regexp = "[A-Za-z0-9]+@[a-zA-Z]+.com", message = "Email should be in the format(abc@xyz.com)")
	private String email;
	
	@NotEmpty(message="Please Enter Customer Address")
	@Pattern(regexp = "[a-zA-Z0-9.,/-]+", message = "All special characters are not allowed in address")
	private String address;
	
	@Size(min=10,max=10,message="Pan Card should have 10 characters of alphanumeric only")
	@NotEmpty(message="Please Enter Pancard Details")
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Pancard is aplanumeric")
	private String pancard;
	
	@Size(min=10,max=10,message="Phone Number Should Accept Only 10 digits")
	@Pattern(regexp = "[7|8|9][0-9]+", message = "Phone Number should contain only 10 digits and should start with 7 or 8 or 9")
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
