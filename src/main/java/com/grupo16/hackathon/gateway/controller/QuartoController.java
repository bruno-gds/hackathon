package com.grupo16.hackathon.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.hackathon.domain.Quarto;
import com.grupo16.hackathon.gateway.controller.json.QuartoJson;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("quartos")
@AllArgsConstructor
public class QuartoController {
	
	@PostMapping
	public Long criar(@RequestBody QuartoJson quartoJson) {
		log.trace("Start quartoJson={}", quartoJson);
		
		Quarto quarto = quartoJson.mapperToDomain();
		
		
		
		return null;
	}

}
