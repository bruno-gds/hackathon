package com.grupo16.hackathon.gateway.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.hackathon.domain.Quarto;
import com.grupo16.hackathon.gateway.controller.json.QuartoJson;
import com.grupo16.hackathon.usecase.CriarAlterarQuartoUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("quartos")
@AllArgsConstructor
public class QuartoController {
	
	private CriarAlterarQuartoUseCase criarAlterarQuartoUseCase;
	
	@PostMapping
	public Long criar(@RequestBody QuartoJson quartoJson) {
		log.trace("Start quartoJson={}", quartoJson);
		
		Quarto quarto = quartoJson.mapperToDomain();
		
		Long id = criarAlterarQuartoUseCase.criar(quarto);
		
		log.trace("End id={}", id);
		return id;
	}
	
	@PutMapping("{id}")
	public void alterar(
			@PathVariable(name = "id") Long id,
			@RequestBody QuartoJson quartoJson) {
		log.trace("Start id={}, quartoJson={}", id, quartoJson);
		
		Quarto quarto = quartoJson.mapperToDomain();
		
		criarAlterarQuartoUseCase.alterar(quarto);
		log.trace("End");
	}
	

}
