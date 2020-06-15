package com.appsdeveloper.app.ws.ui.model.request;

public class AddExpenseRequestModel 
{
	private String expenseTitle;
	private String category;
	private String amount;
	private String date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
