package br.com.litosolucoes.appsodre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.entity.Bebida;
import br.com.litosolucoes.appsodre.repository.BebidaRepository;

@Service
public class BebidaService {

	@Autowired
	private BebidaRepository bebidaRepository;

	public Bebida cadastrarBebida(Bebida param) {
		return this.bebidaRepository.save(param);
	}

	public List<Bebida> listarBebidas() {
		return this.bebidaRepository.findAll();
	}

	public Bebida buscarBebidaId(Long id) {
		return this.bebidaRepository.findById(id).get();
	}

	public void deletarBebida(Long id) {
		this.bebidaRepository.deleteById(id);
	}

}
