package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.EnderecoRepositoryGateway;
import com.grupo16.hackathon.usecase.exception.EnderecoNaoEcontradoException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ObterEnderecoUseCase {

	private EnderecoRepositoryGateway enderecoRepositoryGateway;

	public Endereco obterByIdAndUsuarioId(Long id, Long idUsuario) {
		log.trace("Start idEndereco={}, idUsuario={}", id, idUsuario);
		
		Optional<Endereco> enderecoOp = enderecoRepositoryGateway.obterByIdAndUsuarioId(id, idUsuario);
		checarSeEnderecoFoiEncontrado(enderecoOp);
	
		log.trace("End endereco={}", enderecoOp.get());
		return enderecoOp.get();
	}

	private void checarSeEnderecoFoiEncontrado(Optional<Endereco> enderecoOp) {
		if(enderecoOp.isEmpty()) {
			log.warn("Endereco não encontrado.");
			throw new EnderecoNaoEcontradoException();
		}
	}
}
