package com.appsdeveloper.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity (name="expenseTable")
public class AddExpenseEntity implements Serializable {

	private static final long serialVersionUID = 6247270792212832562L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String expenseTitle;
	
	@NotNull
	private String category;
	
	@NotNull
	private String amount;
	
	@NotNull
	private String date;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private AddExpenseEntity expense;
	
	
	public AddExpenseEntity getExpense() {
		return expense;
	}
	public void setExpense(AddExpenseEntity expense) {
		this.expense = expense;
	}
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
