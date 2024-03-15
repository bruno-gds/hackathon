package com.grupo16.hackathon.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.exception.QuartoComReservaNaMesmaDataException;
import com.grupo16.hackathon.gateway.ReservaRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarReservaUseCase {

	private ReservaRepositoryGateway reservaRepositoryGateway;
	
	public Long criar(Reserva novaReserva) {
		
		List<Reserva> reservas = reservaRepositoryGateway.obterPorQuartoIdEAtivas(novaReserva.getQuarto().getId());
		
		boolean isReservaNaMesmaData = reservas.stream().anyMatch(r -> r.isDataEmUso(novaReserva.getInicio(), novaReserva.getFim()));
		
		if(isReservaNaMesmaData) {
			log.warn("O quarto informado possui reserva na mesma data.");
			throw new QuartoComReservaNaMesmaDataException();
		}
		
		return reservaRepositoryGateway.criar(novaReserva);
	}
	
}
