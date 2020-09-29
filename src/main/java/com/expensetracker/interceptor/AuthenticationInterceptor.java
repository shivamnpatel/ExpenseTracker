package com.expensetracker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		System.out.println("Inside interceptors...");
		String email = (String) session.getAttribute("userEmail");
		System.out.println("Email: "+email);
		
		if (email == null && !request.getRequestURI().endsWith("login")
				&& !request.getRequestURI().endsWith("register")) 
		{
			response.sendRedirect(request.getContextPath()+"/login");
			//request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		else 
			return true;
	}


}
