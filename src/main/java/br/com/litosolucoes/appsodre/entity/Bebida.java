package br.com.litosolucoes.appsodre.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "BEBIDA")
public class Bebida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO")
	private Long codigo;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "VALOR")
	private Double valor;
}
