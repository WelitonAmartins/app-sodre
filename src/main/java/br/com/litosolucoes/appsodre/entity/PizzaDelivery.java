package br.com.litosolucoes.appsodre.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PEDIDO_PIZZA_DELIVERY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDelivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_PEDIDO")
	private Long codigo;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "ENDERECO")
	private String endereco;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "DT_PEDIDO")
	private LocalDateTime dtPedido;

	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PedidoPizzaDelivery> pedidoPizzaDelivery = new ArrayList<>();

}
