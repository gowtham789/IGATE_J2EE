package com.igate.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igate.beans.Domain;
import com.igate.beans.Login;
import com.igate.beans.Trainee;
import com.igate.exception.TraineeException;
import com.igate.service.ITraineeService;


@Controller
public class TraineeController {
	
	@Autowired
	private ITraineeService traineeService;

	@RequestMapping(value="showLogin")
	public String prepareLogin(Model model)
	{
		System.out.println("In prepareLogin() method");
		model.addAttribute("login",new Login());
		return "Login";
	}
	
	@RequestMapping(value="checkLogin")
	public String checkLogin(@ModelAttribute("login") @Valid Login login,BindingResult result,Model model)
	{
		System.out.println("in checkLogin()");
		
		if(result.hasErrors())
			return "Login";
		
		//Logic to validate userName and password against database
		System.out.println("Dao "+traineeService);
		boolean userPresent=traineeService.isValidAdmin(login);
		
		if(userPresent)
	  	    return "PickOperation";
		else
			return "loginFailed";
	}
	
	@RequestMapping(value = "showAddTrainee")
	public String showAddDonation(Model model) {
		// Create an attribute of type Question
		List<Domain> elist = traineeService.getDomain();
		model.addAttribute("domainList", elist);
		model.addAttribute("Add",new Trainee());
		return "AddTraineeForm";
	
	}
	
	@RequestMapping(value = "addTrainee")
	public String addDonation(@Valid Trainee t,BindingResult result, Model model) {
			int tid=0;
		if (result.hasErrors()) {
			return "AddTraineeForm";
		}
		
		try
		{
			tid = traineeService.addTrainee(t);
			model.addAttribute("tid", tid);
			return "AddSuccessTrainee";
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
	}
	

	@RequestMapping(value = "showViewTraineeForm")
	public String showViewDonationForm(Model model) {
		// Create an attribute of type Question
		Trainee t = new Trainee();
		// Add the attribute to the model
		model.addAttribute("Add", t);
		model.addAttribute("isFirst","true");
		// return the view name
		return "ViewTrainee";
	}


	@RequestMapping(value = "retrieveTrainee")
	public String viewDonation(@ModelAttribute("Add") Trainee t,
			Model model) throws TraineeException{
			boolean isValidId;
			try
			{
				isValidId=traineeService.isValidTrainee(t.getTraineeId());
				System.out.println("isValid="+isValidId);
			}
			catch(DataAccessException dataAccessException)
			{
				model.addAttribute("msg","Technical Problem..Please Try Later!!");
				return "myError";
			}
		
		if("".equals(t.getTraineeId()))
		{
			throw new TraineeException("Enter  Your Trainee Id");
		}
		try
		{
		if(isValidId==true)
		{
			Trainee dBean = new Trainee();
			dBean = traineeService.viewTraineeById(t.getTraineeId());
			model.addAttribute("dBean", dBean);
			System.out.println("bean="+dBean);
			return "ViewTrainee";
		}
		else
		{
			String msg = "Enter a Valid Id!!";
			model.addAttribute("msg", msg);
			return "myError";
		}
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
		}
	
	
	@RequestMapping(value = "retrieveAllTrainees")
	public String showViewAllDonations(Model model) {

		// return the view name
		try
		{
			List<Trainee> list = traineeService.viewAllTrainees();
			if (list.isEmpty()) {
			String msg = "There are no trainees";
			model.addAttribute("msg", msg);
			return "myError";
		}
		// Add the attribute to the model
		model.addAttribute("tlist", list);
		return "ViewAllTraineesList";
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
		
	}

		@RequestMapping(value = "delTraineeForm")
		public String delTraineeForm(Model model) {
			System.out.println("In delTrainee() method");
			// Create an attribute of type Question
			Trainee t = new Trainee();
			// Add the attribute to the model
			model.addAttribute("Add", t);
			model.addAttribute("isFirst","true");
			// return the view name
			return "Delete";
		}
		
		@RequestMapping(value = "delTraineeById")
		public String delTraineeById(@ModelAttribute("Add") Trainee t,
				Model model) throws TraineeException{
				boolean isValidId;
				try
				{
					isValidId=traineeService.isValidTrainee(t.getTraineeId());
					System.out.println("isValid="+isValidId);
				}
				catch(DataAccessException dataAccessException)
				{
					model.addAttribute("msg","Technical Problem..Please Try Later!!");
					return "myError";
				}
			
			if("".equals(t.getTraineeId()))
			{
				throw new TraineeException("Enter  Your Trainee Id");
			}
			try
			{
			if(isValidId==true)
			{
				Trainee dBean = new Trainee();
				dBean = traineeService.viewTraineeById(t.getTraineeId());
				model.addAttribute("dBean", dBean);
				System.out.println("bean="+dBean);
				return "Delete";
			}
			else
			{
				String msg = "Enter a Valid Id!!";
				model.addAttribute("msg", msg);
				return "myError";
			}
			}
			catch(DataAccessException dataAccessException)
			{
				model.addAttribute("msg","Technical Problem..Please Try Later!!");
				return "myError";
			}
		}
		
		@RequestMapping(value = "delTrainee")
		public String delTrainee(@ModelAttribute("Add") Trainee t,Model model) {
			System.out.println("In delTrainee() method");
			// Create an attribute of type Question
			traineeService.deleteTrainee(t.getTraineeId());
			return "DeleteSuccess";
		}
		

		@RequestMapping(value = "modifyTraineeForm")
		public String modifyTraineeForm(Model model) {
			System.out.println("In modifyTraineeForm() method");
			// Create an attribute of type Question
			Trainee t = new Trainee();
			// Add the attribute to the model
			model.addAttribute("Add", t);
			model.addAttribute("isFirst","true");
			// return the view name
			return "Modify";
		}
		
		@RequestMapping(value = "modifyTraineeById")
		public String modifyTraineeById(@ModelAttribute("Add") Trainee t,
				Model model) throws TraineeException{
				boolean isValidId;
				try
				{
					isValidId=traineeService.isValidTrainee(t.getTraineeId());
					System.out.println("isValid="+isValidId);
				}
				catch(DataAccessException dataAccessException)
				{
					model.addAttribute("msg","Technical Problem..Please Try Later!!");
					return "myError";
				}
			
			if("".equals(t.getTraineeId()))
			{
				throw new TraineeException("Enter  Your Trainee Id");
			}
			try
			{
			if(isValidId==true)
			{
				Trainee dBean = new Trainee();
				dBean = traineeService.viewTraineeById(t.getTraineeId());
				model.addAttribute("dBean", dBean);
				System.out.println("bean="+dBean);
				return "Modify";
			}
			else
			{
				String msg = "Enter a Valid Id!!";
				model.addAttribute("msg", msg);
				return "myError";
			}
			}
			catch(DataAccessException dataAccessException)
			{
				model.addAttribute("msg","Technical Problem..Please Try Later!!");
				return "myError";
			}
		}
		
		@RequestMapping(value = "modifyTrainee")
		public String modifyTrainee(@ModelAttribute("dBean") Trainee t,Model model) {
			System.out.println("In modifyTrainee() method");
			// Create an attribute of type Question
			traineeService.updateTrainee(t);
			return "UpdateSuccess";
		}
		
		
		
		
}
