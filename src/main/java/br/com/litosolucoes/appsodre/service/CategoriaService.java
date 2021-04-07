package br.com.litosolucoes.appsodre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.entity.Categoria;
import br.com.litosolucoes.appsodre.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria salvarCategoria(Categoria param) {
		return this.categoriaRepository.save(param);
	}
	
	public List<Categoria> listarCategoria() {
		return this.categoriaRepository.findAll();
	}
	
	public Optional<Categoria> bucarPorId(Integer id) {
		return this.categoriaRepository.findById(id);
	}
	
	public void deletarCategoria(Integer id) {
		 this.categoriaRepository.deleteById(id);
	}

}
