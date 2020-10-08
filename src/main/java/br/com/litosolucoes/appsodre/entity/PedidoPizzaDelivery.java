package br.com.litosolucoes.appsodre.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PIZZA_DELIVERY")
@Data
@NoArgsConstructor
public class PedidoPizzaDelivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "COD_PEDIDO")
	private PizzaDelivery pedido;

	@ManyToOne
	@JoinColumn(name = "COD_BEBIDA")
	private Bebida bebida;

	@ManyToOne
	@JoinColumn(name = "COD_PIZZA")
	private Pizza pizza;

}
