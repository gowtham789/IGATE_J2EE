package com.igate.ctlr;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping(value="/showForm")
	public String showForm(Model model)
	{
		
		//LoginBean  - loginBean
		Login l1=new Login();
		l1.setUserName("IGATE");
		l1.setPassword("Secret");
	  model.addAttribute("login", l1);
	  //model.addAttribute(new Login());//login
	  return "login";//Logical view name
	}
	
	@RequestMapping(value="/checkLogin")
	public String checkLogin(@ModelAttribute("login") Login l1)
	{
	  	if(l1.getPassword().equals("JEE"))
	  return "success";	
	  	else
	  		 return "login";
	}

}
