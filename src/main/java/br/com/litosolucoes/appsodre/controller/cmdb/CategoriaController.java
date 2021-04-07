package br.com.litosolucoes.appsodre.controller.cmdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.litosolucoes.appsodre.entity.Categoria;
import br.com.litosolucoes.appsodre.service.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listarCategoria() {
		return ResponseEntity.ok(this.categoriaService.listarCategoria());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPorIdCategoria(@PathVariable Integer codigo) {
		return ResponseEntity.ok(this.categoriaService.bucarPorId(codigo).get() );
	}
	
	@PostMapping
	public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria param) {
		return ResponseEntity.ok(this.categoriaService.salvarCategoria(param));
	}
	
	@DeleteMapping(path = "/{codigo}")
	public ResponseEntity<Void> deletarCategoria(@PathVariable Integer codigo) {
		this.categoriaService.deletarCategoria(codigo);
		return ResponseEntity.noContent().build();
	}
	


}
