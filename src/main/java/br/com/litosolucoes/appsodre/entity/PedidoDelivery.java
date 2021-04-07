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
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PEDIDO_DELIVERY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDelivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "COD_PEDIDO_DELIVERY")
	private Integer codigo;

	@Column(name = "DT_PEDIDO")
	private LocalDateTime dtPedido;
	
	@Column(name = "NOME")
	private String nome;

	@OneToOne
    @JoinColumn(name = "COD_ENDERECO", referencedColumnName = "COD_ENDERECO")
	private Endereco endereco;
	
	@ManyToMany
	@JoinTable(name = "ITEM_PEDIDO_DELIVERY", joinColumns = { @JoinColumn(name = "COD_PEDIDO_DELIVERY") }, inverseJoinColumns = {
			@JoinColumn(name = "COD_PRODUTO") })
	private List<Produto> listaProdutos;

}
