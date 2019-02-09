package com.cg.mps.dto;

import java.sql.Date;

public class PurchaseDTO 
{
   private int purchaseId;
   private String cname;
   private String mailId;
   private String phnNo;
   private int mobileId;
   private Date purchaseDate;
   
   
   

public PurchaseDTO(int purchaseId, String cname, String mailId, String phnNo,
		int mobileId, Date purchaseDate) {
	super();
	this.purchaseId = purchaseId;
	this.cname = cname;
	this.mailId = mailId;
	this.phnNo = phnNo;
	this.mobileId = mobileId;
	this.purchaseDate = purchaseDate;
}



public PurchaseDTO() {
	super();
	// TODO Auto-generated constructor stub
}




public int getMobileId() {
	return mobileId;
}



public void setMobileId(int mobileId) {
	this.mobileId = mobileId;
}



public int getPurchaseId() {
	return purchaseId;
}
public void setPurchaseId(int purchaseId) {
	this.purchaseId = purchaseId;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public String getPhnNo() {
	return phnNo;
}
public void setPhnNo(String phnNo) {
	this.phnNo = phnNo;
}
public Date getPurchaseDate() {
	return purchaseDate;
}
public void setPurchaseDate(Date purchaseDate) {
	this.purchaseDate = purchaseDate;
}



@Override
public String toString() {
	return "PurchaseDTO [purchaseId=" + purchaseId + ", cname=" + cname
			+ ", mailId=" + mailId + ", phnNo=" + phnNo + ", mobileId="
			+ mobileId + ", purchaseDate=" + purchaseDate + "]";
}








}


