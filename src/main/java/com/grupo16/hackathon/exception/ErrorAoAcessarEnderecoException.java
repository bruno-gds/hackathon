package com.grupo16.hackathon.exception;

import lombok.Getter;

@Getter
public class ErrorAoAcessarEnderecoException extends SystemBaseException {
	private static final long serialVersionUID = 3172051907551241565L;
	
	private final String code = "pedido.erroAcessarProdutoService";//NOSONAR
	private final String message = "Erro ao acessar o produto service.";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
