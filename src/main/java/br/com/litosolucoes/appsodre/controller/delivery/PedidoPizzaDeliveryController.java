package br.com.litosolucoes.appsodre.controller.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.litosolucoes.appsodre.entity.PizzaDelivery;
import br.com.litosolucoes.appsodre.repository.PedidoPizzaDeliveryRepository;

@RestController
@RequestMapping(value = "v1/pizza-delivery")
public class PedidoPizzaDeliveryController {

	@Autowired
	private PedidoPizzaDeliveryRepository pedidoPizzaDeliveryRepository;

	@GetMapping
	public List<PizzaDelivery> listaPedidos() {
		return this.pedidoPizzaDeliveryRepository.findAll();
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PizzaDelivery> solicitarPedido(@RequestBody PizzaDelivery pedido) {
		return ResponseEntity.ok(this.pedidoPizzaDeliveryRepository.save(pedido));
	}
}
