package com.yesi.api_exercise.service.impl;

import com.yesi.api_exercise.dto.request.FlightReservationRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;
import com.yesi.api_exercise.dto.response.FlightReservationResponseDTO;
import com.yesi.api_exercise.mapper.FlightMapper;
import com.yesi.api_exercise.mapper.FlightReservationMapper;
import com.yesi.api_exercise.model.Booking;
import com.yesi.api_exercise.model.FlightReservation;
import com.yesi.api_exercise.repository.FlightReservationRepository;
import com.yesi.api_exercise.service.FlightReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightReservationServiceImpl implements FlightReservationService {
    private final FlightReservationRepository flightReservationRepository;
    private final FlightReservationMapper flightReservationMapper;

    @Override
    public FlightReservationResponseDTO makeFlightReservation(FlightReservationRequestDTO flightReservationRequestDTO){
        FlightReservation flightReservation = flightReservationMapper.toEntity(flightReservationRequestDTO);
        FlightReservation save = flightReservationRepository.save(flightReservation);

        return flightReservationMapper.toResponseDTO(save, flightReservationRequestDTO);
    }
    /*
    private FlightReservation flightReservationMapper(FlightReservationRequestDTO flightReservationDTO) {
        FlightReservation flightReservation = FlightReservation.builder()
                .flightNumber(flightReservationDTO.booking().flightNumber())
                .username(flightReservationDTO.userName())
                .dateFrom(flightReservationDTO.booking().dateFrom())
                .dateTo(flightReservationDTO.booking().dateTo())
                .origin(flightReservationDTO.)
                .build();
    }
    */

}
