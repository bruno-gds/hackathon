package com.grupo16.hackathon.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.hackathon.domain.Movel;
import com.grupo16.hackathon.gateway.database.MovelRepositoryGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ObterMovelUseCase {
	
	private MovelRepositoryGateway movelRepositoryGateway;
	
	public List<Movel> obter() {
		return movelRepositoryGateway.obter();		
	}

}
