package com.grupo16.hackathon.gateway.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.domain.Estado;
import com.grupo16.hackathon.domain.Hotel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 13/03/2024
 * Project Name: hackathon
 */


@Getter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoJson {

    private Long id;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    @NotBlank
    private String cidade;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{2}$", message = "O estado deve estar no formato 'SP'")
    private String estado;

    @NotBlank
    private String cep;

    @NotBlank
    private String pais;

    private HotelJson hotelId;
    private ClienteJson clienteId;


    public EnderecoJson(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = String.valueOf(endereco.getEstado());
        this.cep = endereco.getCep();
        this.pais = endereco.getPais();
        this.hotelId = HotelJson.builder()
                .id(endereco.getHotelId().getId())
                .build();
        this.clienteId = ClienteJson.builder()
                .id(endereco.getClienteId().getId())
                .build();
    }

    public Endereco mapearParaEnderecoDomain() {

        return Endereco.builder()
                .id(id)
                .rua(rua)
                .numero(numero)
                .cidade(cidade)
                .estado(Estado.valueOf(estado))
                .cep(cep)
                .pais(pais)
                .hotelId(Hotel.builder()
                        .id(hotelId.getId())
                        .build())
                .clienteId(Cliente.builder()
                        .id(clienteId.getId())
                        .build())
                .build();
    }
}
