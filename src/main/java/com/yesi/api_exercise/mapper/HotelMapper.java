package com.yesi.api_exercise.mapper;

import org.mapstruct.Mapper;

import com.yesi.api_exercise.dto.HotelRequestDTO;
import com.yesi.api_exercise.dto.HotelResponseDTO;
import com.yesi.api_exercise.model.Hotel;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    Hotel toEntity(HotelRequestDTO hotelRequestDTO);

    HotelResponseDTO toResponseDTO(Hotel hotel);
}
