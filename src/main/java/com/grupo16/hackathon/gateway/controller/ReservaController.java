package com.grupo16.hackathon.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.hackathon.usecase.CriarReservaUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("reservas")
@AllArgsConstructor
public class ReservaController {

    private CriarReservaUseCase criarReservaUseCase;


//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public Long criar(@Valid @RequestBody ClienteJson clienteJson) {
//        log.trace("Start clienteJson={}", clienteJson);
//
//        Cliente cliente = clienteJson.mapearParaDomain();
//        Long id = criarAlterarClienteUseCase.criar(cliente);
//
//        log.trace("End id={}", id);
//        return id;
//    }

}
