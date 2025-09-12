package com.yesi.api_exercise.dto.response;

import java.time.LocalDate;

public record FlightReservationResponseDTO(
        String flightNumber,
        String origin,
        String destination,
        String seatType,
        Integer seats,
        LocalDate dateFrom,
        LocalDate dateTo
) {
}
