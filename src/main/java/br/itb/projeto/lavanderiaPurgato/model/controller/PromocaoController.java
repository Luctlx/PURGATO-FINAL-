package br.itb.projeto.lavanderiaPurgato.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;
import br.itb.projeto.lavanderiaPurgato.model.entity.Promocao;
import br.itb.projeto.lavanderiaPurgato.model.service.PromocaoService;

@SuppressWarnings("unused")
@Controller
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/api/promocao")
public class PromocaoController {
	
	@Autowired
	PromocaoService mService;

	private String msg = null;
	
	
	@GetMapping("/telainicial")
	public String telainicial() {
		return "telainicial";
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
	
	@GetMapping("/cadastro")
	public String telacadastro() {
		return "cadastro";
	}
	

	@GetMapping("/telapromocoes")
	public String promocoes(Model model, Promocao promocao) {
		
		model.addAttribute("promocoes", mService.findall());	
		return "telapromocoes";
	}
	
	@GetMapping("/cadastropromocoes")
	public String telacadastropromocoes(ModelMap model) {
	    model.addAttribute("promocao", new Promocao());
	    return "cadastropromocoes";
	}

	@PostMapping("/gravar")
	public String salvar(ModelMap model,
			@ModelAttribute("promocao") Promocao promocao) {
		
		Promocao _promocao = mService.findById(promocao.getId());
		
		if (_promocao == null) {
			
			mService.save(promocao);
			model.addAttribute("promocao", new Promocao());
			//serverMessage = "Promoção cadastrada com sucesso!!!";
			
		} else if (_promocao != null) {
			
			model.addAttribute("promocao", new Promocao());
			//serverMessage = "Promoção já foi cadastrada no sistema!";	
			
		}
		
		if (promocao.getNome().equals("") || promocao.getDescricao().equals("") || promocao.getData_validade().equals("") || promocao.getPreco().equals("")) {
			
			//serverMessage = "Dados Incompletos!!!";	
			
		} 
	
		return "redirect:/api/promocao/telapromocoes";
	}
	
	
	@PostMapping("controlePromocao/{id}")
	public String excluirRegistrosPromocao(@PathVariable Long id) {

		

		mService.excluirPromocao(id);
	

		return "redirect:/api/promocao/telapromocoes";

	}	
	@PostMapping("Admin")
	public String atualizarPromocao(@ModelAttribute Promocao promocao) {

			mService.atualizarPromocao(promocao);


		return "redirect:/api/promocao/telapromocoes";

	}
}


