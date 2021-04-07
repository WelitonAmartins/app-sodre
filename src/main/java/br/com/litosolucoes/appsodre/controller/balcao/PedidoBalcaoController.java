package br.com.litosolucoes.appsodre.controller.balcao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.litosolucoes.appsodre.dto.PedidoBolcaoDTO;
import br.com.litosolucoes.appsodre.entity.PedidoBalcao;
import br.com.litosolucoes.appsodre.service.PedidoBalcaoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/pedido-balcao")
public class PedidoBalcaoController {
	
	@Autowired
	private PedidoBalcaoService pedidoBalcaoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoBalcao>> listarPedidosBalcao() {
		return ResponseEntity.ok(this.pedidoBalcaoService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<PedidoBalcao> buscarPorId(@PathVariable Integer codigo) {
		return ResponseEntity.ok(this.pedidoBalcaoService.bucarPorId(codigo).get() );
	}
	
	@PostMapping
	public ResponseEntity<PedidoBalcao> salvarPedido(@RequestBody PedidoBolcaoDTO param) throws Exception {
		return ResponseEntity.ok(this.pedidoBalcaoService.salvarPedidoBalcao(param));
	}
	
	
	@GetMapping("/relatorio/{codigo}")
	public ResponseEntity<PedidoBalcao> buscarRelatorioId(@PathVariable Integer codigo) throws Exception {
		return ResponseEntity.ok(this.pedidoBalcaoService.buscarRelatorioId(codigo));
	}
	


}
