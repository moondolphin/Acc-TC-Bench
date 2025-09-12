package com.yesi.api_exercise.dto;

import java.time.LocalDate;

public record HotelResponseDTO(
        String hotelCode,
        String name,
        String place,
        String roomType,
        Double pricePerNight,
        LocalDate availableFrom,
        LocalDate availableTo,
        boolean isBooked) {

}