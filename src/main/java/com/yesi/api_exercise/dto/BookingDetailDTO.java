package com.yesi.api_exercise.dto;

import java.time.LocalDate;
import java.util.List;

public record BookingDetailDTO(
        LocalDate dateFrom,
        LocalDate dateTo,
        String destination,
        String codeHotel,
        Integer peopleAmount,
        String roomType,
        List<PersonDTO> people,
        List<PaymentMethodDTO> paymentMethod) {
}
