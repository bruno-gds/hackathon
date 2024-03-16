package com.grupo16.hackathon.gateway.database;

import java.util.List;

import com.grupo16.hackathon.domain.Reserva;

public interface ReservaRepositoryGateway {

	List<Reserva> obterPorQuartoIdEAtivas(Long id);

	Long criar(Reserva reserva);

}
