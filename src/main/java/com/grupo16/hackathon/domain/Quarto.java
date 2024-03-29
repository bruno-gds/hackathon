package com.grupo16.hackathon.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 12/03/2024
 * Project Name: hackathon
 */

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {

	private Long id;
	private String banheiro;
	private List<MovelQuarto> outrosMoveis;
	private Double valorDiaria;
	private Long idHotel;
	private TipoQuarto tipoQuarto;
	private Integer quantidadeQuartos;
}
