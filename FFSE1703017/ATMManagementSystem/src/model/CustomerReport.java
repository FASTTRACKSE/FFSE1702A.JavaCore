package model;

public class CustomerReport extends Transaction {

	private String customer_name, customer_code, phone;
	private double customer_withdraw, customer_amount;

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

	public double getCustomer_withdraw() {
		return customer_withdraw;
	}

	public void setCustomer_withdraw(double customer_withdraw) {
		this.customer_withdraw = customer_withdraw;
	}

	public double getCustomer_amount() {
		return customer_amount;
	}

	public void setCustomer_amount(double customer_amount) {
		this.customer_amount = customer_amount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
