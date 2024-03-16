package com.grupo16.hackathon.gateway.controller.json;

import com.grupo16.hackathon.domain.Servico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoJson {
	private Long id;
	private String nome;
	
	public Servico mapearParaDomain() {
		return Servico.builder()
				.id(id)
				.build();
	}
}
