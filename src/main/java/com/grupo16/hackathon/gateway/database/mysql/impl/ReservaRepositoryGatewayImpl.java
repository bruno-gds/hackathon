package com.grupo16.hackathon.gateway.database.mysql.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.gateway.database.ReservaRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReservaRepositoryGatewayImpl implements ReservaRepositoryGateway {

	@Override
	public List<Reserva> obterPorQuartoIdEAtivas(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long criar(Reserva reserva) {
		// TODO Auto-generated method stub
		return null;
	}

}
