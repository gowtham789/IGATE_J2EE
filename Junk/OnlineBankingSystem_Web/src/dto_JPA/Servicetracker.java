package dto_JPA;

import java.io.Serializable;
import java.util.Date;


public class Servicetracker implements Serializable {
	private static final long serialVersionUID = 1L;
	private long serviceId;
	private long accountId;
	private String serviceDescription;
	private Date serviceRaisedDate;
	private String serviceStatus;

	@Override
	public String toString() {
		return "Servicetracker [serviceId=" + serviceId + ", accountId="
				+ accountId + ", serviceDescription=" + serviceDescription
				+ ", serviceRaisedDate=" + serviceRaisedDate
				+ ", serviceStatus=" + serviceStatus + "]";
	}

	public Servicetracker() {
	}

	public long getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getServiceDescription() {
		return this.serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Date getServiceRaisedDate() {
		return this.serviceRaisedDate;
	}

	public void setServiceRaisedDate(Date serviceRaisedDate) {
		this.serviceRaisedDate = serviceRaisedDate;
	}

	public String getServiceStatus() {
		return this.serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}