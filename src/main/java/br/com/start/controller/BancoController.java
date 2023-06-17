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

import br.com.start.model.dto.BancoEntradaDto;
import br.com.start.model.dto.BancoSaidaDto;
import br.com.start.service.BancoService;

@RestController
@RequestMapping("banco")

public class BancoController {

	@Autowired
	 BancoService service;


	@PostMapping
	public BancoSaidaDto criar(@RequestBody BancoEntradaDto entrada) {
		return service.criar(entrada);
	}

	@PutMapping("id/{id}")
	public void alterar(@PathVariable("id") Long id, @RequestBody BancoEntradaDto alterar) {
		service.alterar(id, alterar);
	}

	@GetMapping("id/{id}")
	public BancoSaidaDto pegarUm(@PathVariable("id") Long id) {
		return service.pegarUm(id);
	}

	@DeleteMapping("id/{id}")
	public void excluir(@PathVariable("id") Long id) {
		service.excluir(id);
	}

	@GetMapping
	public List<BancoSaidaDto> listar() {
		return service.listar();
	}
}
