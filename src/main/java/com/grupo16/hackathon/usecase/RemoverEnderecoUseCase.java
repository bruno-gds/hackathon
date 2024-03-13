package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RemoverEnderecoUseCase {
	
	private EnderecoRepositoryGateway enderecoRepository;
	
	private ObterEnderecoUseCase obterEnderecoUseCase;

	public void remover(Long id, Long idUsuario) {
		log.trace("Start id={}", id);

		Endereco endereco = obterEnderecoUseCase.obterByIdAndUsuarioId(id,idUsuario);
		
		enderecoRepository.remover(endereco.getId());
		
		log.trace("End");
		
	}

}
