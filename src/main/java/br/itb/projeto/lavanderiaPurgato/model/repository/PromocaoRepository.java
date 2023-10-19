package br.itb.projeto.lavanderiaPurgato.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.itb.projeto.lavanderiaPurgato.model.entity.Promocao;

@Repository
public interface PromocaoRepository 
         extends JpaRepository<Promocao, Long>{
	
	List<Promocao> findById(String id);
}
