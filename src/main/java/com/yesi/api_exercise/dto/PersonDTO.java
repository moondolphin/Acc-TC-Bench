package com.yesi.api_exercise.dto;

import java.time.LocalDate;

public record PersonDTO(
    int dni,
    String name,
    String lastname,
    LocalDate birthDate,
    String mail) {}

