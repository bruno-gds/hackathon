package com.grupo16.hackathon.gateway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.hackathon.domain.Movel;
import com.grupo16.hackathon.domain.MovelQuarto;
import com.grupo16.hackathon.domain.Quarto;
import com.grupo16.hackathon.gateway.controller.json.QuartoJson;
import com.grupo16.hackathon.usecase.CriarAlterarQuartoUseCase;
import com.grupo16.hackathon.usecase.ObterMovelUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("quartos")
@AllArgsConstructor
public class QuartoController {
	
	private CriarAlterarQuartoUseCase criarAlterarQuartoUseCase;
	
	private ObterMovelUseCase obterMovelUseCase;
	
	@PostMapping("{idHotel}")
	public Long criar(
			@PathVariable(name = "idHotel") Long idHotel,
			@RequestBody QuartoJson quartoJson) {
		log.trace("Start quartoJson={}", quartoJson);
		
		Quarto quarto = quartoJson.mapperToDomain(null, idHotel);
		
		Long id = criarAlterarQuartoUseCase.criar(quarto);
		
		log.trace("End id={}", id);
		return id;
	}
	
	@PutMapping("{id}/{idHotel}")
	public void alterar(
			@PathVariable(name = "id") Long id,
			@PathVariable(name = "idHotel") Long idHotel,
			@RequestBody QuartoJson quartoJson) {
		log.trace("Start id={}, idHotel={}, quartoJson={}", id, idHotel, quartoJson);
		
		Quarto quarto = quartoJson.mapperToDomain(id, idHotel);
		
		criarAlterarQuartoUseCase.alterar(quarto);
		log.trace("End");
	}
	
	@GetMapping("movel")
	public List<Movel> getMovel(){
		log.trace("Start");
		
		List<Movel> moveis = obterMovelUseCase.obter();
		
		log.trace("End moveis={}",moveis);
		return moveis;
	}

}
