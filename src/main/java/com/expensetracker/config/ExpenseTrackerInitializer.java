package com.expensetracker.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ExpenseTrackerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?> configClass[] = { ExpenseTrackerConfig.class };
		return configClass;
	}

	@Override
	protected String[] getServletMappings() {
		String servletMapping[] = { "/" };
		return servletMapping;
	}

}
