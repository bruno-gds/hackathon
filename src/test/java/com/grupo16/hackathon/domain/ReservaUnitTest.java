package com.grupo16.hackathon.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class ReservaUnitTest {

	@Test
	void caso1() {
		LocalDateTime inicio = LocalDateTime.of(2024, Month.MARCH, 15, 0, 0);
		LocalDateTime fim = LocalDateTime.of(2024, Month.MARCH, 20, 0, 0);
		
		Reserva reserva = Reserva.builder()
				.inicio(inicio)
				.fim(fim)
				.build();
		
		LocalDateTime inicioA = LocalDateTime.of(2024, Month.MARCH, 10, 0, 0);
		LocalDateTime fimA = LocalDateTime.of(2024, Month.MARCH, 15, 0, 1);
		
		assertTrue(reserva.isDataEmUso(inicioA, fimA));
	}
	
}
