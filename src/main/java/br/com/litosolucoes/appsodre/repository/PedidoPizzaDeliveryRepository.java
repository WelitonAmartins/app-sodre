package br.com.litosolucoes.appsodre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.litosolucoes.appsodre.entity.PizzaDelivery;

@Repository
public interface PedidoPizzaDeliveryRepository extends JpaRepository<PizzaDelivery, Long> {

}
