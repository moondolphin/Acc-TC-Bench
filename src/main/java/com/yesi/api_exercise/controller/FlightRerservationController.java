package com.yesi.api_exercise.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesi.api_exercise.dto.request.FlightReservationRequestDTO;
import com.yesi.api_exercise.dto.response.FlightReservationResponseDTO;
import com.yesi.api_exercise.service.FlightReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlightRerservationController {

    private final FlightReservationService flightReservationService;

    @PostMapping("/flight-reservation")
    public ResponseEntity<FlightReservationResponseDTO> makeFlightReservation(
       @Valid @RequestBody FlightReservationRequestDTO flightReservationRequestDTO) {
        return ResponseEntity.ok(flightReservationService.makeFlightReservation(flightReservationRequestDTO));
    }
}
