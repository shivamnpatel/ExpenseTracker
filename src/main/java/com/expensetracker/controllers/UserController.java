package com.expensetracker.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.expensetracker.dao.UserDao;
import com.expensetracker.models.LoginUser;
import com.expensetracker.models.RegisterUser;

@Controller
//@SessionAttributes("userEmail")
public class UserController {

	@Autowired
	UserDao userDao;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage(@ModelAttribute RegisterUser registerUser) {
		
		if(session.getAttribute("userEmail")!=null)
			return "redirect:/";
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute RegisterUser registerUser,BindingResult bindingResult,Model model) 
	{
		if(bindingResult.hasErrors())
		{
			return new ModelAndView("register");
		}
		
		userDao.saveUserDetails(registerUser);
		//session.setAttribute("userState", registerUser);
		//session.setAttribute("userEmail", registerUser.getEmail());
		session.setAttribute("message", "Registration Successful! Login to proceed");
//		model.addAttribute("userEmail", registerUser.getEmail());
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(@ModelAttribute LoginUser loginUser) {
		
		if(session.getAttribute("userEmail")!=null)
			return "redirect:/";
		
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam String email,@RequestParam String password,
			Model model)
	{
		RegisterUser user = userDao.getUserByEmailPassword(email, password);
		
		if(user==null)
		{
			// invalid login id, password
			//request.setAttribute("messages", "Invalid email/password!");
			session.setAttribute("message", "Invalid email/password!");
			return new ModelAndView("redirect:/login");
		}
		
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("userEmail", email);
//		model.addAttribute("userEmail", loginUser.getEmail());
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/Logout",method = RequestMethod.GET)
	public String logoutUser(@ModelAttribute LoginUser loginUser,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		request.getSession().invalidate();
		return "login";
	}

}
