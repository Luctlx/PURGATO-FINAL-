package br.itb.projeto.lavanderiaPurgato.model.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.itb.projeto.lavanderiaPurgato.model.entity.Cliente;
import br.itb.projeto.lavanderiaPurgato.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> findall(){
		return clienteRepository.findAll();
	}
	
	public Cliente procurarPorCpf(String cpf) {
		Cliente cliente = clienteRepository.findByCpf(cpf);		
		return cliente;
		
	}
	
	@Transactional
	public Cliente save(Cliente cliente) {
		
		cliente.setSenha("12345678");
		
		return clienteRepository.save(cliente);
	}

	public Cliente findByEmail(String email) {
		// TODO Auto-generated method stub
		return clienteRepository.findByEmail(email);
	}
	
	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente atualizarCliente(Cliente clienteAtualizado) {

        // Encontre o cliente existente por email

        Cliente clienteExistente = clienteRepository.findById(clienteAtualizado.getId()).orElse(null);

 

        if (clienteExistente != null) {

            // Atualize as propriedades do cliente existente com as novas informações

            clienteExistente.setNome(clienteAtualizado.getNome());

            clienteExistente.setCpf(clienteAtualizado.getCpf());
            
            clienteExistente.setTelefone(clienteAtualizado.getTelefone());
            
            clienteExistente.setSenha(clienteAtualizado.getSenha());

            clienteExistente.setEmail(clienteAtualizado.getEmail());


            

            

            // Salve o cliente atualizado

            return clienteRepository.save(clienteExistente);

        } else {

            // Lide com o caso em que o cliente não foi encontrado (pode ser um erro ou uma nova inserção)

            // Neste exemplo, lançamos uma exceção, mas você pode ajustar conforme necessário.

            throw new EntityNotFoundException("Cliente não encontrado");

        }

    }

	public Cliente findById(long id) {
		return clienteRepository.findById(id).get();
	}
}
