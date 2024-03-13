package com.grupo16.hackathon.domain;

import lombok.*;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Long id;
    private String paisOrigem;
    private String cpf;
    private String passaporte;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String email;
    private Long enderecoCliente;
}
