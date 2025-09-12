package com.yesi.api_exercise.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    private String flightNumber;
    private String origin;
    private String destination;
    private String seatType;
    private Double price;
    private LocalDate departureDate;
    private LocalDate returnDate;

}
