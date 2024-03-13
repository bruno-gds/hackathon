package com.grupo16.hackathon.exception;

import lombok.Getter;

@Getter
public class ErroAoAcessarDatabaseException extends SystemBaseException{
	private static final long serialVersionUID = -1738985112058252461L;

	private final String code = "hackathon.errorToAccessDatabase";
	private final String message = "Ocorreu um erro ao acessar o banco de dados.";
	private final Integer httpStatus = 500;

}
