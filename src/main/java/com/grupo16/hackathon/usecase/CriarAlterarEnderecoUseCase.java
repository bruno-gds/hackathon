package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class CriarAlterarEnderecoUseCase {

	private EnderecoRepositoryGateway enderecoRepositoryGateway;


	public Long criar(Endereco endereco) {
		log.trace("Start endereco={}", endereco);

		Long id = enderecoRepositoryGateway.salvar(endereco);
		
		log.trace("End id={}", id);
		return id;
	}

	public void alterar(Long id, Endereco endereco) {
		log.trace("Start id={} endereco={}", id, endereco);

		Optional<Endereco> enderecoOp = enderecoRepositoryGateway.obterPorId(id);

		if (enderecoOp.isPresent()) {
			Endereco novoEndereco = Endereco.builder()
					.id(enderecoOp.get().getId())
					.rua(endereco.getRua())
					.numero(endereco.getNumero())
					.cidade(endereco.getCidade())
					.estado(endereco.getEstado())
					.cep(endereco.getCep())
					.pais(endereco.getPais())
					.hotelId(enderecoOp.get().getHotelId())
					.clienteId(enderecoOp.get().getClienteId())
					.build();

			enderecoRepositoryGateway.salvar(novoEndereco);
		}

		log.trace("End");

		throw new IllegalArgumentException("Endereço não encontrado");
	}
}
