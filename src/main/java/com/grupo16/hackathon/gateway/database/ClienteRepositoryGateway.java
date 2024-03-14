package com.grupo16.hackathon.gateway.database;

import com.grupo16.hackathon.domain.Cliente;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

public interface ClienteRepositoryGateway {

    Long salvar(Cliente cliente);
}
