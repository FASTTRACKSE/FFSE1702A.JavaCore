package model;

public class Customer {
	int id;
	String fullname;
	String address;
	int countyID;
	int wardID;
	String phone;
	String email;
	String meterID;

	public Customer() {
		super();
	}

	public Customer(int id, String fullname, String address, int countyID, int wardID, String phone, String email,
			String meterID) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.countyID = countyID;
		this.wardID = wardID;
		this.phone = phone;
		this.email = email;
		this.meterID = meterID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCountyID() {
		return countyID;
	}

	public void setCountyID(int countyID) {
		this.countyID = countyID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMeterID() {
		return meterID;
	}

	public void setMeterID(String meterID) {
		this.meterID = meterID;
	}

}
