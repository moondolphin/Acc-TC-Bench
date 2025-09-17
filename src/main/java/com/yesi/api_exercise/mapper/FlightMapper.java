package com.yesi.api_exercise.mapper;

import org.mapstruct.Mapper;


import com.yesi.api_exercise.dto.response.FlightResponseDTO;
import com.yesi.api_exercise.model.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightResponseDTO toResponseDTO(Flight flight);
}
