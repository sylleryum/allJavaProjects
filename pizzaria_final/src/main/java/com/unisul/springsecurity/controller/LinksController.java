package com.unisul.springsecurity.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.unisul.springsecurity.Entity.Authority;
import com.unisul.springsecurity.Entity.Cliente;
import com.unisul.springsecurity.Entity.Pedido;
import com.unisul.springsecurity.dao.AuthorityDAO;
import com.unisul.springsecurity.dao.ClienteDAO;
import com.unisul.springsecurity.dao.ClienteDAOImpl;
import com.unisul.springsecurity.dao.PedidoDAO;

@Controller
public class LinksController {

	Pedido tempPedido = null;
	
    @Autowired
    ClienteDAO dao;
    
    @Autowired
    AuthorityDAO aDao;   
    
    @Autowired
    PedidoDAO pDao;   
    
    @Value("#{saboresOptions}") 
    Map<String, String> saboresOptions;
        
    @Value("#{adicionalOptions}") 
    Map<String, String> adicionalOptions;
        
    @Value("#{bebidaOptions}") 
    Map<String, String> bebidaOptions;
	
    Pedido pedidoMain = null;
    
	//remove whitespace (trim)
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		theModel.addAttribute("pedido", new Pedido());
		
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
	
	//TODO verificar se campos não são grandes de mais
	@RequestMapping(value="/checkregister", method=RequestMethod.POST)
	public String checkRegister(@Valid @ModelAttribute("client") Cliente theCliente, BindingResult theBindingResult, Model theModel) {
		boolean verificacaoCliente = dao.verifyCliente(theCliente.getUsername());
		//username já existe?
		System.out.println("cliente já existe? (false=sim)"+verificacaoCliente);
		
//		System.out.println("cliente===== "+theCliente);
		
		if (theBindingResult.hasErrors()) {
			return "/register";
			
		} else if (verificacaoCliente==false) {
			theModel.addAttribute("username", "erro");
			return "/register";
		} else {
			theCliente.setEnabled(1);
			theCliente.setPassword("{noop}"+theCliente.getPassword());
			dao.saveCliente(theCliente);
			Authority theAuthority = new Authority(theCliente.getUsername(), "ROLE_USER");
			aDao.saveAuthority(theAuthority);
			return "/registerConfirmation";
		}
	}
	
	@GetMapping("/registerConfirmation")
	public String showRegisterConfirmation() {		
				
		System.out.println("<< registerConfirmation");
		
		return "registerConfirmation";
	}
	
	//TODO required fields
	//TODO ajax para carregar quant. de sabores na mesma pagina
	@GetMapping("/processPedido")
	public String showProcessPedido(@RequestParam(value="retorna", required=false) Optional<String> retorna, 
			@Valid @ModelAttribute("pedido") Pedido thePedido, BindingResult theBindingResult, Model theModel) {		
		//String retorna = request.getParameter("retorna");
		//System.out.println("eeeeoeoeoeeoe "+retorna.get());
		//boolean firstRun = true;
		if (retorna.isPresent()) {
			//System.out.println("eeeeoeoeoeeoe "+retorna.get());
			theModel.addAttribute("pedidoParc", pedidoMain);
		    theModel.addAttribute("saboresOptions", saboresOptions); 
		    theModel.addAttribute("theAdicionalOptions", adicionalOptions);
		    theModel.addAttribute("theBebidaOptions", bebidaOptions);
		    return "pedido2";
		}
		System.out.println("<< processPedido");
		System.out.println("tamanho "+thePedido.getTamanho());
		System.out.println("Massa "+thePedido.getMassa());
		System.out.println("borda "+thePedido.getBorda());
		System.out.println("dividida "+thePedido.getDividida());
		System.out.println("Pedido main: "+pedidoMain);
		
		pedidoMain = new Pedido();
		pedidoMain.setTamanho(thePedido.getTamanho());
		pedidoMain.setMassa(thePedido.getMassa());
		pedidoMain.setBorda(thePedido.getBorda());
		pedidoMain.setDividida(thePedido.getDividida());
		System.out.println("pedidomain "+pedidoMain.getDividida());
		//get user address
	    
	    //get logged username
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String loggedUser = authentication.getName();
	    System.out.println("cliente logado "+loggedUser);
	    Cliente loggedCliente = dao.getClienteByName(loggedUser);
	    System.out.println("pega endereco");
	    pedidoMain.setoEndereco(loggedCliente.getEndereco());
		
		
//		if (pedidoMain==null) {
//			//boolean firstRun = true;
//		}		
		
		theModel.addAttribute("pedidoParc", pedidoMain);
	    theModel.addAttribute("saboresOptions", saboresOptions); 
	    theModel.addAttribute("theAdicionalOptions", adicionalOptions);
	    theModel.addAttribute("theBebidaOptions", bebidaOptions);
	    
	    if (theBindingResult.hasErrors()) {
	    	System.out.println("lista de erros " +theBindingResult.getFieldErrors());
	    	System.out.println("nada");
	    	return "home";	    	
	    }else {
	    	return "pedido2";
	    }
		
	}
	
