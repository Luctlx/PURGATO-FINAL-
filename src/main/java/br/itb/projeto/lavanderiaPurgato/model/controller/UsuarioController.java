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

import br.itb.projeto.lavanderiaPurgato.model.entity.Usuario;
import br.itb.projeto.lavanderiaPurgato.model.service.UsuarioService;

@SuppressWarnings("unused")
@Controller
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService mService;

	private String msg = null;
	
	@GetMapping("/index")
	public String index(ModelMap model) {
		
		model.addAttribute("usuario", new Usuario());
		
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@GetMapping("/telainicial")
	public String telainicial() {
		return "telainicial";
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
	public String telafuncionario(ModelMap model) {
		
		model.addAttribute("usuarios", mService.findall());
		System.out.println("Aqui");
		return "telafuncionario";
	}
	
	@GetMapping("/cadastrofuncionario")
	public String telacadastrofuncionario(ModelMap model) {

		model.addAttribute("usuario", new Usuario());

		return "cadastrofuncionario";
	}
		
	@PostMapping("/gravar")
	public String salvar(ModelMap model,
			@ModelAttribute("usuario") Usuario usuario) {
		
		Usuario _usuario = mService.findByEmail(usuario.getEmail());
		
		if (_usuario == null) {
			
			mService.save(usuario);
			model.addAttribute("usuario", new Usuario());
			//serverMessage = "Usuário cadastrado com sucesso!!!";
			
		} else if (_usuario != null) {
			
			model.addAttribute("usuario", new Usuario());
			//serverMessage = "Usuário já foi cadastrado no sistema!";	
			
		}
		
		if (usuario.getNome().equals("") || usuario.getEmail().equals("") || usuario.getSenha().equals("")) {
			
			//serverMessage = "Dados Incompletos!!!";	
			
		} 
	
		return "redirect:/api/usuario/telafuncionario";
	}
	
	@PostMapping("controleUsuario/{id}")
	public String excluirRegistrosUsuario(@PathVariable Long id) {

		

		mService.excluirUsuario(id);
	

		return "redirect:/api/usuario/telafuncionario";

	}	
	@PostMapping("/Adm")
	public String atualizarUsuario(@ModelAttribute Usuario usuario) {

			mService.atualizarUsuario(usuario);


		return "redirect:/api/usuario/telafuncionario";

	}
	
	

	
}

	

