package model;

public class ATM {
	private String code, street;
	private double amount;
	private int districtID, wardID;
	
	
	public ATM() {
	}
	
	public ATM(String code, double amount, int district, int ward, String street) {
		this.code = code;
		this.street = street;
		this.amount = amount;
		this.districtID = district;
		this.wardID = ward;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDistrictID() {
		return districtID;
	}
	public void setDistrictID(int district) {
		this.districtID = district;
	}
	public int getWardID() {
		return wardID;
	}
	public void setWardID(int ward) {
		this.wardID = ward;
	}
	
}
