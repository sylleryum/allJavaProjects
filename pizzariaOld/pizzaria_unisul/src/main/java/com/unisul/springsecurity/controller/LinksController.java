package com.unisul.springsecurity.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unisul.springsecurity.Entity.Cliente;

@Controller
public class LinksController {

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
		theModel.addAttribute("cliente", new Cliente());
		
		return "register";
	}
	
	@PostMapping("/checkregister")
	public String checkRegister(@Valid @ModelAttribute("cliente") Cliente theCliente, BindingResult bR) {		
				
		System.out.println("<< checkRegister");
		System.out.println("usuario: "+theCliente.getUsername());
		System.out.println("senha: "+theCliente.getPassword());
		System.out.println("nome: "+theCliente.getNome());
		System.out.println("sobrenome: "+theCliente.getSobrenome());
		System.out.println("telefone: "+theCliente.getTel());
		System.out.println("endereço: "+theCliente.getEndereco());
		System.out.println("email: "+theCliente.getEmail());
		
		if (bR.hasErrors()) {
			return "/register";			
		} else {
			return "/registerConfirmation";
		}
	}
}
