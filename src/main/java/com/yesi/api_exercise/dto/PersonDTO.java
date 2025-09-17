package com.yesi.api_exercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PersonDTO(
        @NotNull(message = "El DNI es obligatorio.")
        Integer dni,

        @NotBlank(message = "El nombre es obligatorio.")
        String name,

        @NotBlank(message = "El apellido es obligatorio.")
        String lastname,

        @NotNull(message = "La fecha de nacimiento es obligatoria.")
        LocalDate birthDate,

        @NotBlank(message = "El e-mail es obligatorio.")
        @Email(message = "Por favor ingrese un e-mail válido")
        String mail
        ) {
}
