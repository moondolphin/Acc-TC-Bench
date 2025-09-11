package com.yesi.api_exercise.dto;

public record PaymentMethodDTO(
    String type,
    String number,
    Integer dues ){}


