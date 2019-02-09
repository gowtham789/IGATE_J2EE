package com.trainee.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trainee.bean.Trainee;
import com.trainee.service.ITraineeService;



@Controller
public class TraineeController 
{
	@Autowired
	private ITraineeService traineeService; 
	
	@RequestMapping(value ="log")
	public String showHomePage(Model model)
	{
		return "Home";
	}// end of showhomepage
	
	@RequestMapping(value = "addTrainee")
	public String showAddTrainee(Model model) 
	{
		// Create an attribute of type Question
		Trainee trainee = new Trainee();
		// Add the attribute to the model
		model.addAttribute("trainee1", trainee);
		// return the view name
		return "addTraineeForm";
	}// end of showAddTrainee

	@RequestMapping(value = "addTrainee1")
	public String addTrainee(@ModelAttribute("trainee1") @Valid Trainee trainee,
			BindingResult result, Model model) {
			int trnId=0;
		if (result.hasErrors()) {
			return "addTraineeForm";
		}
		
		try
		{
			trnId = traineeService.addTrainee(trainee);
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
		if (trnId != 0) {
			
			return "addSuccess";
		} 
		else {
			String msg = "Technical Problem..Please Try Later!!";
			model.addAttribute("msg", msg);
			return "myError";
		}
	} //end of add trainee
	
	
	@RequestMapping(value="retrieveTrainee")
	public String showViewTraineeForm(Model model) {
		// Create an attribute of type Question
		Trainee trn = new Trainee();
		// Add the attribute to the model
		model.addAttribute("trainee1",trn);
		model.addAttribute("isFirst","true");
		// return the view name
		return "viewTrainee";
	}
	
	
	@RequestMapping(value = "viewTrainee1")
	public String viewTrainee(@ModelAttribute("trainee1") Trainee trainee,Model model) 
	{
		Trainee trn = new Trainee();
		try
		{
			trn = traineeService.getTraineeById(trainee.getTraineeId());
			model.addAttribute("trainee", trn);
			return "viewTrainee";
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
		
	}
	

	@RequestMapping(value = "deleteTrainee")
	public String showDeleteTraineeForm(Model model) {
		// Create an attribute of type Question
		Trainee trn = new Trainee();
		// Add the attribute to the model
		model.addAttribute("trainee1", trn);
		model.addAttribute("isFirst","true");
		// return the view name
		return "viewDelete";
	} //end of showDeleteTraineeForm
	
	
	@RequestMapping(value = "viewDelete")
	public String viewDelete(@ModelAttribute("trainee1") Trainee trainee,Model model) 
	{
		Trainee trn = new Trainee();
		try
		{
			trn = traineeService.getTraineeById(trainee.getTraineeId());
			model.addAttribute("trainee", trn);
			return "viewDelete";
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
		
	}
	
	@RequestMapping(value = "delConfirm")
	public String deleteConfirm(@RequestParam("id") String t,Model model) 
	{
		
		int id=Integer.parseInt(t);
		System.out.println(id);
		int count=traineeService.deleteTrainee(id);
		return "deleteSuccess";
	}
	
	@RequestMapping(value = "retrieveall")
	public String retrieveAllTrainees(Model model)
	{
		// return the view name
		try
		{
			List<Trainee> list = traineeService.getAllTrainees();
			if (list.isEmpty()) 
			{
			String msg = "There are no Trainees";
			model.addAttribute("msg", msg);
			return "myError";
		    }
		// Add the attribute to the model
		model.addAttribute("list", list);
		return "viewAllTrainees";
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
	}//end of retrieveAllTrainees
	
	@RequestMapping(value = "modifyTrainee")
	public String modifyTrainee(Model model)
	{
		// Create an attribute of type Question
		Trainee trn = new Trainee();
		// Add the attribute to the model
		model.addAttribute("trainee1", trn);
		model.addAttribute("isFirst","true");
		// return the view name
		return "viewModify";
	}
	@RequestMapping(value = "viewUpdate")
	public String updateTrainee(@ModelAttribute("trainee1") Trainee trainee,Model model)
	{
		Trainee trn = new Trainee();
		try
		{
			trn = traineeService.getTraineeById(trainee.getTraineeId());
			model.addAttribute("trainee1", trn);
			return "viewModify";
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
	}
	
	@RequestMapping(value = "modConfirm")
	public String updateConfirm(@ModelAttribute("trainee1") Trainee trainee,Model model) 
	{
		
		
		int count=traineeService.updateTrainee(trainee);
		return "modifySuccess";
	}
	
	
	
}
