package com.unisul.springsecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luv2code.springdemo.dao.CustomerDAOImpl;
import com.unisul.springsecurity.Entity.Cliente;

@Controller
public class LinksController {

	//remove whitespace (trim)
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	
	@GetMapping("/register")
	public String showRegister(Model theModel) {		
				
		System.out.println("<< register");
		theModel.addAttribute("client", new Cliente());
		
		return "register";
	}
	//TODO adicionar os errors no jsp do register
	@RequestMapping(value="/checkregister", method=RequestMethod.POST)
	public String checkRegister(@Valid @ModelAttribute("client") Cliente theCliente, BindingResult theBindingResult) {
		System.out.println("n erros " +theBindingResult.getErrorCount());
		System.out.println("tem erro:" +theBindingResult.hasErrors());
		System.out.println("<< checkRegister");
		System.out.println("usuario: "+theCliente.getUsername());
		System.out.println("senha: "+theCliente.getPassword());
		System.out.println("nome: "+theCliente.getNome());
		System.out.println("sobrenome: "+theCliente.getSobrenome());
		System.out.println("telefone: "+theCliente.getTel());
		System.out.println("endereço: "+theCliente.getEndereco());
		System.out.println("email: "+theCliente.getEmail());
		CustomerDAOImpl dao = new CustomerDAOImpl();
		dao.saveCliente(theCliente);
		return "/register";
//		if (theBindingResult.hasErrors()) {
//			return "/register";			
//		} else {
//			return "/registerConfirmation";
//		}
	}
}
