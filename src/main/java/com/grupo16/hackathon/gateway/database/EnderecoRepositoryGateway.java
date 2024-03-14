package com.grupo16.hackathon.gateway.database;

import com.grupo16.hackathon.domain.Endereco;

import java.util.List;
import java.util.Optional;


public interface EnderecoRepositoryGateway {

	List<Endereco> obterTodos();

	Optional<Endereco> obterPorId(Long id);
	
	Long salvar(Endereco endereco);

	void remover(Long id);
}