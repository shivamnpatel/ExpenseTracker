package com.expensetracker.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.expensetracker.helper.FactoryProvider;
import com.expensetracker.models.LoginUser;
import com.expensetracker.models.RegisterUser;

@Component
public class UserDao {

	//save user data for register page
	public void saveUserDetails(RegisterUser userDetails) 
	{
		Session session = FactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}
	
	// retrieve data for login page
	public RegisterUser getUserByEmailPassword(String userEmail,String userPassword)
	{
		RegisterUser user = null;
		try 
		{
			Session session = FactoryProvider.getSessionFactory().openSession();
			String query = "from RegisterUser where email =:e and password =:p"; 
			Query q = session.createQuery(query);
			q.setParameter("e", userEmail);
			q.setParameter("p", userPassword);
			
			user = (RegisterUser) q.uniqueResult();
			//System.out.println(user);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
		return user;
	}
}
