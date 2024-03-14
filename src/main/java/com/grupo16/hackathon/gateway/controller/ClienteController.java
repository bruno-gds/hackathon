package com.grupo16.hackathon.gateway.controller;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.gateway.controller.json.ClienteJson;
import com.grupo16.hackathon.usecase.CriarAlterarClienteUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 14/03/2024
 * Project Name: hackathon
 */

@Slf4j
@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private CriarAlterarClienteUseCase criarAlterarClienteUseCase;


    @PostMapping
    public Long criar(@Valid @RequestBody ClienteJson clienteJson) {
        log.trace("Start clienteJson={}", clienteJson);

        Cliente cliente = clienteJson.mapearParaDomain();
        Long id = criarAlterarClienteUseCase.criar(cliente);

        log.trace("End id={}", id);
        return id;
    }
}
