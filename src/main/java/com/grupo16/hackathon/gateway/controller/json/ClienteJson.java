package com.grupo16.hackathon.gateway.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteJson {

    private Long id;

    @NotBlank
    private String paisOrigem;

    @NotBlank
    private String cpf;

    @NotBlank
    private String passaporte;

    @NotBlank
    private String nome;

    @NotBlank
    private String dataNascimento;

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;

    private EnderecoJson enderecoId;
}
