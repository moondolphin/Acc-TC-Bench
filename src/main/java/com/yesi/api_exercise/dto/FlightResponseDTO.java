package com.yesi.api_exercise.dto;

import java.time.LocalDate;

public record FlightResponseDTO(
    String flightNumber,
    String origin,
    String destination,
    String seatType,
    Double price,
    LocalDate departureDate,
    LocalDate returnDate
) {
    
}
