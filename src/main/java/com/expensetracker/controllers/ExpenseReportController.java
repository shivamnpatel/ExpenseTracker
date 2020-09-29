package com.expensetracker.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expensetracker.dao.ExpenseReportDao;
import com.expensetracker.models.Expenses;

@Controller
//@RequestMapping("/report")
public class ExpenseReportController {

	@Autowired
	ExpenseReportDao expenseReportDao;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession httpSession; 
	
	@RequestMapping(value = "/expense-report", method = RequestMethod.GET)
	public ModelAndView showExpenseReportForm() {
		return new ModelAndView("expense-report-form");
	}
	
	@RequestMapping(value = "/expense-report", method = RequestMethod.POST, params = "datewise")
	public ModelAndView expenseReportDatewise(@RequestParam String fromDate,@RequestParam String toDate,Model model) throws ParseException
	{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date convertedFromDate = sdf.parse(fromDate);
//		Date convertedToDate = sdf.parse(toDate);
//		String fromDate1=sdf.format(convertedFromDate);
//		String toDate1=sdf.format(convertedToDate);
//		System.out.println("From Date: "+fromDate1+" & To Date: "+toDate1);
		List<Expenses> expenseFromRange = expenseReportDao.expensesDatewise(fromDate, toDate,(String) httpSession.getAttribute("userEmail"));
		long totalExpensesDay=0;
		for (Expenses expenses : expenseFromRange) {
			totalExpensesDay += expenses.getCost();
		}
		model.addAttribute("expenseFromRange", expenseFromRange);
		model.addAttribute("totalExpensesDay", totalExpensesDay);
		
//		System.out.println("Inside datewise");
		return new ModelAndView("expenses-datewise");
	}
	
	@RequestMapping(value = "/expense-report", method = RequestMethod.POST, params = "monthwise")
	public ModelAndView expenseReportMonthly(@RequestParam String fromDate,@RequestParam String toDate,Model model) throws ParseException
	{
		
		List<Object[]> expensesMonthly = expenseReportDao.expensesMonthwise(fromDate, toDate,(String) httpSession.getAttribute("userEmail"));
		long totalExpensesMon = 0;
		for (Object[] objects : expensesMonthly) {
			totalExpensesMon += (Long) objects[2];
		}
		
		model.addAttribute("totalMonthlyExpenses", expensesMonthly);
		model.addAttribute("totalExpensesMon", totalExpensesMon);
		
		return new ModelAndView("expenses-monthwise");
	}
	
	@RequestMapping(value = "/expense-report", method = RequestMethod.POST, params = "yearwise")
	public ModelAndView expenseReportYearly(@RequestParam String fromDate,@RequestParam String toDate,Model model) throws ParseException
	{
		List<Object[]> expensesYearly = expenseReportDao.expensesYearwise(fromDate, toDate,(String) httpSession.getAttribute("userEmail"));
		System.out.println("Yearly total expenses:"+expensesYearly);
//		System.out.println("Inside yearwise");
		long totalExpensesYear = 0;
		for (Object[] objects : expensesYearly) {
			totalExpensesYear += (Long) objects[1];
		}
		
		model.addAttribute("totalYearlyExpenses", expensesYearly);
		model.addAttribute("totalExpensesYear", totalExpensesYear);
		return new ModelAndView("expenses-yearwise");
	}
	
}
