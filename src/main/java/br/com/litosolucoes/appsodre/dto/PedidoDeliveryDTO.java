package br.com.litosolucoes.appsodre.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDeliveryDTO {

	private String nome;
	private List<Integer> codProduto;
	private String endereco;
	private String numero;
	private String bairro;
	private String complemento;
}
