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
public class Endereco {

    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private Estado estado;
    private String cep;
    private Hotel idHotel;
}
