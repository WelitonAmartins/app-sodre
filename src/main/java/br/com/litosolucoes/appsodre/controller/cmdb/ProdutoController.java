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

import br.com.litosolucoes.appsodre.entity.Produto;
import br.com.litosolucoes.appsodre.service.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos() {
		return ResponseEntity.ok(this.produtoService.listarProdutos());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> buscarPorIdCategoria(@PathVariable Integer codigo) {
		return ResponseEntity.ok(this.produtoService.bucarPorId(codigo).get() );
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvarCategoria(@RequestBody Produto param) {
		return ResponseEntity.ok(this.produtoService.salvar(param));
	}
	
	@PostMapping("/deletar")
	public ResponseEntity<Void> deletarCategoria(@RequestBody Produto param) {
		this.produtoService.deletarProduto(param);
		return ResponseEntity.noContent().build();
	}
}
