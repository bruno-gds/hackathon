package com.grupo16.hackathon.gateway.controller;

import com.grupo16.hackathon.domain.Endereco;
import com.grupo16.hackathon.gateway.controller.json.EnderecoJson;
import com.grupo16.hackathon.usecase.CriarAlterarEnderecoUseCase;
import com.grupo16.hackathon.usecase.ObterEnderecoUseCase;
import com.grupo16.hackathon.usecase.RemoverEnderecoUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("enderecos")
@AllArgsConstructor
public class EnderecoController {

	private CriarAlterarEnderecoUseCase criarAlterarEnderecoUseCase;

	private ObterEnderecoUseCase obterEnderecoUseCase;

	private RemoverEnderecoUseCase removerEnderecoUseCase;


	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public Long criar(@Valid @RequestBody EnderecoJson enderecoJson) {
		log.trace("Start enderecoJson={}", enderecoJson);

		Endereco endereco = enderecoJson.mapearParaEnderecoDomain();
		Long id = criarAlterarEnderecoUseCase.criar(endereco);

		log.trace("End id={}", id);
		return id;
	}
}
