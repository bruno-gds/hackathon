package com.grupo16.hackathon.usecase;

import com.grupo16.hackathon.domain.Reserva;
import com.grupo16.hackathon.gateway.database.ReservaRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 15/03/2024
 * Project Name: hackathon
 */

@Service
@AllArgsConstructor
public class ObterReservaUseCase {

    private ReservaRepositoryGateway reservaRepositoryGateway;

    public List<Reserva> obter() {
        return reservaRepositoryGateway.obter();
    }
}
