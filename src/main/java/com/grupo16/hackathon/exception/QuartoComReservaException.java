package com.grupo16.hackathon.exception;

import lombok.Getter;

@Getter
public class QuartoComReservaException extends SystemBaseException {
	private static final long serialVersionUID = 7200081780300819079L;

	private final String code = "hackathon.quartoComReserva";//NOSONAR
	private final String message = "O quarto informado já possui reserva";//NOSONAR
	private final Integer httpStatus = 422;//NOSONAR
}
