package com.grupo16.hackathon.domain;

import lombok.*;

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
public class TipoQuarto {

    private Long id;
    private String tipo;
    private Integer totalPessoas;
    private Integer totalCamas;
    
}