	@GetMapping("/processPedido2")
	public String showProcessPedido2(@ModelAttribute("pedido") Pedido thePedido, Model theModel) {
				
		System.out.println("<< processPedido2");
		System.out.println("sabor1 "+thePedido.getSabor1());
		System.out.println("sabor2 "+thePedido.getSabor2());
		System.out.println("sabor3 "+thePedido.getSabor3());		
		System.out.println("adicional "+thePedido.getAdicional());
		System.out.println("personalizar "+thePedido.getPersonalizar());		
		System.out.println("bebida "+thePedido.getBebida());
		System.out.println("endereco: "+thePedido.getSelectedAddress());
		//System.out.println("dividido process2 "+thePedido.getDividida());
		System.out.println("selectedaddress "+thePedido.getSelectedAddress());
				
	    theModel.addAttribute("saboresOptions", saboresOptions); 
	    theModel.addAttribute("theAdicionalOptions", adicionalOptions);
	    theModel.addAttribute("theBebidaOptions", bebidaOptions);
	    
		
		boolean flag = false;
		if (thePedido.getSabor1()!=null) {
			//1 sabor
			
			if (thePedido.getSabor1().equalsIgnoreCase("Selecione o sabor")) {
				theModel.addAttribute("erroSabor1", true);
				flag = true;
				System.out.println("erro1");
			}
		} 
		if (thePedido.getSabor2()!=null) {
			//2 sabores
			if (thePedido.getSabor2().equalsIgnoreCase("Selecione o sabor")) {
				theModel.addAttribute("erroSabor2", true);				
				flag = true;
				System.out.println("erro2");
			}
		} 
		if (thePedido.getSabor3()!=null) {
			//3 sabores
			if (thePedido.getSabor3().equalsIgnoreCase("Selecione o sabor")) {
				theModel.addAttribute("erroSabor3", true);
				flag = true;
				System.out.println("erro3");
			}
		} 
		if (thePedido.getSelectedAddress()==null) {
			System.out.println("selected address = null");
			theModel.addAttribute("erroAddress", true);
			flag = true;
		}

		if (flag == true) {
				System.out.println("retorna");
				theModel.addAttribute("pedidoParc", pedidoMain);
				System.out.println("ppppp "+pedidoMain);
				theModel.addAttribute("endereco", pedidoMain.getoEndereco());
				return "pedido2";
			} else {
				
				//Calculo do preço não está presente pois é definido por cada empresa
				pedidoMain.setSabor1(thePedido.getSabor1());
				pedidoMain.setSabor2(thePedido.getSabor2());
				pedidoMain.setSabor3(thePedido.getSabor3());
				pedidoMain.setAdicional(thePedido.getAdicional());
				pedidoMain.setPersonalizar(thePedido.getPersonalizar());
				pedidoMain.setBebida(thePedido.getBebida());
				pedidoMain.setPreco(0);
				pedidoMain.setPreco(calculaPreco(pedidoMain.getTamanho(), pedidoMain.getBorda(), pedidoMain.getAdicional(), pedidoMain.getBebida()));	
				
				
				pedidoMain.setSelectedAddress(thePedido.getSelectedAddress());
				theModel.addAttribute("pedidoCompl", pedidoMain);
				System.out.println("pedido confirmado: "+pedidoMain);
				
				return "confirmacaoPedido";
			}
		
	}
	
