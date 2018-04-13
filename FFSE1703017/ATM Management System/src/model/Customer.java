package model;

public class Customer {
	private String name, code, street, email, phone, cardSN, accSN;
	private int districtID, wardID;
	private double amount;
		
	public Customer() {
	}
	
	public Customer(String name, String phone, String email, int districtID, int wardID, String street, String code,
			String cardSN, String accSN, double amount) {
		this.name = name;
		this.code = code;
		this.street = street;
		this.email = email;
		this.districtID = districtID;
		this.wardID = wardID;
		this.phone = phone;
		this.cardSN = cardSN;
		this.accSN = accSN;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDistrictID() {
		return districtID;
	}
	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}
	public int getWardID() {
		return wardID;
	}
	public void setWardID(int wardID) {
		this.wardID = wardID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardSN() {
		return cardSN;
	}
	public void setCardSN(String cardSN) {
		this.cardSN = cardSN;
	}
	public String getAccSN() {
		return accSN;
	}
	public void setAccSN(String accSN) {
		this.accSN = accSN;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
