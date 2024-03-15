package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.gateway.database.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 14/03/2024
 * Project Name: hackathon
 */

@Service
@Slf4j
@AllArgsConstructor
public class ObterClienteUseCase {

    private ClienteRepositoryGateway clienteRepositoryGateway;


    public List<Cliente> obterTodos() {
        return clienteRepositoryGateway.obterTodos();
    }
}
