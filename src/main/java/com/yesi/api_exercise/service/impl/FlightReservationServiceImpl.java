package com.yesi.api_exercise.service.impl;

import com.yesi.api_exercise.dto.request.FlightReservationRequestDTO;
import com.yesi.api_exercise.dto.response.FlightReservationResponseDTO;
import com.yesi.api_exercise.mapper.FlightReservationMapper;
import com.yesi.api_exercise.model.FlightReservation;
import com.yesi.api_exercise.repository.FlightReservationRepository;
import com.yesi.api_exercise.service.FlightReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightReservationServiceImpl implements FlightReservationService {
    private final FlightReservationRepository flightReservationRepository;
    private final FlightReservationMapper flightReservationMapper;

    @Override
    public FlightReservationResponseDTO makeFlightReservation(FlightReservationRequestDTO flightReservationRequestDTO) {
        log.info("Iniciando proceso de reserva para el usuario: ", flightReservationRequestDTO.userName(),
                " Con destino a: ", flightReservationRequestDTO.flightReservation().destination());
        FlightReservation flightReservation = flightReservationMapper.toEntity(flightReservationRequestDTO);
        FlightReservation save = flightReservationRepository.save(flightReservation);
        log.debug("Reserva de vuelo creada exitosamente con ID: ", save.getId());

        return flightReservationMapper.toResponseDTO(save, flightReservationRequestDTO);
    }

}
