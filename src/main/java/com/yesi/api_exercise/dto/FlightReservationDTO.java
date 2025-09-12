package com.yesi.api_exercise.dto;

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
                List<PersonDTO> people,
                List<PaymentMethodDTO> paymentMethod) {
}
