package br.itb.projeto.lavanderiaPurgato.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;
import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;
import br.itb.projeto.lavanderiaPurgato.model.service.ClienteService;

@SuppressWarnings("unused")
@Controller
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService mService;

	private String msg = null;
	
	@GetMapping("/index")
	public String index(ModelMap model) {
		
		model.addAttribute("cliente", new Cliente());
		
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@GetMapping("/telainicial")
	public String telainicial() {
		return "telainicial";
	}
	
	
	@GetMapping("/telacliente")
	public String telacliente(ModelMap model, Cliente cliente) {
		
		model.addAttribute("clientes", mService.findall());
		return "telacliente";
	}
	
	@GetMapping("/telaalugueis")
	public String telaalugueis() {
		return "telaalugueis";
	}
	
	@GetMapping("/telamaquinas")
	public String telamaquinas() {
		return "telamaquinas";
	}
	
	@GetMapping("/cadastro")
	public String telacadastro(ModelMap model) {

		model.addAttribute("cliente", new Cliente());

		return "cadastro";
	}
	
	@PostMapping("/gravar")
	public String salvar(ModelMap model,
			@ModelAttribute("cliente") Cliente cliente) {
		
		Cliente _cliente = mService.findByEmail(cliente.getEmail());
		
		if (_cliente == null) {
			
			mService.save(cliente);
			model.addAttribute("cliente", new Cliente());
			//serverMessage = "Usuário cadastrado com sucesso!!!";
			
		} else if (_cliente != null) {
			
			model.addAttribute("cliente", new Cliente());
			//serverMessage = "Usuário já foi cadastrado no sitema!";	
			
		}
		
		if (cliente.getNome().equals("") || cliente.getEmail().equals("") || cliente.getSenha().equals("")) {
			
			//serverMessage = "Dados Incompletos!!!";	
			
		} 
	
		return "redirect:/api/cliente/telacliente";
	}
	
	@PostMapping("controleCliente/{id}")
	public String excluirRegistrosCliente(@PathVariable Long id) {

		

		mService.excluirCliente(id);
	

		return "redirect:/api/cliente/telacliente";

	}	
	@PostMapping("Admin")
	public String atualizarCliente(@ModelAttribute Cliente cliente) {

			mService.atualizarCliente(cliente);


		return "redirect:/api/cliente/telacliente";

	}
}


