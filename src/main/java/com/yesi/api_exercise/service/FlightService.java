package com.yesi.api_exercise.service;

import java.time.LocalDate;
import java.util.List;


import com.yesi.api_exercise.dto.response.FlightResponseDTO;


public interface FlightService {
    List<FlightResponseDTO> getAllFlights();
    List<FlightResponseDTO> findAllFlightsByDateAndPlaceAndOrigin(LocalDate departureDate, LocalDate returnDate, String destination, String origin);
}
