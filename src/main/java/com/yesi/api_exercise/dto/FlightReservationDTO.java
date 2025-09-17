package com.yesi.api_exercise.dto;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

public record FlightReservationDTO(
                LocalDate dateFrom,
                LocalDate dateTo,
                String origin,
                String destination,
                String flightNumber,
                Integer seats,
                String seatType,
                @Valid List<PersonDTO> people,
                @Valid List<PaymentMethodDTO> paymentMethod) {
}
