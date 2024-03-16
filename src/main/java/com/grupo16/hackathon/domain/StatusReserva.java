package com.grupo16.hackathon.domain;

public enum StatusReserva {
	ABERTA,
	CONCLUIDA,
	ENCERRADA;
	
	
	public static StatusReserva obterPorId(int id) {
		StatusReserva[] values = StatusReserva.values();
		return values[id];
	}
}
