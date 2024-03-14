package com.grupo16.hackathon.gateway.database.mysql.impl;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.exception.ErroAoAcessarDatabaseException;
import com.grupo16.hackathon.gateway.database.ClienteRepositoryGateway;
import com.grupo16.hackathon.gateway.database.mysql.entity.ClienteEntity;
import com.grupo16.hackathon.gateway.database.mysql.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

@Component
@Slf4j
@AllArgsConstructor
public class ClienteRepositoryGatewayImpl implements ClienteRepositoryGateway {

    private ClienteRepository clienteRepository;

    @Override
    public Long salvar(Cliente cliente) {
        try {
            log.trace("Start cliente={}", cliente);

            ClienteEntity entity = new ClienteEntity(cliente);

            clienteRepository.save(entity);

            log.trace("End id={}", entity.getId());
            return entity.getId();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }
}
