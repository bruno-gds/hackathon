package com.grupo16.hackathon.exception;

import lombok.Getter;

@Getter
public class ErroAoAcessarEnderecoException extends SystemBaseException {
	private static final long serialVersionUID = 3172051907551241565L;
	
	private final String code = "hackathon.erroAcessarEndereco";//NOSONAR
	private final String message = "Erro ao acessar Endereco";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
