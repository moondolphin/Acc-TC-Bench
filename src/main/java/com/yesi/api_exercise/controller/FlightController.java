package com.yesi.api_exercise.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesi.api_exercise.dto.FlightResponseDTO;
import com.yesi.api_exercise.service.FlightService;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights(){
        return ResponseEntity.ok(flightService.getAllFlights());
    }
    
}
