package com.grupo16.hackathon.gateway;

import java.util.List;

import com.grupo16.hackathon.domain.Reserva;

public interface ReservaRepositoryGateway {

	List<Reserva> obterPorQuartoId(Long id);

	Long criar(Reserva reserva);

}
