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
    
    public boolean isAtiva() {
    	return fim != null;
    }
}
