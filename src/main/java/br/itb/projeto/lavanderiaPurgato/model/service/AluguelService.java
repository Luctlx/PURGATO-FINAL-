package br.itb.projeto.lavanderiaPurgato.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.itb.projeto.lavanderiaPurgato.model.entity.Aluguel;
import br.itb.projeto.lavanderiaPurgato.model.repository.AluguelRepository;
import br.itb.projeto.lavanderiaPurgato.model.repository.ClienteRepository;
import br.itb.projeto.lavanderiaPurgato.model.repository.MaquinaRepository;




@Service
public class AluguelService {
	
	private AluguelRepository aluguelRepository;
	
	private ClienteRepository clienteRepository;
	
	private MaquinaRepository maquinaRepository;

	public AluguelService(AluguelRepository aluguelRepository, ClienteRepository clienteRepository,
			MaquinaRepository maquinaRepository) {
		super();
		this.aluguelRepository = aluguelRepository;
		this.clienteRepository = clienteRepository;
		this.maquinaRepository = maquinaRepository;
	}

	public List<Aluguel> findall(){
		return aluguelRepository.findAll();
	} 
	
	@Transactional
	public Aluguel save(Aluguel aluguel) {
		
		aluguel.getMaquina().setDisponibilidade("1");;
		
		LocalDate dataAtual = LocalDate.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Defina o formato desejado
        String dataFormatada = dataAtual.format(formatter);
		
        aluguel.setData_lavagem(dataFormatada);
        
		return aluguelRepository.save(aluguel);
	}

}
