package br.com.litosolucoes.appsodre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.entity.Pizza;
import br.com.litosolucoes.appsodre.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;

	public Pizza cadastrarPizza(Pizza param) {
		return this.pizzaRepository.save(param);
	}

	public List<Pizza> listarPizzas() {
		return this.pizzaRepository.findAll();
	}

	public Pizza buscarPizzaId(Long id) {
		return this.pizzaRepository.findById(id).get();
	}

	public void deletarPizza(Long id) {
		this.pizzaRepository.deleteById(id);
	}
}
