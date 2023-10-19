package br.itb.projeto.lavanderiaPurgato.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.itb.projeto.lavanderiaPurgato.model.entity.Aluguel;
import br.itb.projeto.lavanderiaPurgato.model.entity.Maquina;
import br.itb.projeto.lavanderiaPurgato.model.repository.AluguelRepository;
import br.itb.projeto.lavanderiaPurgato.model.repository.MaquinaRepository;

@Service
public class MaquinaService {
	
	private MaquinaRepository maquinaRepository;
	
	private AluguelRepository aluguelRepository;


	 public MaquinaService(MaquinaRepository maquinaRepository, AluguelRepository aluguelRepository) {
		super();
		this.maquinaRepository = maquinaRepository;
		this.aluguelRepository = aluguelRepository;
	}

	public List<Maquina> findallDisponiveis(){
		return maquinaRepository.findByDisponibilidade("0");
	} 
	 
	 public List<Maquina> findallIndisponiveis(){
		return maquinaRepository.findByDisponibilidade("1");
	} 
	
	 public List<Aluguel> findIndisponiveis(){
		 List<Aluguel> alugueis = aluguelRepository.findAll();
		// List<Maquina> maquinasAlugadas = null;
		 
		 return aluguelRepository.findAll();
		
	}
	 public void excluirMaquina (Long id) {
		 maquinaRepository.deleteById(id);
		}
	 
	 @Transactional
		public Maquina save(Maquina maquina) {
			
			return maquinaRepository.save(maquina);
		}

	public Maquina findById(long id) {
		return maquinaRepository.findById(id).get();
	}
	
	
		
	

}
