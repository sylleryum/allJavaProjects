package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create student object
		Student theStudent = new Student();
		
		//add student to the model
		theModel.addAttribute("student", theStudent);
		
	    // add the country options to the model 
	    theModel.addAttribute("theCountryOptions", countryOptions); 		
		
		return "student-form";
	}
	
    @Value("#{countryOptions}") 
    private Map<String, String> countryOptions;
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input date
		System.out.println("theStudent: "+theStudent.getFirstName()+ " "+theStudent.getLastName());
		System.out.println("Programming language: "+theStudent.getFavoriteLanguage());
		
		return "student-confirmation";
	}

}
