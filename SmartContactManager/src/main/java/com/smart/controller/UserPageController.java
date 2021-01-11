package com.smart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserDao;
import com.smart.entities.User;
import com.smart.helper.Message;

@Controller
public class UserPageController 
{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDao userdao;
	
	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("title", "Registration - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "register";
	}
	
	 @PostMapping("/do_register") 
	 public String doRegister(@ModelAttribute("user") User user, @RequestParam(value="check", defaultValue="false") boolean check, Model model, HttpSession session) 
	 {
		  try
		  {
			  if(!check)
			  {
				  System.out.println("Please accept terms and Conditions");
				  throw new Exception("Please accept terms and Conditions");
			  }

			  user.setUserRole("User");
			  user.setActive(true);
			  user.setUserImage("default_profile_photo.png");
			  user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
			  
			  userdao.save(user);
			  
			  model.addAttribute("user", new User());
			  session.setAttribute("msg", new Message("Successfully Registered. Please Continue to Your Login", "alert-success"));
			  
			  return "register";
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  
			  model.addAttribute("user", user);
			  session.setAttribute("msg", new Message("Something Went Wrong !! Please accept terms and Conditions", "alert-danger"));
			  
			  return "register";
			  
		 }
	 }
	  
	  @GetMapping("/login")
		public String dashboard(Model model)
		{
			model.addAttribute("title", "Login Page");
			return "/login";
		}
	  
}
