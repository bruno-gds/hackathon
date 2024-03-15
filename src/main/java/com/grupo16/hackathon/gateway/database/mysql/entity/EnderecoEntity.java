package com.grupo16.hackathon.gateway.database.mysql.entity;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.domain.Estado;
import com.grupo16.hackathon.domain.Hotel;
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
@Table(name = "Endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private int estado;
    private String cep;
    private String pais;

    @OneToOne
    @JoinColumn(name = "Hotel_id", referencedColumnName = "id")
    private HotelEntity hotel;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteEntity cliente;



    public EnderecoEntity(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado().ordinal();
        this.cep = endereco.getCep();
        this.pais = endereco.getPais();
        this.hotel = HotelEntity.builder()
                .id(endereco.getHotelId().getId())
                .build();
        this.cliente = ClienteEntity.builder()
                .id(endereco.getClienteId().getId())
                .build();
    }

    public Endereco mapearParaDomain() {
        return Endereco.builder()
                .id(id)
                .rua(rua)
                .numero(numero)
                .cidade(cidade)
                .estado(Estado.getByOrdinal(estado))
                .cep(cep)
                .pais(pais)
                .hotelId(Hotel.builder()
                        .id(hotel.getId())
                        .build())
                .clienteId(Cliente.builder()
                        .id(this.cliente.getId())
                        .build())
                .build();
    }
}
