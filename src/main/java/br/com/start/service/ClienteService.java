package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.model.Banco;
import br.com.start.model.Cliente;

import br.com.start.model.dto.ClienteEntradaDto;
import br.com.start.model.dto.ClienteSaidaDto;
import br.com.start.repository.BancoRepository;
import br.com.start.repository.ClienteRepository;

@Service

public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BancoRepository bancoRepository;


	@Autowired
	private ModelMapper mapper;

	public ClienteSaidaDto criar(ClienteEntradaDto entrada) {

		Cliente entity = mapper.map(entrada, Cliente.class);
		
		Optional<Banco> buscandoBanco = bancoRepository.findById(entrada.getIdBanco());
	    if (buscandoBanco.isPresent()) {
	        Banco banco = buscandoBanco.get();
	        entity.setBanco(banco);
	    }

		Cliente entityBanco = clienteRepository.save(entity);

		return mapper.map(entityBanco, ClienteSaidaDto.class);
	}

	public void alterar(Long id, ClienteEntradaDto alterar) {
		
		Optional<Cliente> buscandoCliente = clienteRepository.findById(id);

		Cliente entityBanco = buscandoCliente.get();
		mapper.map(alterar, entityBanco);

		clienteRepository.save(entityBanco);
		
	}
		


	public ClienteSaidaDto pegarUm(Long id) {
		Optional<Cliente> buscandoCliente = clienteRepository.findById(id);

		Cliente entityBanco = buscandoCliente.get();
		return mapper.map(entityBanco, ClienteSaidaDto.class);
	}

	public void excluir(Long id) {

		clienteRepository.deleteById(id);
	}

	public List<ClienteSaidaDto> listar() {
		List<Cliente> listaClientes = clienteRepository.findAll();
		return mapper.map(listaClientes, new TypeToken<List<ClienteSaidaDto>>() {}.getType());
	}


}
