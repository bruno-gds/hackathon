package com.grupo16.hackathon.gateway;

import com.grupo16.hackathon.domain.Endereco;

import java.util.Optional;

public interface EnderecoRepositoryGateway {
	
	Long salvar(Endereco endereco);

	Optional<Endereco> obterByIdAndUsuarioId(Long id, Long idUsuario);

	void remover(Long id);
}
