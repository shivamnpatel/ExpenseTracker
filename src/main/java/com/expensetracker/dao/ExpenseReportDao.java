package com.expensetracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.expensetracker.helper.FactoryProvider;
import com.expensetracker.models.Expenses;

@Component
public class ExpenseReportDao {

	// get expense of user from specified date range
	public List<Expenses> expensesDatewise(String fromDate, String toDate, String userEmail) {

		List<Expenses> expenseReport;

		Session session = FactoryProvider.getSessionFactory().openSession();
		Query query = session.createQuery("From Expenses where" + " userEmail='" + userEmail
				+ "' AND date BETWEEN '" + fromDate + "'" + "AND '" + toDate + "'");
		expenseReport = query.getResultList();

		session.close();

		return expenseReport;
	}
	
	// get monthly expense of user 
	public List<Object[]> expensesMonthwise(String fromDate, String toDate, String userEmail) {
		
		List<Object[]> expenseReportMonthly;
		
		Session session = FactoryProvider.getSessionFactory().openSession();
		Query query = session.createQuery(" Select month(date), year(date), SUM(cost) From Expenses where" +
				" userEmail='" + userEmail	+ "' AND date BETWEEN '"
				+ fromDate + "'" + "AND '" + toDate + "'"+" GROUP BY month(date)");
		
		expenseReportMonthly =  query.getResultList();
//		select sum(cost),month(date) from `expense-tracker`.expenses
//		where userEmail="shivampatel6998@gmail.com" and date
//		between '2020-05-02' and '2020-09-25' group by month(date);
		session.close();
		
		return expenseReportMonthly;
	}

	// get yearly expense of user 
	public List<Object[]> expensesYearwise(String fromDate, String toDate, String userEmail) {

		List<Object[]> expensesYearly;
		
		Session session = FactoryProvider.getSessionFactory().openSession();
		Query query = session.createQuery(" Select year(date), SUM(cost) From Expenses where" +
				" userEmail='" + userEmail	+ "' AND date BETWEEN '"
				+ fromDate + "'" + "AND '" + toDate + "'"+" GROUP BY year(date)");
		
		expensesYearly =  query.getResultList();
		
		session.close();
		
		return expensesYearly;
	}
	
	
}
