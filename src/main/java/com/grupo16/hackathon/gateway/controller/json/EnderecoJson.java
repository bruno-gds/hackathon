package com.grupo16.hackathon.gateway.controller.json;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.domain.Estado;
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
    private Long idLocalidade;
    private Long idHotel;


    public EnderecoJson(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = String.valueOf(endereco.getEstado());
        this.cep = endereco.getCep();
        this.idLocalidade = endereco.getIdLocalidade();
        this.idHotel = endereco.getIdHotel();
    }

    public Endereco mapearParaEnderecoDomain() {

        return Endereco.builder()
                .id(id)
                .rua(rua)
                .numero(numero)
                .cidade(cidade)
                .estado(Estado.valueOf(estado))
                .cep(cep)
                .idLocalidade(idLocalidade)
                .idHotel(idHotel)
                .build();
    }
}
