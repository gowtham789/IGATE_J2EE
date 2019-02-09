package dto_JPA;

import java.io.Serializable;
import java.util.Date;


public class Fundtransfer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long fundtransferId;
	private long accountId;
	private Date dateOfTransfer;
	private long payeeAccountId;
	private float transferAmount;

	public Fundtransfer() {
	}

	public long getFundtransferId() {
		return this.fundtransferId;
	}

	public void setFundtransferId(long fundtransferId) {
		this.fundtransferId = fundtransferId;
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Date getDateOfTransfer() {
		return this.dateOfTransfer;
	}

	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	public long getPayeeAccountId() {
		return this.payeeAccountId;
	}

	public void setPayeeAccountId(long payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}

	public float getTransferAmount() {
		return this.transferAmount;
	}

	public void setTransferAmount(float transferAmount) {
		this.transferAmount = transferAmount;
	}

}