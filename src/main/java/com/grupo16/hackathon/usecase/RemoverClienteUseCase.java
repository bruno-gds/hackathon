package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.gateway.database.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 14/03/2024
 * Project Name: hackathon
 */

@Service
@AllArgsConstructor
public class RemoverClienteUseCase {

    private ClienteRepositoryGateway clienteRepository;


    public void remover(Long id) {
        clienteRepository.remover(id);
    }
}
