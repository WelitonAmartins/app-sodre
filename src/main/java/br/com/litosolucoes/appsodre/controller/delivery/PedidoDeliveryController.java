package br.com.litosolucoes.appsodre.controller.delivery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.litosolucoes.appsodre.dto.PedidoDeliveryDTO;
import br.com.litosolucoes.appsodre.dto.RetornoPedidoDeliveryDTO;
import br.com.litosolucoes.appsodre.entity.PedidoBalcao;
import br.com.litosolucoes.appsodre.entity.PedidoDelivery;
import br.com.litosolucoes.appsodre.service.PedidoDeliveryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/pedido-delivery")
public class PedidoDeliveryController {
	
	@Autowired
	private PedidoDeliveryService pedidoDeliveryService;
	
	@GetMapping
	public ResponseEntity<List<PedidoDelivery>> listarPedidosDelivery() {
		return ResponseEntity.ok(this.pedidoDeliveryService.listar());
	}

	@PostMapping
	public ResponseEntity<RetornoPedidoDeliveryDTO> salvarPedido(@RequestBody PedidoDeliveryDTO param) throws Exception {
		return ResponseEntity.ok(this.pedidoDeliveryService.salvarPedidoDelivery(param));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<PedidoDelivery> buscarPedidoDelivery(@PathVariable Integer codigo) {
		return ResponseEntity.ok(this.pedidoDeliveryService.bucarPorId(codigo).get());
	}
	
	@GetMapping("/relatorio/{codigo}")
	public ResponseEntity<PedidoDelivery> buscarRelatorioId(@PathVariable Integer codigo) throws Exception {
		return ResponseEntity.ok(this.pedidoDeliveryService.buscarRelatorioId(codigo));
	}
}
