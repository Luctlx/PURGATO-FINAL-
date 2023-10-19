package br.itb.projeto.lavanderiaPurgato.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.lavanderiaPurgato.model.entity.Usuario;

@Repository
public interface UsuarioRepository 
         extends JpaRepository<Usuario, Long>{
	
	/*@Query("SELECT u From Usuario u WHERE u.cpf =:usuarioCpf")
	Usuario findByCpf(@Param("usuarioCpf") String usuarioCpf);*/
	

	Usuario findByCpf(String cpf);
	
	Usuario findByEmail(String email);

}
