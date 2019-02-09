package com.cg.ctlr;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MyController 
{
	@RequestMapping(value="/showForm")
	public String showForm()
	{
		
		return "view";
	}
	
	
	@RequestMapping(value="/addEmp")
	public String addForm(Model model)
	{
		Employee e=new Employee();
		e.setEmpId(120);
		e.setName("Gowtham");
		e.setDob("18/08/1993");
		e.setSalary(45000f);
		e.setLocation("Hyderabad");
		model.addAttribute("add1", e);
		return "addForm";
	}
	
	@RequestMapping(value="/addEmp1")
	public String checkLogin(@ModelAttribute("add1") @Valid Employee e,BindingResult result,Model model)
	{
		 if(result.hasErrors())
		 {
			 System.out.println("Error");
			 return "addForm";
		 }
		 else
		 {
				model.addAttribute("emp1", e);
				return "success";
		 }
	
	}
	
	
}
