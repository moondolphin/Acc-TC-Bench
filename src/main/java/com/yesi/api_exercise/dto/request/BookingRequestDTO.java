package com.yesi.api_exercise.dto.request;

import com.yesi.api_exercise.dto.BookingDetailDTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record BookingRequestDTO(
        @NotNull(message = "El nombre de usuario no puede ser nulo.")
        String userName,

        @NotNull(message = "Los detalles de la reserva no pueden ser nulos.")
        @Valid 
        BookingDetailDTO booking) {

}
