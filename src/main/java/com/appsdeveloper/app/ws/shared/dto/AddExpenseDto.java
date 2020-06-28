package com.appsdeveloper.app.ws.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class AddExpenseDto implements Serializable
{
	private static final long serialVersionUID = -8030801319127041321L;
	
	private int id;	
	private String expenseTitle;
	private String category;
	private String amount;
	private Date date;
	public String getExpenseTitle() {
		return expenseTitle;
	}
	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
