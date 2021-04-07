package br.com.litosolucoes.appsodre.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "COD_PRODUTO")
	private Integer codigo;
	
	@Column(name = "NOME_PRODUTO")
	private String nome;

	@Column(name = "VALOR")
	private Double valor;
	
	@OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "COD_CATEGORIA", referencedColumnName = "COD_CATEGORIA")
	private Categoria categoria;
}