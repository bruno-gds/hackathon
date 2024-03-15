package com.grupo16.hackathon.gateway.database.mysql.entity;

import com.grupo16.hackathon.domain.Movel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Movel")
public class MovelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	public MovelEntity(Movel movel) {
		id = movel.getId();
		descricao = movel.getDescricao();
	}
	
	public Movel mapperToDomain() {
		return Movel.builder()
				.id(id)
				.descricao(descricao)
				.build();
	}

}
