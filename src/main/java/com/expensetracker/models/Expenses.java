package com.expensetracker.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseId;

	private String item;

	private Integer cost;

	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date date;

	private String userEmail;

	public Expenses() {

	}

	public Expenses(String item, Integer cost, Date date, String userEmail) {
		this.item = item;
		this.cost = cost;
		this.date = date;
		this.userEmail = userEmail;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Expenses [expenseId=" + expenseId + ", item=" + item + ", cost=" + cost + ", date=" + date
				+ ", userEmail=" + userEmail + "]";
	}

}
