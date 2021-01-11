package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserSecurityController 
{
	@RequestMapping("/user_dashboard")
	public String dashboard()
	{
		return "user/user_dashboard";
	}
}
