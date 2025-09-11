package com.yesi.api_exercise.mapper;

import org.mapstruct.Mapper;

import com.yesi.api_exercise.dto.BookingRequestDTO;
import com.yesi.api_exercise.dto.HotelResponseDTO;
import com.yesi.api_exercise.model.Hotel;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel toEntity(BookingRequestDTO bookingRequestDTO);
    HotelResponseDTO toResponseDTO(Hotel hotel);
}
