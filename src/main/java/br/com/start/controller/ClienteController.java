package br.com.start.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.start.model.dto.ClienteEntradaDto;
import br.com.start.model.dto.ClienteSaidaDto;
import br.com.start.repository.ClienteRepository;
import br.com.start.service.ClienteService;

@RestController
@RequestMapping("cliente")

public class ClienteController {

	@Autowired
	ClienteService service;
	
	@Autowired
	ClienteRepository repository; 

	@PostMapping
	public ClienteSaidaDto criar(@RequestBody ClienteEntradaDto entrada) {
		return service.criar(entrada);
	}

	@PutMapping("id/{id}")
	public void alterar( @PathVariable ("id") Long id, @RequestBody ClienteEntradaDto alterar) {
		service.alterar(id, alterar);
	}

	@GetMapping("id/{id}")
	public ClienteSaidaDto pegarUm(@PathVariable ("id") Long id) {
		return service.pegarUm(id);
	}
	


	@DeleteMapping ("id/{id}")
	public void excluir(@PathVariable ("id") Long id) {
		service.excluir(id);
	}

	@GetMapping 
	public List<ClienteSaidaDto> listar() {
		return service.listar();
	}
	
	

}
