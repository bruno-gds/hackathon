package com.grupo16.hackathon.gateway.database.mysql.entity;

import java.util.List;

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
    private String cpf;
    private String passaporte;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String email;

    @OneToOne(mappedBy = "cliente")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "cliente")
    private List<ReservaEntity> reservas;

    public ClienteEntity(Cliente cliente) {
        this.id = cliente.getId();
        this.cpf = cliente.getCpf();
        this.passaporte = cliente.getPassaporte();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
//        this.endereco = EnderecoEntity.builder()
//                .id(cliente.getEnderecoId().getId())
//                .build();
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
//                .enderecoId(Endereco.builder()
//                        .id(endereco.getId())
//                        .build())
                .build();
    }
}
