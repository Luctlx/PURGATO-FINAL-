package br.itb.projeto.lavanderiaPurgato.model.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.itb.projeto.lavanderiaPurgato.model.entity.Usuario;
import br.itb.projeto.lavanderiaPurgato.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findall(){
		return usuarioRepository.findAll();
	}
	
	public Usuario procurarPorCpf(String cpf, String senha) {
		Usuario usuario = usuarioRepository.findByCpf(cpf);	
		
		if (usuario != null) {
			if (usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		
		return null;
		
	}
	
	@Transactional
	public Usuario save(Usuario usuario) {
		
		usuario.setSenha("12345678");
		
		return usuarioRepository.save(usuario);
	}

	public Usuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByEmail(email);
	}
public void excluirUsuario(Long id) {

		

		usuarioRepository.deleteById(id);
	

	}

public Usuario atualizarUsuario(Usuario usuarioAtualizado) {

    // Encontre o usuario existente por email

    Usuario usuarioExistente = usuarioRepository.findById(usuarioAtualizado.getId()).orElse(null);



    if (usuarioExistente != null) {

        // Atualize as propriedades do usuario existente com as novas informações

        usuarioExistente.setNome(usuarioAtualizado.getNome());

        usuarioExistente.setCpf(usuarioAtualizado.getCpf());
        
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        
        usuarioExistente.setNivel_acesso(usuarioAtualizado.getNivel_acesso());

        usuarioExistente.setStatus_Func(usuarioAtualizado.getStatus_Func());

        

        

        // Salve o usuario atualizado

        return usuarioRepository.save(usuarioExistente);

    } else {

        // Lide com o caso em que o usuario não foi encontrado (pode ser um erro ou uma nova inserção)

        // Neste exemplo, lançamos uma exceção, mas você pode ajustar conforme necessário.

        throw new EntityNotFoundException("Usuario não encontrado");

    }
    
}

}
