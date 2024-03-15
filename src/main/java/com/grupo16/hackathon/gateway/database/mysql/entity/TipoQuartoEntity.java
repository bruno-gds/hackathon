package com.grupo16.hackathon.gateway.database.mysql.entity;

import java.math.BigDecimal;
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
@Table(name = "TipoQuarto")
public class TipoQuartoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Long totalPessoas;
    private Long totalcamas;
	private BigDecimal valorDiaria;

    @OneToMany(mappedBy = "tipoQuarto")
    private List<QuartoEntity> quartos;
}
