package br.com.litosolucoes.appsodre.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PEDIDO_BALCAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoBalcao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_PEDIDO_BALCAO")
	private Long codigo;

	@Column(name = "DT_PEDIDO")
	private LocalDateTime dtPedido;

	@Column(name = "NOME")
	private String nome;
//	@OneToOne
//	@JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")
//	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "ITEM_PEDIDO", joinColumns = { @JoinColumn(name = "COD_PEDIDO") }, inverseJoinColumns = {
			@JoinColumn(name = "COD_PRODUTO") })
	private List<Produto> produto;

}
