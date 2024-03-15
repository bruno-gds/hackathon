package com.grupo16.hackathon.gateway.database.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo16.hackathon.gateway.database.mysql.entity.MovelEntity;
import com.grupo16.hackathon.gateway.database.mysql.entity.QuartoEntity;

@Repository
public interface MovelRepository extends JpaRepository<MovelEntity, Long> {
	
	
}
