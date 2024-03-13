package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
import com.grupo16.hackathon.usecase.exception.EnderecoNaoEcontradoException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ObterEnderecoUseCase {

	private EnderecoRepositoryGateway enderecoRepositoryGateway;


	public List<Endereco> obterTodos() {
		return enderecoRepositoryGateway.obterTodos();
	}

	private void checarSeEnderecoFoiEncontrado(Optional<Endereco> enderecoOp) {
		if(enderecoOp.isEmpty()) {
			log.warn("Endereco não encontrado.");
			throw new EnderecoNaoEcontradoException();
		}
	}
}
