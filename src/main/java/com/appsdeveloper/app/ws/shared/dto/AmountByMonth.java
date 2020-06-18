package com.appsdeveloper.app.ws.shared.dto;

import java.io.Serializable;

public class AmountByMonth implements Serializable {

	private static final long serialVersionUID = 2738406113210358237L;

	private String monthName;
	private String year;
	private String amount;

	
	public AmountByMonth(String monthName, String year, String amount) {
		super();
		this.monthName = monthName;
		this.year = year;
		this.amount = amount;
	}
	public String getMonthName() {
		return monthName;
	}
	
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
