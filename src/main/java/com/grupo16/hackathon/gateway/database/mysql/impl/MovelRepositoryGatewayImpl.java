package com.grupo16.hackathon.gateway.database.mysql.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.grupo16.hackathon.domain.Movel;
import com.grupo16.hackathon.gateway.database.MovelRepositoryGateway;
import com.grupo16.hackathon.gateway.database.mysql.entity.MovelEntity;
import com.grupo16.hackathon.gateway.database.mysql.repository.MovelRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MovelRepositoryGatewayImpl implements MovelRepositoryGateway {
	
	private MovelRepository movelRepository;
	
	@Override
	public List<Movel> obter() {
		List<MovelEntity> moveisEntities = movelRepository.findAll();
		return moveisEntities.stream().map(MovelEntity::mapperToDomain).toList();
	}

}
