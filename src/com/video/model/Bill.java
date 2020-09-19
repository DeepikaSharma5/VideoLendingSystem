package com.video.model;

public class Bill {
	private int billID;
	private String DistributorName;
	private String videoName;
	private String price;
	private String years;
	private String total;
	public Bill(int billID, String distributorName, String videoName, String price, String years, String total) {
		super();
		this.billID = billID;
		DistributorName = distributorName;
		this.videoName = videoName;
		this.price = price;
		this.years = years;
		this.total = total;
	}
	public Bill(String distributorName, String videoName, String price, String years, String total) {
		super();
		DistributorName = distributorName;
		this.videoName = videoName;
		this.price = price;
		this.years = years;
		this.total = total;
	}
	public Bill(int billID, String distributorName, String videoName, String price, String years) {
		super();
		this.billID = billID;
		DistributorName = distributorName;
		this.videoName = videoName;
		this.price = price;
		this.years = years;
	}
	public Bill(String distributorName, String videoName, String price, String years) {
		super();
		DistributorName = distributorName;
		this.videoName = videoName;
		this.price = price;
		this.years = years;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public String getDistributorName() {
		return DistributorName;
	}
	public void setDistributorName(String distributorName) {
		DistributorName = distributorName;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
