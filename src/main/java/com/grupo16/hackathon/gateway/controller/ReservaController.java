package com.grupo16.hackathon.gateway.controller;

import com.grupo16.hackathon.usecase.ObterReservaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.gateway.controller.json.ReservaJson;
import com.grupo16.hackathon.usecase.CriarReservaUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("reservas")
@AllArgsConstructor
public class ReservaController {

    private CriarReservaUseCase criarReservaUseCase;

    private ObterReservaUseCase obterReservaUseCase;


    @GetMapping
    public List<ReservaJson> obter() {
        List<Reserva> reservas = obterReservaUseCase.obter();

        return reservas.stream().map(ReservaJson::new).toList();
    }

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
