package com.grupo16.hackathon.gateway.database.mysql.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.domain.StatusReserva;
import com.grupo16.hackathon.exception.ErroAoAcessarDatabaseException;
import com.grupo16.hackathon.gateway.database.ReservaRepositoryGateway;
import com.grupo16.hackathon.gateway.database.mysql.entity.ReservaEntity;
import com.grupo16.hackathon.gateway.database.mysql.repository.ReservaRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class ReservaRepositoryGatewayImpl implements ReservaRepositoryGateway {

	private ReservaRepository reservaRepository;

	@Override
	public List<Reserva> obter() {
		try {
			List<ReservaEntity> reservasEntities = reservaRepository.findAll();

			return reservasEntities.stream().map(ReservaEntity::getDomain).toList();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarDatabaseException();
		}
	}

	@Override
	public List<Reserva> obterPorQuartoIdEAtivas(Long id) {
		try {
			List<ReservaEntity> reservasEntities = reservaRepository.findByStatusAndQuartoId(StatusReserva.ABERTA.ordinal(), id);
			return reservasEntities.stream().map(ReservaEntity::getDomain).toList();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarDatabaseException();
		}
	}

	@Override
	public Long criar(Reserva reserva) {
		try {
			ReservaEntity reservaEntity = new ReservaEntity(reserva);
			return reservaRepository.save(reservaEntity).getId();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarDatabaseException();
		}
	}

}
