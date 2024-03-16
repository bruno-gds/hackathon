package com.grupo16.hackathon.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.grupo16.hackathon.domain.Quarto;
import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.exception.QuartoComReservaNaMesmaDataException;
import com.grupo16.hackathon.gateway.database.ReservaRepositoryGateway;

@ExtendWith(MockitoExtension.class)
class CriarReservaUseCaseUnitTest {
	
	@InjectMocks
	private CriarReservaUseCase criarReservaUseCase;
	
	@Mock
	private ReservaRepositoryGateway reservaRepositoryGateway;
	
	@Test
	void shouldSucessOnCriar(){
		Reserva reserva = Reserva.builder()
				.quarto(Quarto.builder().id(1L).build())
				.inicio(LocalDateTime.now())
				.fim(LocalDateTime.now().plusDays(3))
				.build();
		
		criarReservaUseCase.criar(reserva);
		
		verify(reservaRepositoryGateway).obterPorQuartoIdEAtivas(reserva.getQuarto().getId());
		verify(reservaRepositoryGateway).criar(reserva);
	}
	
	@Test
	void shouldQuartoComReservaExceptionOnCriar(){
		
		LocalDateTime inicio = LocalDateTime.of(2024, Month.MARCH, 15, 12, 0);
		LocalDateTime fim = LocalDateTime.of(2024, Month.MARCH, 20, 12, 0);
		
		Reserva reserva = Reserva.builder()
				.quarto(Quarto.builder().id(1L).build())
				.inicio(inicio)
				.fim(fim)
				.build();
		
		Reserva reservaExistente01 = Reserva.builder()
				.quarto(Quarto.builder().id(1L).build())
				.inicio(LocalDateTime.of(2024, Month.MARCH, 15, 0, 0))
				.fim(LocalDateTime.of(2024, Month.MARCH, 16, 0, 0))
				.build();
		
		List<Reserva> reservas = Lists.list(reservaExistente01);
		doReturn(reservas).when(reservaRepositoryGateway).obterPorQuartoIdEAtivas(reserva.getQuarto().getId());
		
		assertThrows(QuartoComReservaNaMesmaDataException.class, () -> criarReservaUseCase.criar(reserva));
		
		verify(reservaRepositoryGateway).obterPorQuartoIdEAtivas(reserva.getQuarto().getId());
		verify(reservaRepositoryGateway, never()).criar(reserva);
	}
}
