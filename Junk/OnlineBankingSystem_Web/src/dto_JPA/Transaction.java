package dto_JPA;

import java.io.Serializable;
import java.util.Date;



public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private long transactionId;
	private long accountNo;
	private Date dateoftransaction;
	private String tranDescription;
	private float tranamount;
	private String transactiontype;

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNo="
				+ accountNo + ", dateoftransaction=" + dateoftransaction
				+ ", tranDescription=" + tranDescription + ", tranamount="
				+ tranamount + ", transactiontype=" + transactiontype + "]";
	}

	public Transaction() {
	}

	public long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public Date getDateoftransaction() {
		return this.dateoftransaction;
	}

	public void setDateoftransaction(Date dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}

	public String getTranDescription() {
		return this.tranDescription;
	}

	public void setTranDescription(String tranDescription) {
		this.tranDescription = tranDescription;
	}

	public float getTranamount() {
		return this.tranamount;
	}

	public void setTranamount(float tranamount) {
		this.tranamount = tranamount;
	}

	public String getTransactiontype() {
		return this.transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

}