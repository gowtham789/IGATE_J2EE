package com.igate.tms.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.igate.tms.dao.TraineeDao;
import com.igate.tms.dto.Login;
import com.igate.tms.dto.Trainee;
import com.igate.tms.exception.TraineeException;
import com.igate.tms.service.TraineeIntf;

@Controller
public class AdmincontrollerVer2 
{
	@Autowired
	TraineeIntf TraineeService;
	
	@RequestMapping(value="Login")
	public String login(Model model)
	{
	
		Login l1=new Login();
		model.addAttribute("login",l1);
		return "Login";
	}
	
	@RequestMapping(value="Loginuser")
	public String loginuser(@ModelAttribute("login")Login l1,Model model)
	{
		if(l1.getUser().equals("igate")&&l1.getPassword().equals("igate"))
		{
			try
			{
				ArrayList<Trainee> trainees=TraineeService.viewAll();
				model.addAttribute("traineelist", trainees);
				
				return "Home";
			}
			catch (TraineeException e) 
			{
				model.addAttribute("exception",e);
				return "Error";
			}
				
			catch(DataAccessException dataAccessException)
			{
				model.addAttribute("exception",dataAccessException);
				return "Error";
			}
			
		}
		else
		{
		return "Login";
		}
	}
	
	@RequestMapping(value="Add")
	public String add(Model model) throws TraineeException
	{
		Trainee tdto=new Trainee();
		ArrayList<Trainee> trainees=TraineeService.viewAll();
		model.addAttribute("traineelist", trainees);
		model.addAttribute("addtrainee",tdto);
		model.addAttribute("add","1");
		return "Home";	
	}
	
	@RequestMapping(value="Insert")
	public String insert(@ModelAttribute("addtrainee")@Valid Trainee t1,BindingResult res,Model model)
	{
		System.out.println(t1.getId());
		if(t1.getId()<=0||res.hasErrors())
		{
			model.addAttribute("add","1");
			return "Home";
		}
		
		else
		{
			
			try 
			{
				int id = TraineeService.insertTrainee(t1);
				ArrayList<Trainee> trainees=TraineeService.viewAll();
				model.addAttribute("traineelist", trainees);
				return "Home";

			} 
			catch (TraineeException e)
			{
				model.addAttribute("exception",e);
				return "Error";
			}
			catch (DataAccessException e) 
			{
				model.addAttribute("exception",e);
				return "Error";
			}
		
		}
	}
	
	@RequestMapping(value="del")
	public String del(@RequestParam("did")String id,Model model) throws NumberFormatException, TraineeException
	{
		int delid=TraineeService.deleteTrainee(Integer.parseInt(id));
		ArrayList<Trainee> trainees=TraineeService.viewAll();
		model.addAttribute("traineelist", trainees);
		return "Home";
	}
	
	@RequestMapping(value="mod")
	public String modify(@RequestParam("mid")String id,Model model) throws NumberFormatException, TraineeException
	{
		int mid=Integer.parseInt(id);
		model.addAttribute("update","1");
		Trainee viewtrainee=TraineeService.viewTrainee(mid);
	//  viewtrainee=TraineeService.viewTrainee(mid);
		model.addAttribute("viewtrainee",viewtrainee);
		model.addAttribute("id",mid);
		ArrayList<Trainee> trainees=TraineeService.viewAll();
		model.addAttribute("traineelist", trainees);
		return "Home";
	}
	@RequestMapping(value="update")
	public String update(@ModelAttribute("viewtrainee") Trainee t1,Model model) throws TraineeException
	{
		TraineeService .updateTrainee(t1);
		model.addAttribute("traineelist", TraineeService.viewAll());
		return "Home";
	}
}
