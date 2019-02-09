package com.cg.bid.dto;

public class BidDTO 
{
	private int itemid;
	private String itemname;
	private float itemprice;
	private String status;
	public BidDTO(int itemid, String itemname, float itemprice, String status) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.status = status;
	}
	public BidDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public float getItemprice() {
		return itemprice;
	}
	public void setItemprice(float itemprice) {
		this.itemprice = itemprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BidDTO [itemid=" + itemid + ", itemname=" + itemname
				+ ", itemprice=" + itemprice + ", status=" + status + "]";
	}
	
	
	
	
	
}
