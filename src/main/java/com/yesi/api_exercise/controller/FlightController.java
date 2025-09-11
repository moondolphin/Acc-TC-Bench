package com.yesi.api_exercise.controller;

import java.util.List;

import com.yesi.api_exercise.dto.FlightReservationDTO;
import com.yesi.api_exercise.dto.request.FlightReservationRequestDTO;
import com.yesi.api_exercise.dto.response.FlightReservationResponseDTO;
import com.yesi.api_exercise.service.FlightReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yesi.api_exercise.dto.response.FlightResponseDTO;
import com.yesi.api_exercise.service.FlightService;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlightController {

    private final FlightReservationService flightReservationService;
    private final FlightService flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights(){
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @PostMapping("/flight-reservation")
    public ResponseEntity<FlightReservationResponseDTO> makeFlightReservation(@RequestBody FlightReservationRequestDTO flightReservationRequestDTO){
        return ResponseEntity.ok(flightReservationService.makeFlightReservation(flightReservationRequestDTO));
    }
    
}
