package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.gateway.database.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 14/03/2024
 * Project Name: hackathon
 */

@Service
@Slf4j
@AllArgsConstructor
public class CriarAlterarClienteUseCase {

    private ClienteRepositoryGateway clienteRepositoryGateway;

    public Long criar(Cliente cliente) {
        log.trace("Start cliente={}", cliente);

        Long id = clienteRepositoryGateway.salvar(cliente);

        log.trace("End id={}", id);
        return id;
    }

    public void alterar(Long id, Cliente cliente) {
        log.trace("Start id={} cliente={}", id, cliente);

        Optional<Cliente> clienteOp = clienteRepositoryGateway.obterPorId(id);

        if (clienteOp.isPresent()) {
            Cliente novoCliente = Cliente.builder()
                    .id(clienteOp.get().getId())
                    .paisOrigem(cliente.getPaisOrigem())
                    .cpf(cliente.getCpf())
                    .passaporte(cliente.getPassaporte())
                    .nome(cliente.getNome())
                    .dataNascimento(cliente.getDataNascimento())
                    .telefone(cliente.getTelefone())
                    .email(cliente.getEmail())
                    .enderecoId(clienteOp.get().getEnderecoId())
                    .build();

            clienteRepositoryGateway.salvar(novoCliente);
        }

        log.trace("End");

        throw new IllegalArgumentException("Cliente não encontrado");
    }
}
