package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.gateway.database.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
