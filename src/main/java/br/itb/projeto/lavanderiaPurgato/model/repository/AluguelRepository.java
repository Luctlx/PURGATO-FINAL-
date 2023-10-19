package br.itb.projeto.lavanderiaPurgato.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.lavanderiaPurgato.model.entity.Aluguel;
import br.itb.projeto.lavanderiaPurgato.model.entity.Maquina;

@Repository
public interface AluguelRepository 
         extends JpaRepository<Aluguel, Long>{
	
	/*@Query("SELECT u From Aluguel u WHERE u.id =:usuarioId")
	Aluguel findByCpf(@Param("usuarioCpf") String usuarioId);*/
	
	List<Maquina> findByMaquina(Maquina maquina);
	
}
