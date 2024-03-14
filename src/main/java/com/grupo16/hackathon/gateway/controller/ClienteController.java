package com.grupo16.hackathon.gateway.controller;

import com.grupo16.hackathon.domain.Cliente;
import com.grupo16.hackathon.gateway.controller.json.ClienteJson;
import com.grupo16.hackathon.usecase.CriarAlterarClienteUseCase;
import com.grupo16.hackathon.usecase.ObterClienteUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    private ObterClienteUseCase obterClienteUseCase;


    @GetMapping
    public List<ClienteJson> obterTodos() {
        List<Cliente> clientes = obterClienteUseCase.obterTodos();

        return clientes.stream().map(ClienteJson::new).toList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criar(@Valid @RequestBody ClienteJson clienteJson) {
        log.trace("Start clienteJson={}", clienteJson);

        Cliente cliente = clienteJson.mapearParaDomain();
        Long id = criarAlterarClienteUseCase.criar(cliente);

        log.trace("End id={}", id);
        return id;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void alterar(@PathVariable Long id, @Valid @RequestBody ClienteJson clienteJson) {
        log.trace("Start id={} clienteJson={}", id, clienteJson);

        Cliente cliente = clienteJson.mapearParaDomain();
        criarAlterarClienteUseCase.alterar(id, cliente);

        log.trace("End");
    }
}
