package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RemoverEnderecoUseCase {
	
	private EnderecoRepositoryGateway enderecoRepository;


	public void remover(Long id) {
		enderecoRepository.remover(id);
	}
}
