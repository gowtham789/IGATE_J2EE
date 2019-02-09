package dto_JPA;

import java.io.Serializable;


public class Payee implements Serializable {
	private static final long serialVersionUID = 1L;
	private long accountId;
	private String nickName;
	private long payeeAccountId;
	private String Status;

	public Payee() {
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public long getPayeeAccountId() {
		return this.payeeAccountId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public void setPayeeAccountId(long payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}

}