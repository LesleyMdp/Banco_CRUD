package br.com.start.model.dto;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BancoEntradaDto {
	
	
	@Size( max=200, message="ERRO, máximo permitido é 200 caracters")
	private String nome;
	
	
	@Size( max=200, message="ERRO, máximo permitido é 200 caracters")
	private String codigo;

}
