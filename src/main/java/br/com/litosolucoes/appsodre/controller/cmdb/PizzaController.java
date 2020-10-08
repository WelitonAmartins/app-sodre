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

import br.com.litosolucoes.appsodre.entity.Pizza;
import br.com.litosolucoes.appsodre.service.PizzaService;

@RestController
@RequestMapping(value = "v1/pizza")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;

	@GetMapping
	public ResponseEntity<List<Pizza>> listarBedidas() {
		return ResponseEntity.ok(this.pizzaService.listarPizzas());
	}

	@GetMapping(path = "{codigo}")
	public ResponseEntity<Pizza> buscarPeloId(@PathVariable Long codigo) {
		return ResponseEntity.ok(this.pizzaService.buscarPizzaId(codigo));
	}

	@PostMapping
	public ResponseEntity<Pizza> cadastrarBebida(@RequestBody Pizza bebida) {
		return ResponseEntity.ok(this.pizzaService.cadastrarPizza(bebida));
	}

	@DeleteMapping(path = "{codigo}")
	public ResponseEntity<Void> deletarBebida(@PathVariable Long codigo) {
		this.pizzaService.deletarPizza(codigo);
		return ResponseEntity.noContent().build();

	}
}
