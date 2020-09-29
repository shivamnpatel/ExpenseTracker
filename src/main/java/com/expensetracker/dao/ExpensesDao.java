package com.expensetracker.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.expensetracker.helper.FactoryProvider;
import com.expensetracker.models.Expenses;

@Component
public class ExpensesDao {

	// add Expenses with userEmail in database for add-expenses page
	public void addExpenses(String item,Integer cost,Date date,String email) 
	{
		Session session = FactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();
		Expenses expenses = new Expenses(item, cost, date,email);
		session.save(expenses);
		session.getTransaction().commit();
		session.close();
	}

		// retrieve expenses by userEmail
		public List<Expenses> getExpensesByEmail(String userEmail)
		{
			List<Expenses> expensesByEmail = null;
			Session session = FactoryProvider.getSessionFactory().openSession();
			Query query = session.createQuery("From Expenses where userEmail=:e");
			query.setParameter("e", userEmail);
			expensesByEmail = (List<Expenses>) query.getResultList();
			
			session.close();
			//todaysExpense(userEmail);
			return expensesByEmail;
		}
		
		// retrieve expenses by id
		public Expenses getExpensesById(int id)
		{
			Expenses expensesById = null;
			Session session = FactoryProvider.getSessionFactory().openSession();
			Query query = session.createQuery("From Expenses where expenseId=:i");
			query.setParameter("i", id);
			expensesById = (Expenses) query.uniqueResult();
			
			session.close();
			return expensesById;
		}
		
		// update expenses
		public void updateExpenses(Expenses expenses)
		{
			Session session = FactoryProvider.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(expenses);
			session.getTransaction().commit();
			session.close();
		}
		
		// delete expenses
		public void deleteExpenses(Expenses expenses)
		{
			Session session = FactoryProvider.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.delete(expenses);
			session.getTransaction().commit();
			session.close();
		}
		
		
		// get total expense of user
		public List<Long> allExpensesOfUser(String userEmail) {
			
			Long todaysExpenses,yesterdaysExpenses,weekExpenses,monthExpenses,yearExpenses,totalExpenses;
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate today = LocalDate.now();
			LocalDate yesterday = today.minusDays(1);
			LocalDate week = today.minusDays(7);
			LocalDate month = today.minusDays(30);
			int lengthOfCurrentYear = today.getDayOfYear();
			
			
//			Month month = today.get;
			LocalDate year = today.minusDays(lengthOfCurrentYear);
			
			String todaysDate = today.format(format);
			String yesterdaysDate = yesterday.format(format);
			String weekDate = week.format(format);
			String monthsDate = month.format(format);
			String yearDate = year.format(format);
		        
			Session session = FactoryProvider.getSessionFactory().openSession();
			Query query = session.createQuery("Select SUM(cost) from Expenses where"
					+ " userEmail='"+userEmail+"' AND date='"+todaysDate+"'");
			todaysExpenses = (Long) query.uniqueResult();
			System.out.println("Todays expenses:"+todaysExpenses);
			
			Query query1 = session.createQuery("Select SUM(cost) from Expenses where"
					+ " userEmail='"+userEmail+"' AND date BETWEEN '"+yesterdaysDate+"'"+"AND '"+todaysDate+"'");
			yesterdaysExpenses = (Long) query1.uniqueResult();
			System.out.println("Yesterdays expenses:"+yesterdaysExpenses);
			
			Query query2 = session.createQuery("Select SUM(cost) from Expenses where"
					+ " userEmail='"+userEmail+"' AND date BETWEEN '"+weekDate+"'"+"AND '"+todaysDate+"'");
			weekExpenses = (Long) query2.uniqueResult();
			System.out.println("Week expenses:"+weekExpenses);
			
			Query query3 = session.createQuery("Select SUM(cost) from Expenses where"
					+ " userEmail='"+userEmail+"' AND date BETWEEN '"+monthsDate+"'"+"AND '"+todaysDate+"'");
			monthExpenses = (Long) query3.uniqueResult();
			System.out.println("Month expenses:"+monthExpenses);
			
			Query query4 = session.createQuery("Select SUM(cost) from Expenses where"
					+ " userEmail='"+userEmail+"' AND date BETWEEN '"+yearDate+"'"+"AND '"+todaysDate+"'");
			yearExpenses = (Long) query4.uniqueResult();
			System.out.println("Year expenses:"+yearExpenses);
			
			Query query5 = session.createQuery("Select SUM(cost) from Expenses where"
					+ " userEmail='"+userEmail+"'");
			totalExpenses = (Long) query5.uniqueResult();
			System.out.println("Total expenses:"+totalExpenses);
	
			List<Long> allExpenses = new ArrayList<Long>();
			
			allExpenses.add(todaysExpenses);
			allExpenses.add(yesterdaysExpenses);
			allExpenses.add(weekExpenses);
			allExpenses.add(monthExpenses);
			allExpenses.add(yearExpenses);
			allExpenses.add(totalExpenses);
			
			if(allExpenses.get(0)==null)
				allExpenses.set(0, 0L);
			if(allExpenses.get(1)==null)
				allExpenses.set(1, 0L);
			if(allExpenses.get(2)==null)
				allExpenses.set(2, 0L);
			if(allExpenses.get(3)==null)
				allExpenses.set(3, 0L);
			if(allExpenses.get(4)==null)
				allExpenses.set(4, 0L);
			if(allExpenses.get(5)==null)
				allExpenses.set(5, 0L);
			session.close();
			
			return allExpenses;
		}
	}
