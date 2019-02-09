package com.cg.bid.dto;

public class BiddingDto {

	private int itemId;
	private String itemName;
	private float itemPrice;
	private String status;
	public BiddingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BiddingDto(int itemId, String itemName, float itemPrice,
			String status) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.status = status;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BiddingDto [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice + ", status=" + status + "]";
	}
	
	
		
}
