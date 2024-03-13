package com.grupo16.hackathon.gateway.database;

import com.grupo16.hackathon.domain.Endereco;

import java.util.List;


public interface EnderecoRepositoryGateway {

	List<Endereco> obterTodos();
	
	Long salvar(Endereco endereco);

	void remover(Long id);
}
