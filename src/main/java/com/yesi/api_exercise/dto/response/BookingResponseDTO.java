package com.yesi.api_exercise.dto.response;

import java.time.LocalDate;

public record BookingResponseDTO(
    String codeHotel,
        String destination,
        String roomType,
        LocalDate dateFrom,
        LocalDate dateTo
) {
}
