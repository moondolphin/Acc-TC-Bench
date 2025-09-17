package com.yesi.api_exercise.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yesi.api_exercise.validations.ValidDates;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@ValidDates(before = "dateFrom", after="dateTo", message = "The arrival date must be lower than the departure date")
public record BookingDetailDTO(
                LocalDate dateFrom,
                LocalDate dateTo,
                String destination,
                String codeHotel,

                @NotNull(message = "La cantidad de personas no puede ser nula.") 
                @Min(value = 1, message = "La cantidad de personas debe ser como mínimo 1.") 
                Integer peopleAmount,

                String roomType,
                @Valid List<PersonDTO> people,
                @Valid List<PaymentMethodDTO> paymentMethod) {


        @AssertTrue(message = "El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.")
        @JsonIgnore
        private boolean isRoomTypeValid() {
                // logica teniendo en cuenta el tipo de habitacion y la cantidad de personas
                return switch (roomType.toUpperCase()) {
                        case "SINGLE" -> peopleAmount == 1;
                        case "DOBLE" -> peopleAmount == 2;
                        case "TRIPLE" -> peopleAmount == 3;
                        case "MÚLTIPLE" -> peopleAmount >= 4 && peopleAmount <= 8;
                        default -> true; // Devuelve true si aplica el tipo de habitacion
                };
        }
}
