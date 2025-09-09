package com.yesi.api_exercise.dto;

import java.time.LocalDate;
import java.util.List;

import com.yesi.api_exercise.model.PaymentMethod;
import com.yesi.api_exercise.model.Person;

public record BookingDetailDTO(
    LocalDate dateFrom,
    LocalDate dateTo,
    String destination,
    String hotelCode,
    Integer peopleAmount,
    String roomType,
    List<Person> people,
    List<PaymentMethod> paymentMethod

) 
{}
