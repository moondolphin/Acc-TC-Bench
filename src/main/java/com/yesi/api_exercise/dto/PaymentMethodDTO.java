package com.yesi.api_exercise.dto;


import jakarta.validation.constraints.*;

public record PaymentMethodDTO(

        @NotBlank(message = "El tipo de tarjeta es obligatorio.")
        @Pattern(regexp = "CREDIT|DEBIT", message = "El tipo de tarjeta debe ser CREDIT o DEBIT.")
        String type,

        @NotBlank(message = "El número de tarjeta es obligatorio.")
        @Pattern(regexp = "\\d{16}", message = "El número de tarjeta debe tener 16 dígitos numéricos.")
        String number,

        @NotNull(message = "La cantidad de cuotas es obligatoria.")
        @Min(value = 1, message = "La cantidad de cuotas debe ser al menos 1.")
        Integer dues
) {

    @AssertTrue(message = "Tarjeta de débito: solo se permite pagar en 1 cuota.")
    public boolean isValidDebit() {
        if ("DEBIT".equalsIgnoreCase(type)) {
            return dues == 1;
        }
        return true; // no aplica si no es débito
    }

    @AssertTrue(message = "Tarjeta de crédito: solo se permiten hasta 6 cuotas.")
    public boolean isValidCredit() {
        if ("CREDIT".equalsIgnoreCase(type)) {
            return dues >= 1 && dues <= 6;
        }
        return true; // no aplica si no es crédito
    }
}

