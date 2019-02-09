package dto_JPA;

import java.io.Serializable;
import java.util.Date;



public class Accountmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	private long accountId;
	private float accountBalance;
	private String accounttype;
	private Date openDate;

	@Override
	public String toString() {
		return "Accountmaster [accountId=" + accountId + ", accountBalance="
				+ accountBalance + ", accounttype=" + accounttype
				+ ", openDate=" + openDate + "]";
	}

	public Accountmaster() {
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public float getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

}