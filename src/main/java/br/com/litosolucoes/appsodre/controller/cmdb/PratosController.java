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

import br.com.litosolucoes.appsodre.entity.Pratos;
import br.com.litosolucoes.appsodre.service.PratosService;

@RestController
@RequestMapping(value = "v1/prato")
public class PratosController {

	@Autowired
	private PratosService pratosService;

	@GetMapping
	public ResponseEntity<List<Pratos>> listarBedidas() {
		return ResponseEntity.ok(this.pratosService.listarPratos());
	}

	@GetMapping(path = "{codigo}")
	public ResponseEntity<Pratos> buscarPeloId(@PathVariable Long codigo) {
		return ResponseEntity.ok(this.pratosService.buscarPratoId(codigo));
	}

	@PostMapping
	public ResponseEntity<Pratos> cadastrarBebida(@RequestBody Pratos bebida) {
		return ResponseEntity.ok(this.pratosService.cadastrarPrato(bebida));
	}

	@DeleteMapping(path = "{codigo}")
	public ResponseEntity<Void> deletarBebida(@PathVariable Long codigo) {
		this.pratosService.deletarPratos(codigo);
		return ResponseEntity.noContent().build();

	}

}
