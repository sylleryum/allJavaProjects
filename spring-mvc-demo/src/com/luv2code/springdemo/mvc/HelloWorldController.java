package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	@RequestMapping("processForm")
	public String processForm(){
		return "helloWorld";
	}
	
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model){
		
		
		//Read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//Convert to uppercase
		theName = theName.toUpperCase();		
		
		//concatenate
		String result = "SHOUTING: "+theName;
				
		//add result to the model (response)
		model.addAttribute("message", result);
		
		return "helloWorld";
	}
	
	
	@RequestMapping("/processFormThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
		
		
		
		//Convert to uppercase
		theName = theName.toUpperCase();		
		
		//concatenate
		String result = "REQUEST PARAM: "+theName;
				
		//add result to the model (response)
		model.addAttribute("message", result);
		
		return "helloWorld";
	}
	
	
}
