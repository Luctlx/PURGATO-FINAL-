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
import org.springframework.web.bind.annotation.RequestParam;

import br.itb.projeto.lavanderiaPurgato.model.entity.Aluguel;
import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;
import br.itb.projeto.lavanderiaPurgato.model.entity.Maquina;
import br.itb.projeto.lavanderiaPurgato.model.entity.Usuario;
import br.itb.projeto.lavanderiaPurgato.model.service.AluguelService;
import br.itb.projeto.lavanderiaPurgato.model.service.ClienteService;
import br.itb.projeto.lavanderiaPurgato.model.service.MaquinaService;
import br.itb.projeto.lavanderiaPurgato.model.service.UsuarioService;

@SuppressWarnings("unused")
@Controller
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/api/aluguel")
public class AluguelController {
	
	@Autowired
	UsuarioService mService;

	@Autowired
	AluguelService aluguelService;
	
	@Autowired
	MaquinaService maquinaService;
	
	@Autowired
	ClienteService clienteService;
	
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
	
	@GetMapping("/telacliente")
	public String telacliente() {
		return "telacliente";
	}
	
	@GetMapping("/telamaquinas")
	public String telamaquinas() {
		return "telamaquinas";
	}
	
	@GetMapping("/alugarmaquina")
	public String alugarmaquina() {
		return "alugarmaquina";
	}
	
	@GetMapping("/alugar")
	public String alugar() {
		return "alugar";
	}
	
	@PostMapping("/gravar")
	public String salvarAluguel(@ModelAttribute("aluguel") Aluguel aluguel) {
	    // Verifique se os dados do formulário estão corretos
	    if (aluguel.getMaquina() != null && aluguel.getData_lavagem() != null) {
	        // Restante do código para salvar o aluguel
	    } else {
	        // Lide com campos em branco ou inválidos, se necessário
	    }

	    return "redirect:/api/aluguel/alugar";
	}

}
