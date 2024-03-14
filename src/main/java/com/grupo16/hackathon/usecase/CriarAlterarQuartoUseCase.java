package com.grupo16.hackathon.usecase;

import org.springframework.stereotype.Service;

import com.grupo16.hackathon.domain.Quarto;
import com.grupo16.hackathon.gateway.database.QuartoRepositoryGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarAlterarQuartoUseCase {

	private QuartoRepositoryGateway quartoRepositoryGateway;
	
	public Long criar(Quarto quarto) {

		return quartoRepositoryGateway.salvar(quarto);
	}

	public void alterar(Quarto quarto) {
		// TODO Auto-generated method stub
		
	}

}
