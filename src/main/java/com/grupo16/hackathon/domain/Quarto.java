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
public class Quarto {

    private Long id;
    private String tipo;
    private int totalPessoas;
    private int totalCamas;
    private String banheiro;
    private String outrosMoveis;
    private Double valorDiaria;
    private Long idHotel;
    private Long idTipoQuarto;
}
