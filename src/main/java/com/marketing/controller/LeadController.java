package com.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	
	//Handler Methods
	
	//http://localhost:8080/create
	
	@RequestMapping("/create")
	public String viewCreateLeadForm() {
		return "create_lead";
	}
	
	  //http://localhost:8080/saveLead

	//Second way to read the data 
   // @RequestMapping("/saveLead")
	
	//leadService.saveOneLead(lead);
	//return "create_lead";
// }
	
 
	   //http://localhost:8080/saveLead
	
       @RequestMapping("/saveLead")
		public String saveLead(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobile") long mobile) {
		Lead lead = new Lead();
		lead.setFirstName(firstName);
		lead.setLastName(lastName);
		lead.setEmail(email);
		lead.setMobile(mobile);
		leadService.saveOneLead(lead);
		return "create_lead";		
	}
}


