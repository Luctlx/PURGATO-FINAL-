package br.itb.projeto.lavanderiaPurgato.model.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.itb.projeto.lavanderiaPurgato.model.entity.Aluguel;
import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;
import br.itb.projeto.lavanderiaPurgato.model.entity.Maquina;
import br.itb.projeto.lavanderiaPurgato.model.entity.Usuario;
import br.itb.projeto.lavanderiaPurgato.model.service.AluguelService;
import br.itb.projeto.lavanderiaPurgato.model.service.MaquinaService;
import br.itb.projeto.lavanderiaPurgato.model.service.UsuarioService;

@SuppressWarnings("unused")
@Controller
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/api/Maquinas")
public class MaquinaController {
	
	@Autowired
	UsuarioService mService;
	
	@Autowired
	AluguelService aluguelService;
	
	@Autowired
	MaquinaService maquinaService;

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
	
	@GetMapping("/cadastromaquina")
	public String telacadastromaquina(ModelMap model,Maquina maquina) {

		model.addAttribute("maquina", new Maquina());

		return "cadastromaquina";
	}
	
	@GetMapping("/telaalugueis")
	public String telaalugueis(ModelMap model) {
		
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("aluguel", new Aluguel());
		model.addAttribute("maquinasD", maquinaService.findallDisponiveis());
		model.addAttribute("maquinasI", maquinaService.findIndisponiveis());
		
		return "telaalugueis";
	}
	
	@PostMapping("controleMaquina/{id}")
	public String excluirRegistrosMaquina(@PathVariable Long id) {
		
		
		maquinaService.excluirMaquina(id);
		
		
		return "redirect:/api/Maquinas/telaalugueis";
	}	
	
	@PostMapping("/gravar")
	public String salvar(ModelMap model, @ModelAttribute("maquina") Maquina maquina) {
	    Maquina _maquina = maquinaService.findById(maquina.getId());

	    if (_maquina == null) {
	        maquinaService.save(maquina);
	        model.addAttribute("maquina", new Maquina());
	    } else if (_maquina != null) {
	        model.addAttribute("maquina", new Maquina());
	    }

	    if (maquina.getMarca().equals("") || maquina.getCapacidade().equals("") || maquina.getDisponibilidade().equals("")) {
	        // Faça algo aqui
	    }

	    return "redirect:/api/Maquinas/telaalugueis";
	}

}
