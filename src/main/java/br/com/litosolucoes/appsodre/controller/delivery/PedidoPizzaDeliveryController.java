package br.com.litosolucoes.appsodre.controller.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.litosolucoes.appsodre.entity.Pedido;
import br.com.litosolucoes.appsodre.repository.PedidoPizzaDeliveryRepository;
import br.com.litosolucoes.appsodre.service.Auxiliar;

@RestController
@RequestMapping(value = "v1/pizza-delivery")
public class PedidoPizzaDeliveryController {
	@Autowired
	private Auxiliar auxiliar;

	@Autowired
	private PedidoPizzaDeliveryRepository pedidoPizzaDeliveryRepository;

	@GetMapping
	public ResponseEntity<byte[]> listaPedidos() throws Exception {
		auxiliar.imprimir2();
		
		byte[] gerarLancamento = auxiliar.gerarLancamento();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(gerarLancamento);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> solicitarPedido(@RequestBody Pedido pedido) {
		return ResponseEntity.ok(this.pedidoPizzaDeliveryRepository.save(pedido));
	}
}
