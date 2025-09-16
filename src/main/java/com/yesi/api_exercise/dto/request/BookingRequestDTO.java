package com.yesi.api_exercise.dto.request;

import com.yesi.api_exercise.dto.BookingDetailDTO;
import com.yesi.api_exercise.validations.ValidDates;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ValidDates(before = "dateFrom", after="dateTo", message = "The arrival date must be lower than the departure date")
public record BookingRequestDTO(
        @NotNull(message = "El nombre de usuario no puede ser nulo.")
        String userName,

        @NotNull(message = "Los detalles de la reserva no pueden ser nulos.")
        @Valid 
        BookingDetailDTO booking) {

}
