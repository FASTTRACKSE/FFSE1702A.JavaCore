package model;

import java.sql.Timestamp;

public class Transaction {
	private String code, atm_code, card_sn;
	private Timestamp time;
	private double amount;
	
	public Transaction() {
	}

	public Transaction(String code, String atm_code, String card_sn, Timestamp time, double amount) {
		super();
		this.code = code;
		this.atm_code = atm_code;
		this.card_sn = card_sn;
		this.time = time;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAtm_code() {
		return atm_code;
	}

	public void setAtm_code(String atm_code) {
		this.atm_code = atm_code;
	}

	public String getCard_sn() {
		return card_sn;
	}

	public void setCard_sn(String card_sn) {
		this.card_sn = card_sn;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
