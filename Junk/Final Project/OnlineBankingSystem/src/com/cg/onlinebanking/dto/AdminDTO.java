package com.cg.onlinebanking.dto;

public class AdminDTO
{
	
	private String adId;
	private String adPwd;
	
	
	//getters and setters
	
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public String getAdPwd() {
		return adPwd;
	}
	public void setAdPwd(String adPwd) {
		this.adPwd = adPwd;
	}
	
	
	//parameterized constructor
	
	public AdminDTO(String adId, String adPwd) {
		super();
		this.adId = adId;
		this.adPwd = adPwd;
	}
	
	//default constructor
	public AdminDTO() 
	{
		super();
		
	}
	
	//printing using tostring
	@Override
	public String toString() 
	{
		return "AdminDTO [adId=" + adId + ", adPwd=" + adPwd + "]";
	}
	
	
	
	
	
}
