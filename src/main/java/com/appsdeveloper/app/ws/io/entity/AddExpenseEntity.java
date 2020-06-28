package com.appsdeveloper.app.ws.io.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity (name="expense")
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
	@javax.persistence.Temporal(TemporalType.DATE)
	private Date date;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private UserEntity user;
	
	
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
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
