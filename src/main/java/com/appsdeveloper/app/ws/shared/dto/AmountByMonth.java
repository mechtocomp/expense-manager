package com.appsdeveloper.app.ws.shared.dto;

import java.io.Serializable;

public class AmountByMonth implements Serializable {

	private static final long serialVersionUID = 2738406113210358237L;

	private String monthName;
	private int year;
	private String amount;
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
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
	public AmountByMonth(String monthName, int year, String amount) {
		super();
		this.monthName = monthName;
		this.year = year;
		this.amount = amount;
	}

	
	
}
