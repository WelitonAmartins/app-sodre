package br.com.litosolucoes.appsodre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.entity.Categoria;
import br.com.litosolucoes.appsodre.entity.Produto;
import br.com.litosolucoes.appsodre.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Produto salvar(Produto param) {
		
		Optional<Categoria> cat = this.categoriaService.bucarPorId(param.getCategoria().getCodigo());
		
		param.setCategoria(cat.get());
		return this.produtoRepository.save(param);
	}
	
	public List<Produto> listarProdutos() {
		return this.produtoRepository.findAll();
	}
	
	public Optional<Produto> bucarPorId(Integer id) {
		return this.produtoRepository.findById(id);
	}
	
	public void deletarProduto(Produto param) {
		 this.produtoRepository.delete(param);
	}

}
