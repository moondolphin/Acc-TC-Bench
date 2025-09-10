package com.yesi.api_exercise.mapper;

import org.mapstruct.Mapper;

import com.yesi.api_exercise.dto.FlightRequestDTO;
import com.yesi.api_exercise.dto.FlightResponseDTO;
import com.yesi.api_exercise.model.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    Flight toEntity(FlightRequestDTO flightRequestDTO);
    FlightResponseDTO toResponseDTO(Flight flight);

    
}
