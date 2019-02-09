package com.igate.obs.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class UserDTO 
{
  
	
	//declaring all variables
	
	private long accountId;
	
	@NotEmpty(message="Please Enter User Id")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "UserId is alphanumeric only")
	private String userId;
	
	@NotEmpty(message="Please Enter password")
	@Size(min=3,max=15,message="Password Should have 3 to 15 characters only")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Password is alphanumeric only")
	private String loginPwd;
	
	@NotEmpty(message="Please Slecet a Secret Question")
	private String secretQuest;
	
	@NotEmpty(message="Please Enter Tranasaction Password")
	@Size(min=3,max=15,message="Password Should have 3 to 15 characters only")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Password is alphanumeric only")
	private String transactionPwd;
	
	private String lockStatus;
	
	@NotEmpty(message="Please Enter Answer for the Secret Question")
	private String answer;
	
	public UserDTO(long accountId, String userId, String loginPwd,
			String secretQuest, String transactionPwd, String lockStatus,
			String answer) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.loginPwd = loginPwd;
		this.secretQuest = secretQuest;
		this.transactionPwd = transactionPwd;
		this.lockStatus = lockStatus;
		this.answer = answer;
	}
	public UserDTO() {
		super();
		
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getSecretQuest() {
		return secretQuest;
	}
	public void setSecretQuest(String secretQuest) {
		this.secretQuest = secretQuest;
	}
	public String getTransactionPwd() {
		return transactionPwd;
	}
	public void setTransactionPwd(String transactionPwd) {
		this.transactionPwd = transactionPwd;
	}
	public String getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "UserDTO [accountId=" + accountId + ", userId=" + userId
				+ ", loginPwd=" + loginPwd + ", secretQuest=" + secretQuest
				+ ", transactionPwd=" + transactionPwd + ", lockStatus="
				+ lockStatus + ", answer=" + answer + "]";
	}

	

	
}
