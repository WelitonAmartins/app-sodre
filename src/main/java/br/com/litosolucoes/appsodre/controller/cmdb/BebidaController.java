package br.com.litosolucoes.appsodre.controller.cmdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.litosolucoes.appsodre.entity.Bebida;
import br.com.litosolucoes.appsodre.service.BebidaService;

@RestController
@RequestMapping(value = "v1/bebida ")
public class BebidaController {

	@Autowired
	private BebidaService bebidaService;

	@GetMapping
	public ResponseEntity<List<Bebida>> listarBedidas() {
		return ResponseEntity.ok(this.bebidaService.listarBebidas());
	}

	@GetMapping(path = "{codigo}")
	public ResponseEntity<Bebida> buscarPeloId(@PathVariable Long codigo) {
		return ResponseEntity.ok(this.bebidaService.buscarBebidaId(codigo));
	}

	@PostMapping
	public ResponseEntity<Bebida> cadastrarBebida(@RequestBody Bebida bebida) {
		return ResponseEntity.ok(this.bebidaService.cadastrarBebida(bebida));
	}

	@DeleteMapping(path = "{codigo}")
	public ResponseEntity<Void> deletarBebida(@PathVariable Long codigo) {
		this.bebidaService.deletarBebida(codigo);
		return ResponseEntity.noContent().build();

	}
//	public ResponseEntity<Bebida> buscarPeloId(@PathVariable Long id)

}
