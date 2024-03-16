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
    private String cpf;

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


    public ClienteJson(Cliente cliente) {
        this.id = cliente.getId();
        this.cpf = cliente.getCpf();
        this.passaporte = cliente.getPassaporte();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.enderecoId = EnderecoJson.builder()
                .id(cliente.getEnderecoId().getId())
                .build();
    }

    public Cliente mapearParaDomain() {
        return Cliente.builder()
                .id(id)
                .cpf(cpf)
                .passaporte(passaporte)
                .nome(nome)
                .dataNascimento(dataNascimento)
                .telefone(telefone)
                .email(email)
                .enderecoId(Endereco.builder()
                        .id(enderecoId == null ? null : enderecoId.getId())
                        .build())
                .build();
    }
}
