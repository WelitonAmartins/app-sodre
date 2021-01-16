package br.com.litosolucoes.appsodre.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalcaoDTO {
	
	private String tipo;
	
	private String produto;
	
	private BigDecimal valor;

}
