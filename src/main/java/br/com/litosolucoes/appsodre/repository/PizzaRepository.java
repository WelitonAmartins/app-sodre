package br.com.litosolucoes.appsodre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.litosolucoes.appsodre.entity.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
