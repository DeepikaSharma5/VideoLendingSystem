package com.packages;

public class Pro {
	
	private int CardNumber;
	private int ExpirationDate;
	private int SecurityCode;
	private String FirstName;
	private String LastName;
	private String Package;
	

	public int getCardNumber() {
		return CardNumber;
	}
	public int getExpirationDate() {
		return ExpirationDate;
	}
	public int getSecurityCode() {
		return SecurityCode;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getPackage() {
		return Package;
	}
	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}
	public void setExpirationDate(int expirationDate) {
		ExpirationDate = expirationDate;
	}
	public void setSecurityCode(int securityCode) {
		SecurityCode = securityCode;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setPackage(String package1) {
		Package = package1;
	}

}
