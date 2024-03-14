package com.grupo16.hackathon.gateway.controller.json;

import java.util.List;

import com.grupo16.hackathon.domain.MovelQuarto;
import com.grupo16.hackathon.domain.Quarto;
import com.grupo16.hackathon.domain.TipoQuarto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuartoJson {

	private Long id;
	private String banheiro;
	private List<MovelQuartoJson> outrosMoveis;
	private Double valorDiaria;
	private Long idHotel;
	private TipoQuarto tipoQuarto;
	private Integer quantidadeQuartos;
	
	
	public Quarto mapperToDomain() {
		List<MovelQuarto> moveisQuarto = outrosMoveis.stream()
				.map(MovelQuartoJson::mapperToDomain).toList();
		
		return Quarto.builder()
				.id(id)
				.banheiro(banheiro)
				.valorDiaria(valorDiaria)
				.idHotel(idHotel)
				.quantidadeQuartos(quantidadeQuartos)
				.outrosMoveis(moveisQuarto)
				.build();
	}

}
