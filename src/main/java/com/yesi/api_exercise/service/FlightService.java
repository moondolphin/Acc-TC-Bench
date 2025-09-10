package com.yesi.api_exercise.service;

import java.util.List;


import com.yesi.api_exercise.dto.FlightResponseDTO;


public interface FlightService {
    List<FlightResponseDTO> getAllFlights();
    
}
