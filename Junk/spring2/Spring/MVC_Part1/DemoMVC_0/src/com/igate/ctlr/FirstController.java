package com.igate.ctlr;

import java.util.Date;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FirstController implements Controller{
	
	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res)
	{
	    String now = new Date().toString();
	    
	    // Direct to View "hello"
	    // Keep now in Model with name "today"
	    
		return new ModelAndView("hello","today",now);
	}

}
