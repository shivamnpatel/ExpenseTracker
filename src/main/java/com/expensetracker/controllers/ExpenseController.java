package com.expensetracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.expensetracker.dao.ExpensesDao;
import com.expensetracker.models.Expenses;

@Controller
//@SessionAttributes("userEmail")
public class ExpenseController {

	@Autowired
	private ExpensesDao expensesDao;
	@Autowired
	HttpSession session;
	

/*
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		// dd/MM/yyyy
		System.out.println("Inside initBinder");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true,10));
	}
*/	
	@RequestMapping("/")
	public ModelAndView homePage(Model model) {
		
//		if(session.getAttribute("userEmail")==null)
//			return new ModelAndView("redirect:/login");
		
		String email = (String) session.getAttribute("userEmail");
		
		List<Long> todaysExpense = expensesDao.allExpensesOfUser(email);
		
		model.addAttribute("allExpensesTotal", todaysExpense);
		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/expenses",method = RequestMethod.GET)
	public String expensesHomePage(Model model) {
		String userEmail = (String)session.getAttribute("userEmail");
		List<Expenses> expenses = expensesDao.getExpensesByEmail(userEmail);
		model.addAttribute("myExpenses", expenses);
		return "expenses";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addExpensesPage(@ModelAttribute("myExpenses") Expenses expenses) {
		return "expense";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addExpenses(@ModelAttribute("myExpenses") Expenses expenses,BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors())
			return "expense";
		
		String email = (String) session.getAttribute("userEmail");
		expensesDao.addExpenses(expenses.getItem(), expenses.getCost(), expenses.getDate(),email);
		session.setAttribute("message", "Expense added successfully...");
		return "redirect:/expenses";
	}
	
	@RequestMapping(value = "/update-expenses",method = RequestMethod.GET)
	public String updateExpensesPage(@RequestParam int id,Model model) 
	{
		Expenses expensesById = expensesDao.getExpensesById(id);
		model.addAttribute("myExpenses", expensesById);
		
		return "expense";
	}
	
	@RequestMapping(value = "/update-expenses", method = RequestMethod.POST)
	public String updateExpensesInDB(Expenses expenses,Model model,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			return "expense";
		}
		expenses.setUserEmail((String) session.getAttribute("userEmail"));
		expensesDao.updateExpenses(expenses);
		System.out.println(expenses);
		session.setAttribute("message", "Expense updated successfully...");
		return "redirect:/expenses";
	}
	
	@RequestMapping(value = "/delete-expenses", method = RequestMethod.GET)
	public String deleteExpensesFromDB(@RequestParam int id)
	{		
		Expenses expensesById = expensesDao.getExpensesById(id);
		expensesDao.deleteExpenses(expensesById);
		session.setAttribute("message", "Expense deleted successfully...");
		return "redirect:/expenses";
	}
	
	
}
