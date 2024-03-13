package com.grupo16.hackathon.gateway.database;

import com.grupo16.hackathon.domain.Endereco;


public interface EnderecoRepositoryGateway {
	
	Long salvar(Endereco endereco);

	void remover(Long id);
}
