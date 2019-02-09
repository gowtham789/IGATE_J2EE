package dto_JPA;

import java.io.Serializable;



public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long accountId;
	private String address;
	private String customerName;
	private String email;
	private String pancard;
    private long MobileNumber;
    
	public long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Customer [accountId=" + accountId + ", address=" + address
				+ ", customerName=" + customerName + ", email=" + email
				+ ", pancard=" + pancard + "]";
	}

	public Customer() {
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPancard() {
		return this.pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

}