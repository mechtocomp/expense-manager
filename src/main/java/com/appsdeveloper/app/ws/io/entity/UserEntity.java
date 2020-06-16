package com.appsdeveloper.app.ws.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -7014717025902009637L;

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column
	private Boolean isLogin = false;

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	// @OneToMany(targetEntity=AddExpenseEntity.class, cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id", referencedColumnName = "email")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<AddExpenseEntity> expenses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<AddExpenseEntity> getExpenses() {
//		return expenses;
//	}
//
//	public void setExpenses(List<AddExpenseEntity> expenses) {
//		this.expenses = expenses;
//	}

	public void setExpense(AddExpenseEntity expenseEntity) {
		expenses.add(expenseEntity);
		expenseEntity.setUser(this);
	}

	public void removeExpense(AddExpenseEntity expenseEntity) {
		expenses.remove(expenseEntity);
		expenseEntity.setUser(null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
