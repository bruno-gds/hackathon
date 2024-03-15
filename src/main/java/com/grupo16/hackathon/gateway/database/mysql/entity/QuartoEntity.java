package com.grupo16.hackathon.gateway.database.mysql.entity;

import java.util.List;

import com.grupo16.hackathon.domain.MovelQuarto;
import com.grupo16.hackathon.domain.TipoQuarto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quarto")
public class QuartoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    private List<MovelQuarto> outrosMoveis;
	private String banheiro;
	private Double valorDiaria;
	private Long idHotel;
//	private TipoQuarto tipoQuarto;
	private Integer quantidadeQuartos;
}
