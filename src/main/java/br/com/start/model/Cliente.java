package br.com.start.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity

public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String nome;
	
	@Column(nullable = true,unique = true, length = 11)
	private String cpf;

	@Column(name = "numero_conta",nullable = false,unique = true, length = 5)
	private String numeroConta;
	
	@ManyToOne
	@JoinColumn(name = "id_banco")
	private Banco banco;
	

	

}

