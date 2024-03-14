package com.grupo16.hackathon.gateway.controller.json;

import com.grupo16.hackathon.domain.MovelQuarto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MovelQuartoJson {

	private Long idQuarto;
    private Long idMovel;
    private int quantidade;
    
    public MovelQuarto mapperToDomain() {
    	return MovelQuarto.builder()
    			.idQuarto(idQuarto)
    			.idMovel(idMovel)
    			.quantidade(quantidade)
    			.build();
    }

}
