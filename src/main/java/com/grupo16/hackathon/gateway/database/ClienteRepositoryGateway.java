package com.grupo16.hackathon.gateway.database;

import com.grupo16.hackathon.domain.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

public interface ClienteRepositoryGateway {

    List<Cliente> obterTodos();

    Optional<Cliente> obterPorId(Long id);

    Long salvar(Cliente cliente);
}
