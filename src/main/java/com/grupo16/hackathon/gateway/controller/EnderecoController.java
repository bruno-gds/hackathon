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

import java.util.List;


@Slf4j
@RestController
@RequestMapping("enderecos")
@AllArgsConstructor
public class EnderecoController {

	private CriarAlterarEnderecoUseCase criarAlterarEnderecoUseCase;

	private ObterEnderecoUseCase obterEnderecoUseCase;

	private RemoverEnderecoUseCase removerEnderecoUseCase;


	@GetMapping()
	public List<EnderecoJson> listarTodos() {
		List<Endereco> enderecos = obterEnderecoUseCase.obterTodos();

		return enderecos.stream().map(EnderecoJson::new).toList();
	}

	@GetMapping("/{id}")
	public EnderecoJson obterPorId(@PathVariable Long id) {
		log.trace("Start id={}", id);

		Endereco endereco = obterEnderecoUseCase.obterPorId(id);
		EnderecoJson enderecoJson = new EnderecoJson(endereco);

		log.trace("End enderecoJson={}", enderecoJson);
		return enderecoJson;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public Long criar(@Valid @RequestBody EnderecoJson enderecoJson) {
		log.trace("Start enderecoJson={}", enderecoJson);

		Endereco endereco = enderecoJson.mapearParaEnderecoDomain();
		Long id = criarAlterarEnderecoUseCase.criar(endereco);

		log.trace("End id={}", id);
		return id;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void alterar(@PathVariable Long id, @Valid @RequestBody EnderecoJson enderecoJson) {
		log.trace("Start id={} enderecoJson={}", id, enderecoJson);

		Endereco endereco = enderecoJson.mapearParaEnderecoDomain();

		criarAlterarEnderecoUseCase.alterar(id, endereco);

		log.trace("End");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		log.trace("Start id={}", id);

		removerEnderecoUseCase.remover(id);

		log.trace("End");
	}
}
