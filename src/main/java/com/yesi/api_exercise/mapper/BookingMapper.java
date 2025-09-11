package com.yesi.api_exercise.mapper;

import com.yesi.api_exercise.dto.BookingRequestDTO;
import org.mapstruct.Mapper;

import com.yesi.api_exercise.dto.BookingResponseDTO;
import com.yesi.api_exercise.model.Booking;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "username", source = "userName")
    @Mapping(target = "dateFrom", source = "booking.dateFrom")
    @Mapping(target = "dateTo", source = "booking.dateTo")
    @Mapping(target = "destination", source = "booking.destination")
    @Mapping(target = "codeHotel", source = "booking.codeHotel")
    @Mapping(target = "peopleAmount", source = "booking.peopleAmount")
    Booking toEntity(BookingRequestDTO bookingRequestDTO);

    @Mapping(target = "codeHotel", source = "booking.codeHotel")
    @Mapping(target = "destination", source = "booking.destination")
    @Mapping(target = "dateFrom", source = "booking.dateFrom")
    @Mapping(target = "dateTo", source = "booking.dateTo")
    @Mapping(target = "roomType", source = "bookingRequestDTO.booking.roomType")
    BookingResponseDTO toResponseDTO(Booking booking, BookingRequestDTO bookingRequestDTO);
}
