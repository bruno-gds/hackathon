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

    private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "Hotel_id")
	private HotelEntity hotel;
	
	@ManyToOne
	@JoinColumn(name = "TipoQuarto_id")
	private TipoQuartoEntity tipoQuarto;
	
    @ManyToMany
    @JoinTable(name = "MovelQuarto", 
    joinColumns = { @JoinColumn(name = "Quarto_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "Movel_id") })
    private List<MovelEntity> moveis;
	
	@OneToMany(mappedBy = "quarto")
	private List<ReservaEntity> reservas;
}
