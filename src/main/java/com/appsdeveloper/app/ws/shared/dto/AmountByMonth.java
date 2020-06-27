package com.appsdeveloper.app.ws.shared.dto;

import java.io.Serializable;

public class AmountByMonth implements Serializable {

	private static final long serialVersionUID = 2738406113210358237L;

	private int monthName;
	private int year;
	private String amount;
	public int getMonthName() {
		return monthName;
	}
	public void setMonthName(int monthName) {
		this.monthName = monthName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public AmountByMonth(int monthName, int year, String amount) {
		super();
		this.monthName = monthName;
		this.year = year;
		this.amount = amount;
	}

	
	
}
