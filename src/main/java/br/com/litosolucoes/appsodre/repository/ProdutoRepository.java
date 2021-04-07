package br.com.litosolucoes.appsodre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.litosolucoes.appsodre.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
//	@Query("delete from Produto p where p.codigo = 1")
//	public void deletarEssaMerda(Integer id);

	
}
