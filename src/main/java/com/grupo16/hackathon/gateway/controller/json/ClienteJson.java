package com.grupo16.hackathon.gateway.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.domain.Endereco;
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


    public Cliente mapearParaDomain() {
        return Cliente.builder()
                .id(id)
                .paisOrigem(paisOrigem)
                .cpf(cpf)
                .passaporte(passaporte)
                .nome(nome)
                .dataNascimento(dataNascimento)
                .telefone(telefone)
                .email(email)
                .enderecoId(Endereco.builder()
                        .id(enderecoId.getId())
                        .build())
                .build();
    }
}
