package com.grupo16.hackathon.gateway.database.mysql.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne(mappedBy = "hotel")
    private EnderecoEntity endereco;
    
    @OneToMany(mappedBy = "hotel")
    private List<QuartoEntity> quartos;
    
    @ManyToMany
    @JoinTable(name = "HotelComodidade", 
    joinColumns = { @JoinColumn(name = "Hotel_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "Comodidade_id") })
    private List<ComodidadeEntity> comodidades;
    
    @ManyToMany
	@JoinTable(name = "ServicoHotel", 
	joinColumns = { @JoinColumn(name = "Hotel_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "Servico_id") })
    private List<ServicoEntity> servicos;
}
