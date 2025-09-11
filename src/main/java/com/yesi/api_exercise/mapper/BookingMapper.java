package com.yesi.api_exercise.mapper;

import org.mapstruct.Mapper;

import com.yesi.api_exercise.dto.BookingResponseDTO;
import com.yesi.api_exercise.model.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingResponseDTO toResponseDTO(Booking booking);
}
