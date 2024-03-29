package com.grupo16.hackathon.gateway.database.mysql.impl;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.exception.ErroAoAcessarDatabaseException;
import com.grupo16.hackathon.gateway.database.EnderecoRepositoryGateway;
import com.grupo16.hackathon.gateway.database.mysql.entity.EnderecoEntity;
import com.grupo16.hackathon.gateway.database.mysql.repository.EnderecoRepository;
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
public class EnderecoRepositoryGatewayImpl implements EnderecoRepositoryGateway {

    private EnderecoRepository enderecoRepository;


    @Override
    public List<Endereco> obterTodos() {
        try {
            List<EnderecoEntity> enderecos = this.enderecoRepository.findAll();

            return enderecos.stream().map(EnderecoEntity::mapearParaDomain).toList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }

    @Override
    public Optional<Endereco> obterPorId(Long id) {
        try {
            EnderecoEntity entity = this.enderecoRepository.findById(id).orElse(null);

            return Optional.ofNullable(entity).map(EnderecoEntity::mapearParaDomain);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }

    @Override
    public Long salvar(Endereco endereco) {
        try {
            log.trace("Start endereco={}", endereco);

            EnderecoEntity entity = new EnderecoEntity(endereco);

            enderecoRepository.save(entity);

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
            this.enderecoRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarDatabaseException();
        }
    }
}
