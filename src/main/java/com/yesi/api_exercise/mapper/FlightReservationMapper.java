package com.yesi.api_exercise.mapper;

import com.yesi.api_exercise.dto.request.BookingRequestDTO;
import com.yesi.api_exercise.dto.request.FlightReservationRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;
import com.yesi.api_exercise.dto.response.FlightReservationResponseDTO;
import com.yesi.api_exercise.model.Booking;
import com.yesi.api_exercise.model.FlightReservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlightReservationMapper {
    @Mapping(target = "username", source = "userName")
    @Mapping(target = "dateFrom", source = "flightReservation.dateFrom")
    @Mapping(target = "dateTo", source = "flightReservation.dateTo")
    @Mapping(target = "origin", source = "flightReservation.origin")
    @Mapping(target = "destination", source = "flightReservation.destination")
    @Mapping(target = "flightNumber", source = "flightReservation.flightNumber")
    @Mapping(target = "seatType", source = "flightReservation.seatType")

    @Mapping(target = "seats", source = "flightReservation.seats")
    FlightReservation toEntity(FlightReservationRequestDTO flightReservationRequestDTO);

    @Mapping(target = "flightNumber", source = "flightReservation.flightNumber")
    @Mapping(target = "origin", source = "flightReservation.origin")
    @Mapping(target = "destination", source = "flightReservation.destination")
    @Mapping(target = "dateFrom", source = "flightReservation.dateFrom")
    @Mapping(target = "dateTo", source = "flightReservation.dateTo")
    @Mapping(target = "seatType", source = "flightReservation.seatType")
    FlightReservationResponseDTO toResponseDTO(FlightReservation flightReservation, FlightReservationRequestDTO flightReservationRequestDTO);

}
