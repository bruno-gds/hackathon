package com.grupo16.hackathon.gateway.database.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo16.hackathon.gateway.database.mysql.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

	List<ReservaEntity> findByStatusAndQuartoId(int ordinal, Long id);

    
}
