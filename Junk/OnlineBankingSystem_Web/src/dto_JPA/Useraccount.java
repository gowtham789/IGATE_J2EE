package dto_JPA;

import java.io.Serializable;


public class Useraccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private long userId;
	private long accountId;
	private String lockstatus;
	private String loginPassword;
	private String secretQuestion;
	private String transactionPassword;
	private String secretAnswer;
	private int LoginAttempts;
	
	public int getLoginAttempts() {
		return LoginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		LoginAttempts = loginAttempts;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	@Override
	public String toString() {
		return "Useraccount [userId=" + userId + ", accountId=" + accountId
				+ ", lockstatus=" + lockstatus + ", loginPassword="
				+ loginPassword + ", secretQuestion=" + secretQuestion
				+ ", transactionPassword=" + transactionPassword + "]";
	}

	public Useraccount() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getLockstatus() {
		return this.lockstatus;
	}

	public void setLockstatus(String lockstatus) {
		this.lockstatus = lockstatus;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSecretQuestion() {
		return this.secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getTransactionPassword() {
		return this.transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

}