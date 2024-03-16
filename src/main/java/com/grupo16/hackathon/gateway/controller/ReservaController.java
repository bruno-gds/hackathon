package com.grupo16.hackathon.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.gateway.controller.json.ReservaJson;
import com.grupo16.hackathon.usecase.CriarReservaUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("reservas")
@AllArgsConstructor
public class ReservaController {

    private CriarReservaUseCase criarReservaUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criar(@RequestBody ReservaJson reservaJson) {
        log.trace("Start reservaJson={}", reservaJson);

        Reserva reserva = reservaJson.mapearParaDomain();
        Long id = criarReservaUseCase.criar(reserva);

        log.trace("End id={}", id);
        return id;
    }
}
