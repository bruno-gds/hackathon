package com.grupo16.hackathon.usecase.exception;

import com.grupo16.hackathon.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class EnderecoNaoEcontradoException extends SystemBaseException {
	private static final long serialVersionUID = 3764568709707489646L;
	
	private final String code = "tc.endereco.enderecoNaoEcontrado";
	private final String message = "Endereço não encontrado.";
	private final Integer httpStatus = 404;

}
