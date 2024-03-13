package com.grupo16.hackathon.gateway.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class HotelJson {

    private Long id;
    private String nome;
}
