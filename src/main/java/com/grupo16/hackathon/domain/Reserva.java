package com.grupo16.hackathon.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 12/03/2024
 * Project Name: hackathon
 */

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
	private Long id;
    private Quarto quarto;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private StatusReserva status;
    
    public boolean isDataEmUso(LocalDateTime inicio, LocalDateTime fim) {
    	boolean caso1 = this.fim.compareTo(inicio) > 0;//Data Fim interfere na data inicio 
    	boolean caso2 = inicio.compareTo(this.fim) < 0;//Data inicio interfere na data fim 
    	boolean caso3 = inicio.compareTo(this.inicio) >= 0 && fim.compareTo(this.fim) <= 0; //Data inicio e fim dentro da reserva 
    	boolean caso4 = inicio.compareTo(this.inicio) <= 0 && fim.compareTo(this.fim) >= 0; //Data inicio e fim fora da reserva, mas passando por ela 
    	
    	return caso1 || caso2 || caso3 || caso4;
    }
    
}
