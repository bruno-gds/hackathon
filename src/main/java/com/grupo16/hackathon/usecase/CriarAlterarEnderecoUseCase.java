package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class CriarAlterarEnderecoUseCase {

	private EnderecoRepositoryGateway enderecoRepositoryGateway;
	
	private ObterEnderecoUseCase obterEnderecoUseCase;


	public Long criar(Endereco endereco) {
		log.trace("Start endereco={}", endereco);

		Long id = enderecoRepositoryGateway.salvar(endereco);
		
		log.trace("End id={}", id);
		return id;
	}

	public void alterar(Endereco endereco) {
		log.trace("Start endereco={}", endereco);

		// TODO: Implementar ajustes
//		Endereco enderecoEncontrado = obterEnderecoUseCase.obterByIdAndUsuarioId(endereco.getId(), endereco.getUsuario().getId());
//
//		Endereco enderecoToUpdate = Endereco.builder()
//				.id(enderecoEncontrado.getId())
//				.rua(endereco.getRua())
//				.numero(endereco.getNumero())
//				.bairro(endereco.getBairro())
//				.cidade(endereco.getCidade())
//				.estado(endereco.getEstado())
//				.cep(endereco.getCep())
//				.usuario(enderecoEncontrado.getUsuario())
//				.build();
//
//		enderecoRepository.salvar(enderecoToUpdate);
		
		log.trace("End");
	}
}
