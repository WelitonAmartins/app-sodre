package br.com.litosolucoes.appsodre.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoBolcaoDTO {
	
	private String nome;
	private Integer flMesa;
	private List<Integer> codProduto;

}
