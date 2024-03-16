package com.grupo16.hackathon.gateway.database.mysql.entity;

import java.util.List;

import com.grupo16.hackathon.domain.Servico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "Servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tipo;
    
    @ManyToMany(mappedBy = "servicos")
    private List<ReservaEntity> reservas;
    
	@ManyToMany(mappedBy = "servicos")
	private List<HotelEntity> hoteis;
    
	public ServicoEntity(Servico servico) {
		id = servico.getId();
		tipo = (long) servico.getTipo();
	}
}
