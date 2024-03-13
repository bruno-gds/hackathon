package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
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

	public Endereco obterPorId(Long id) {
		Optional<Endereco> enderecoOp = enderecoRepositoryGateway.obterPorId(id);

		if (enderecoOp.isPresent()) {
			return enderecoOp.get();
		}

		throw new IllegalArgumentException("Endereço não encontrado");
    }
}
