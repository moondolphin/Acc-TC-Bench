package com.yesi.api_exercise.service;

import java.util.List;

import com.yesi.api_exercise.dto.request.BookingRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;
import com.yesi.api_exercise.dto.response.HotelResponseDTO;

public interface HotelService {
       List<HotelResponseDTO> findAllHotels();
       List<HotelResponseDTO> findAllHotelsByDateAndPlace(String availableFrom, String availableTo, String place);
       BookingResponseDTO makeReservationHotel(BookingRequestDTO bookingRequestDTO);
}