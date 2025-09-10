package com.yesi.api_exercise.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yesi.api_exercise.dto.FlightResponseDTO;
import com.yesi.api_exercise.mapper.FlightMapper;
import com.yesi.api_exercise.model.Flight;
import com.yesi.api_exercise.repository.FlightRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightResponseDTO> getAllFlights(){
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
        .map(flightMapper::toResponseDTO)
        .collect(Collectors.toList());
    }
}
