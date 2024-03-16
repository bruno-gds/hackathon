package com.grupo16.hackathon.gateway.controller.json;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.domain.StatusReserva;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaJson {
	private Long id;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private StatusReserva status;
	private QuartoJson quarto;
	private ClienteJson cliente;
	private List<ServicoJson> servicos;
	
	public Reserva mapearParaDomain() {
		return Reserva.builder()
				.id(id)
				.inicio(inicio)
				.fim(fim)
				.status(status)
				.quarto(quarto.mapperToDomain())
				.cliente(cliente.mapearParaDomain())
				.servicos(servicos.stream().map(ServicoJson::mapearParaDomain).toList())
				.build();
	}

}
