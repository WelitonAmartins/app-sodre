package br.com.litosolucoes.appsodre.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ENDERECO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_ENDERECO")
	private Long codigo;

	@Column(name = "ENDERECO")
	private String endereco;
	
	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;
}
