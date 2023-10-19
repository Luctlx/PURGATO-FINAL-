package br.itb.projeto.lavanderiaPurgato.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;

@Repository
public interface ClienteRepository 
         extends JpaRepository<Cliente, Long>{
	
	/*@Query("SELECT u From Usuario u WHERE u.cpf =:usuarioCpf")
	Usuario findByCpf(@Param("usuarioCpf") String usuarioCpf);*/
	

	Cliente findByCpf(String cpf);

	Cliente findByEmail(String email);

}
