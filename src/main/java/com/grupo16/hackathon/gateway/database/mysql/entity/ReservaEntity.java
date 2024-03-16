package com.grupo16.hackathon.gateway.database.mysql.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo16.hackathon.domain.Quarto;
import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.domain.StatusReserva;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Reserva")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantidadePessoa;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private Long status;
	
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	private ClienteEntity cliente;

	@ManyToOne
	@JoinColumn(name = "Quarto_id")
	private QuartoEntity quarto;

	@ManyToMany
	@JoinTable(name = "ServicoReserva", 
	joinColumns = { @JoinColumn(name = "Reserva_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "Servico_id") })
	private List<ServicoEntity> servicos;

	public Reserva getDomain() {
		return Reserva.builder()
				.id(id)
				.inicio(inicio)
				.fim(fim)
				.status(StatusReserva.obterPorId(status.intValue()))
				.quarto(Quarto.builder().id(quarto.getId()).build())
				.build();
	}
	
}
