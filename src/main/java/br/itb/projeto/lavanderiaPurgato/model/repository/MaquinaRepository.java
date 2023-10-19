package br.itb.projeto.lavanderiaPurgato.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.itb.projeto.lavanderiaPurgato.model.entity.Maquina;

@Repository
public interface MaquinaRepository 
         extends JpaRepository<Maquina, Long>{
	
	List<Maquina> findByDisponibilidade(String disponibilidade);
	
	/*@Query("SELECT u From Usuario u WHERE u.cpf =:usuarioCpf")
	Usuario findByCpf(@Param("usuarioCpf") String usuarioCpf);*/
	

	/* Cliente findByCpf(String cpf); */
	
	Maquina findById(String id);

}
