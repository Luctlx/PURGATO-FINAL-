package br.itb.projeto.lavanderiaPurgato.model.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;
import br.itb.projeto.lavanderiaPurgato.model.entity.Usuario;
import br.itb.projeto.lavanderiaPurgato.model.service.UsuarioService;

@SuppressWarnings("unused")
@Controller
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	UsuarioService mService;

	private String msg = null;
	
	@GetMapping("/index")
	public String login(ModelMap model) {
		
		model.addAttribute("usuario", new Usuario());
		
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@GetMapping("/telainicial")
	public String telainicial() {
		return "telainicial";
	}
	
	@PostMapping("/acessar")
	public String realizaLogin(ModelMap model, HttpSession session,
			@RequestParam("cpf") String cpf, @RequestParam("senha") String senha) {
		
	
		Usuario mUsuario = mService.procurarPorCpf(cpf, senha);
		
	
		if(mUsuario != null) {
		
			session.setAttribute("mUsuario", mUsuario);
			return "redirect:/api/login/telainicial";
			
		} 
		
		msg = "Dados Incorretos!";
		model.addAttribute("msg", msg);
				
		return "redirect:/api/login/index";
	}
	
	@GetMapping("/telacliente")
	public String telacliente() {
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
	
	@GetMapping("/telafuncionario")
	public String telafuncionario(Model model, Usuario usuario) {
		
		model.addAttribute("usuarios", mService.findall());

		return "telafuncionario";
	}
	

	
	
	@GetMapping("/cadastro")
	public String telacadastro() {
		return "cadastro";
	}
	
	
}
