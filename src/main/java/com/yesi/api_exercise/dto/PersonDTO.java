package com.yesi.api_exercise.dto;

import java.time.LocalDate;

public record PersonDTO(
    Integer dni,
    String name,
    String lastname,
    LocalDate birthDate,
    String mail) {}

