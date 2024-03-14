package com.grupo16.hackathon.gateway.database.mysql.repository;

import com.grupo16.hackathon.gateway.database.mysql.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
