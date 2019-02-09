package com.cg.mps.dto;

public class MobileDTO
{
	private int mobId;
	private String name;
	private float price;
	private String quantity;

	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


public int getMobId() {
		return mobId;
	}

	public MobileDTO(int mobId, String name, float price, String quantity
			) {
		super();
		this.mobId = mobId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}

	@Override
	public String toString() {
		return "MobileDTO [mobId=" + mobId + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

	public void setMobId(int mobId) {
		this.mobId = mobId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public MobileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
