package br.com.start.model.dto;


import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteEntradaDto {
	
	
	@Size( max=200, message="ERRO")
	private String nome;
	
	@Size( max=11, message="ERRO")
	private String cpf;


	@Size( max=5, message="ERRO")
	private String numeroConta;


	@NotNull
	private Long idBanco;


}