	@GetMapping("/pedidoCompleto")
	public String showPedidoCompleto(@ModelAttribute("pedido") Pedido thePedido, Model theModel) {
		System.out.println("---"+thePedido.getoEndereco());
		System.out.println("pedido do jsp: "+thePedido);
		//theModel.addAttribute("pedidoCompl", pedidoMain);
					
		try {
			if (thePedido.getoEndereco()==null && pedidoMain.getSelectedAddress().equalsIgnoreCase("outro")) {
				System.out.println("sem endereço");
				theModel.addAttribute("erroEndereco", true);	
				theModel.addAttribute("pedidoCompl", pedidoMain);
				return "confirmacaoPedido";
				
			} else if(pedidoMain.getSelectedAddress().equalsIgnoreCase("outro")) {
				pedidoMain.setoEndereco(thePedido.getoEndereco());
			}
		} catch (NullPointerException e) {
			//e.printStackTrace();
			theModel.addAttribute("pedidoCompl", tempPedido);
			theModel.addAttribute("id", tempPedido.getId());
			return "pedidoConfirmado";
		}
		
		
		System.out.println("Pedido após confirmação: "+pedidoMain);
		
		//get id do cliente logado
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String loggedUser = authentication.getName();	    
	    Cliente loggedCliente = dao.getClienteByName(loggedUser);
	    pedidoMain.setCliente(loggedCliente.getId());	    
	    System.out.println("cliente logado "+loggedUser);
		//agendado, em preparo, em viagem, pedido entregue
	    
	    
	    pedidoMain.setStatus("agendado");
	    int id = pDao.savePedido(pedidoMain);
	    theModel.addAttribute("id", id);
	    tempPedido = pedidoMain; 
	    theModel.addAttribute("pedidoCompl", tempPedido);
	    
	    pedidoMain = null;
		return "pedidoConfirmado";
	}
	
	@GetMapping("/acompanhaPedido")
	public String showAcompanhaPedido(Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String loggedUser = authentication.getName();
	    
	    List<Pedido> pedidos = pDao.getPedidosByUsername(loggedUser);
	    
	    //List pedidos = pDao.getPedidosById(dao.getClienteByName(loggedUser).getId());
	    
	    theModel.addAttribute("pedidos",pedidos);
		
		return "acompanhamentoPedido";
	}
	
	@GetMapping("/admin")
	public String showAdmin(Model theModel) {
				
		List<Pedido> pedidos = pDao.getPedidos();
	    //List pedidos = pDao.getPedidosById(dao.getClienteByName(loggedUser).getId());
	    theModel.addAttribute("pedidos", pedidos);
	    
		return "adminPedidos";
	}
	
	@GetMapping("/admin/changeStatus")
	public String changeStatus(@RequestParam("status") String status, @RequestParam("theId") int theId, Model theModel) {
				
		System.out.println("well done " +status+" theId "+theId);
		
		pDao.updatePedidoStatus(status, theId);
		List<Pedido> pedidos = pDao.getPedidos();
		theModel.addAttribute("pedidos", pedidos);
		return "adminPedidos";
	}
	
	public double calculaPreco(String tamanho, String borda, String adicional, String bebida) {
		
		double preco = 0;
		if (tamanho.equalsIgnoreCase("Broto")) {
			preco = 20;
		} else if (tamanho.equalsIgnoreCase("Medio")) {
			preco = 30;
		} else if (tamanho.equalsIgnoreCase("Grande")) {
			preco = 40;
		} else if (tamanho.equalsIgnoreCase("Familia")) {
			preco = 52;
		}
		System.out.println("preco tamanho "+preco);
		
		if (!borda.equalsIgnoreCase("Sem")) {
			preco +=5;
		}

		System.out.println("preço borda "+preco);
		if (adicional.equalsIgnoreCase("Batata-palha")) {
			preco += 2;
		} else if (adicional.equalsIgnoreCase("Batata-frita")) {
			preco += 5;
		} else if (adicional.equalsIgnoreCase("Bacon")) {
			preco += 6;
		} else if (adicional.equalsIgnoreCase("Cheddar")) {
			preco += 5;
		}
		System.out.println("preco adicional "+preco);	
		System.out.println("bebida "+bebida);
		if (bebida.substring(bebida.length()-4).equalsIgnoreCase("lata")) {
			System.out.println("bebida cortada: "+pedidoMain.getBebida().substring(pedidoMain.getBebida().length()-4));
			preco += 3;
		} else if (bebida.substring(bebida.length()-5).equalsIgnoreCase("600ml")) {
			System.out.println("bebida cortada: "+pedidoMain.getBebida().substring(pedidoMain.getBebida().length()-5));
			preco += 4;
		} else if (bebida.substring(bebida.length()-2).equalsIgnoreCase("2l")) {
			System.out.println("bebida cortada: "+pedidoMain.getBebida().substring(pedidoMain.getBebida().length()-2));
			preco += 7;				
		}
		System.out.println("preco bebida "+preco);
		
//		System.out.println("bebida cortada: "+pedidoMain.getBebida().substring(pedidoMain.getBebida().length()-4));
//	    System.out.println("bebida cortada: "+pedidoMain.getBebida().substring(pedidoMain.getBebida().length()-5));
//	    System.out.println("bebida cortada: "+pedidoMain.getBebida().substring(pedidoMain.getBebida().length()-2));
		
		return preco;
	}
}
