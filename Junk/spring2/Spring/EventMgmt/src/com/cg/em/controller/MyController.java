package com.cg.em.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.em.beans.CustomerDTO;
import com.cg.em.beans.EventDTO;
import com.cg.em.exception.EventException;
import com.cg.em.service.IEventService;


@Controller
public class MyController {

	@Autowired
	private IEventService service;
	
	@RequestMapping(value = "/reg")
	public String showForm(Model model) throws EventException
	{	
		System.out.println("In Login...............................");
		CustomerDTO customer=new CustomerDTO();
		model.addAttribute("cust",customer);
		ArrayList<EventDTO> list=service.getEvents();
		model.addAttribute("eventType",list);
		return "register";
	}
	
	@RequestMapping(value = "/insertCustomer")
	public String registerCustomer(@ModelAttribute("cust") @Valid CustomerDTO cust,BindingResult result,Model model) throws EventException
	{
		boolean flag=service.addCustomer(cust);
		model.addAttribute("cust",cust);
		return "regSuccess";
	}
	
	@RequestMapping(value = "/viewEvent")
	public String viewEvent(@ModelAttribute("cust") CustomerDTO cust,Model model) throws EventException
	{	
		ArrayList<EventDTO> list=service.getEvents();
		model.addAttribute("list",list);
		model.addAttribute("cust",cust);
		return "events";
	}
	
	@RequestMapping(value = "/book")
	public String bookEvent(@ModelAttribute("cust") CustomerDTO cust,@RequestParam("submit") String id,Model model) throws EventException
	{	
		int eId=Integer.parseInt(id);
		System.out.println(eId);
		ArrayList<EventDTO> list=service.getEvents();
		EventDTO event=new EventDTO();
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			EventDTO e=(EventDTO)itr.next();
			if(eId==e.getEventId())
			{
				event=e;
				break;
			}
			
		}
		
		int bookingId=service.bookEvent(event, cust);
		model.addAttribute("event",event);
		model.addAttribute("cust",cust);
		model.addAttribute("bId",bookingId);
		return "book";
	}
}
