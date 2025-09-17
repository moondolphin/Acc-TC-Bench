package com.yesi.api_exercise.dto;

import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public record PersonDTO(
        Integer dni,
        String name,
        String lastname,
        LocalDate birthDate,
        @Email(message = "Por favor ingrese un e-mail válido")
        String mail) {
}
