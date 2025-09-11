package com.yesi.api_exercise.dto.response;

import java.time.LocalDate;

public record BookingResponseDTO(
    String codeHotel,
        String name,
        String destination,
        String roomType,
        Double pricePerNight,
        LocalDate dateFrom,
        LocalDate dateTo
) {
    
}
