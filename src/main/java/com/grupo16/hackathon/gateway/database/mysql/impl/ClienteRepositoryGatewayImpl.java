package com.grupo16.hackathon.gateway.database.mysql.impl;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.exception.ErroAoAcessarDatabaseException;
import com.grupo16.hackathon.gateway.database.ClienteRepositoryGateway;
import com.grupo16.hackathon.gateway.database.mysql.entity.ClienteEntity;
import com.grupo16.hackathon.gateway.database.mysql.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public List<Cliente> obterTodos() {
        try {
            List<ClienteEntity> clientes = this.clienteRepository.findAll();

            return clientes.stream().map(ClienteEntity::mapearParaDomain).toList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }

    @Override
    public Optional<Cliente> obterPorId(Long id) {
        try {
            ClienteEntity entity = this.clienteRepository.findById(id).orElse(null);

            return Optional.ofNullable(entity).map(ClienteEntity::mapearParaDomain);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }

    @Override
    public Long salvar(Cliente cliente) {
        try {
            log.trace("Start cliente={}", cliente);

//            ClienteEntity validaCpf = clienteRepository.findByCpf(cliente.getCpf());
//
//            if (validaCpf != null) {
//                throw new IllegalArgumentException("Ja existe um cliente com este cpf");
//            }

            ClienteEntity entity = new ClienteEntity(cliente);

            clienteRepository.save(entity);

            log.trace("End id={}", entity.getId());
            return entity.getId();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            this.clienteRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }
}
