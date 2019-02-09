package com.cg.onlinebanking.dto;

public class UserDTO 
{
  
	
	//declaring all variables
	
	private long accountId;
	private String userId;
	private String loginPwd;
	private String secretQuest;
	private String transactionPwd;
	private String lockStatus;
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
		// TODO Auto-generated constructor stub
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
