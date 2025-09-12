package com.yesi.api_exercise.dto.request;

import com.yesi.api_exercise.dto.FlightReservationDTO;

public record FlightReservationRequestDTO(
                String userName,
                FlightReservationDTO flightReservation) {

}
