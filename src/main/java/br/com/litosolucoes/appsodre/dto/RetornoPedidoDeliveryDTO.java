package br.com.litosolucoes.appsodre.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoPedidoDeliveryDTO {

	private String nome;
	private List<ProdutoDTO> produto;
	private String observacao;
	private String endereco;
	private String numero;
	private String bairro;
	private String complemento;
	private double total;
}
