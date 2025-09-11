package com.yesi.api_exercise.service;

import com.yesi.api_exercise.dto.request.FlightReservationRequestDTO;
import com.yesi.api_exercise.dto.response.FlightReservationResponseDTO;

public interface FlightReservationService {

    FlightReservationResponseDTO makeFlightReservation(FlightReservationRequestDTO flightReservationRequestDTO);
}
