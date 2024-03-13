package com.grupo16.hackathon.gateway.controller;

import com.grupo16.hackathon.usecase.CriarAlterarEnderecoUseCase;
import com.grupo16.hackathon.usecase.ObterEnderecoUseCase;
import com.grupo16.hackathon.usecase.RemoverEnderecoUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("enderecos")
@AllArgsConstructor
public class EnderecoController {

	private CriarAlterarEnderecoUseCase criarAlterarEnderecoUseCase;

	private ObterEnderecoUseCase obterEnderecoUseCase;

	private RemoverEnderecoUseCase removerEnderecoUseCase;



}
