package br.itb.projeto.lavanderiaPurgato.model.service;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import br.itb.projeto.lavanderiaPurgato.model.entity.Promocao;
import br.itb.projeto.lavanderiaPurgato.model.repository.PromocaoRepository;

@Service
public class PromocaoService {
	
	private PromocaoRepository promocaoRepository;

	public PromocaoService(PromocaoRepository promocaoRepository) {
		super();
		this.promocaoRepository = promocaoRepository;
	}

	 public List<Promocao> findall(){
		return promocaoRepository.findAll();
	} 

	 @Transactional
		public Promocao save(Promocao promocao) {
			
			return promocaoRepository.save(promocao);
		}
	 	
		public Promocao findById(long id) {
			return promocaoRepository.findById(id).get();
		}
		
	public void excluirPromocao(Long id) {
		promocaoRepository.deleteById(id);
	}

	public Promocao atualizarPromocao(Promocao promocaoAtualizado) {

		Promocao promocaoExistente = promocaoRepository.findById(promocaoAtualizado.getId()).orElse(null);

 

        if (promocaoExistente != null) {

            // Atualize as propriedades do cliente existente com as novas informações

        	promocaoExistente.setNome(promocaoAtualizado.getNome());

        	promocaoExistente.setDescricao(promocaoAtualizado.getDescricao());
            
        	promocaoExistente.setPreco(promocaoAtualizado.getPreco());

        	promocaoExistente.setData_validade(promocaoAtualizado.getData_validade());

            
            return promocaoRepository.save(promocaoAtualizado);

        } else {
        	
            throw new EntityNotFoundException("Cliente não encontrado");

        }

	}
}