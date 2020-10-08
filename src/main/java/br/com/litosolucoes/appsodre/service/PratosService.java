package br.com.litosolucoes.appsodre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.entity.Pratos;
import br.com.litosolucoes.appsodre.repository.PratosRepository;

@Service
public class PratosService {

	@Autowired
	private PratosRepository pratosRepository;

	public Pratos cadastrarPrato(Pratos param) {
		return this.pratosRepository.save(param);
	}

	public List<Pratos> listarPratos() {
		return this.pratosRepository.findAll();
	}

	public Pratos buscarPratoId(Long id) {
		return this.pratosRepository.findById(id).get();
	}

	public void deletarPratos(Long id) {
		this.pratosRepository.deleteById(id);
	}
}
