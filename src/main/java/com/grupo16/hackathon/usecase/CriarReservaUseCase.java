package com.grupo16.hackathon.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.exception.QuartoComReservaException;
import com.grupo16.hackathon.gateway.ReservaRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarReservaUseCase {

	private ReservaRepositoryGateway reservaRepositoryGateway;
	
	public Long criarReserva(Reserva novaReserva) {
		
		List<Reserva> reservas = reservaRepositoryGateway.obterPorQuartoId(novaReserva.getQuarto().getId());
		boolean quartoReservado = reservas.stream().anyMatch(r -> !r.isAtiva());
		
		if(quartoReservado) {
			log.warn("O quarto informado possui reserva ativa.");
			throw new QuartoComReservaException();
		}
		
		return reservaRepositoryGateway.criar(novaReserva);
	}
	
}
