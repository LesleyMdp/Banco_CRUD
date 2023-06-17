package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.model.Banco;
import br.com.start.model.dto.BancoEntradaDto;
import br.com.start.model.dto.BancoSaidaDto;
import br.com.start.repository.BancoRepository;

@Service
public class BancoService {
	
	@Autowired
	private BancoRepository repository;
	
		
	@Autowired
	private ModelMapper mapper;

	public BancoSaidaDto criar(BancoEntradaDto entrada) {
		Banco banco = mapper.map(entrada, Banco.class);

		Banco entityBanco = repository.save(banco);

		return mapper.map(entityBanco, BancoSaidaDto.class);

	}

	public void alterar(Long id, BancoEntradaDto alterar) {
		Optional<Banco> buscandoBanco = repository.findById(id);
		Banco entityBanco = buscandoBanco.get();
		mapper.map(alterar, entityBanco);
		
		repository.save(entityBanco);
	}

	public BancoSaidaDto pegarUm(Long id) {
		Optional<Banco> buscandoBanco = repository.findById(id);
		Banco entityBanco = buscandoBanco.get();
		return mapper.map(entityBanco, BancoSaidaDto.class);

	}

	public void excluir(Long id) {
		if (!repository.existsById(id)) {
		}
		repository.deleteById(id);
		
	}

	public List<BancoSaidaDto> listar() {
		List<Banco> listaBanco = repository.findAll();
		return mapper.map(listaBanco, new TypeToken<List<BancoSaidaDto>>() {}.getType());
	}

}
