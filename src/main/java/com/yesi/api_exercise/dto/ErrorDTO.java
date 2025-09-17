package com.yesi.api_exercise.dto;

public record ErrorDTO(
        int status,
        String name,
        String message
) {}
