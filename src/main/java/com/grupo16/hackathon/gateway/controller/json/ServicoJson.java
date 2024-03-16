package com.grupo16.hackathon.gateway.controller.json;

import com.grupo16.hackathon.domain.Servico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
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

	public ServicoJson(Servico servico) {
		this.id = servico.getId();
		this.nome = servico.getNome();
	}
}
