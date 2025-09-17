package com.yesi.api_exercise.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yesi.api_exercise.dto.response.FlightResponseDTO;
import com.yesi.api_exercise.service.FlightService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping("/flights")
    public ResponseEntity<List<FlightResponseDTO>> findAllFlightsByDateAndPlaceAndOrigin(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate departureDate,
                                                                              @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate returnDate,
                                                                              @RequestParam String destination,
                                                                              @RequestParam String origin) {
        return ResponseEntity.ok(flightService.findAllFlightsByDateAndPlaceAndOrigin(departureDate, returnDate, destination, origin));
    }

}
