package com.grupo16.hackathon.gateway.database.mysql.impl;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
import com.grupo16.hackathon.gateway.database.mysql.repository.EnderecoRepository;
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
public class EnderecoRepositoryGatewayImpl implements EnderecoRepositoryGateway {

    private EnderecoRepository enderecoRepository;


    @Override
    public Long salvar(Endereco endereco) {
        return null;
    }

    @Override
    public void remover(Long id) {

    }
}
