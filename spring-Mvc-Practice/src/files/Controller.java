package files;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import classes.Pessoa;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/")
	public String mainMenu (){
		return "index";
	}
	
	@RequestMapping("/pessoa")
	public String pessoaForm (){
		return "Pessoa";
	}
	
	
	@RequestMapping("/processaPessoa")
	
	//Modo manual
	//public String resultadoPessoa (HttpServletRequest request, Model model){
	
	//modo com requestParam (direto quando recebe)
	public String resultadoPessoa (@RequestParam("nomePessoa") String pessoa, Model model){
		
		//String pessoa = request.getParameter("nomePessoa")+"!";
		model.addAttribute("pessoa", pessoa);
		
		return "pessoaCadastrada";
	}
	
	
	
	

}
