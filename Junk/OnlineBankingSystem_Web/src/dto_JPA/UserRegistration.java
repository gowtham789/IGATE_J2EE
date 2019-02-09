package dto_JPA;

public class UserRegistration {
	private long userId;
	private long accountId;
	private String lockstatus;
	private String loginPassword;
	private String secretQuestion;
	private String transactionPassword;
	private String secretAnswer;
	private String accounttype;
	private String address;
	private String customerName;
	private String email;
	private String pancard;
    private long MobileNumber;
    
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getLockstatus() {
		return lockstatus;
	}
	public void setLockstatus(String lockstatus) {
		this.lockstatus = lockstatus;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "UserRegistration [userId=" + userId + ", accountId="
				+ accountId + ", lockstatus=" + lockstatus + ", loginPassword="
				+ loginPassword + ", secretQuestion=" + secretQuestion
				+ ", transactionPassword=" + transactionPassword
				+ ", secretAnswer=" + secretAnswer + ", accounttype="
				+ accounttype + ", address=" + address + ", customerName="
				+ customerName + ", email=" + email + ", pancard=" + pancard
				+ ", MobileNumber=" + MobileNumber + "]";
	}
	
}
