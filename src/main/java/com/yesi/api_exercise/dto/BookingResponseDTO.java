package com.yesi.api_exercise.dto;

import java.time.LocalDate;

public record BookingResponseDTO(
    String codeHotel,
        String name,
        String place,
        String roomType,
        Double pricePerNight,
        LocalDate dateFrom,
        LocalDate dateTo
) {
    
}
