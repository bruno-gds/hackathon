package com.grupo16.hackathon.gateway.database.mysql.entity;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.domain.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paisOrigem;
    private String cpf;
    private String passaporte;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String email;

    @OneToOne
    private EnderecoEntity enderecoId;


    public ClienteEntity(Cliente cliente) {
        this.id = cliente.getId();
        this.paisOrigem = cliente.getPaisOrigem();
        this.cpf = cliente.getCpf();
        this.passaporte = cliente.getPassaporte();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.enderecoId = EnderecoEntity.builder()
                .id(cliente.getEnderecoId().getId())
                .build();
    }

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
