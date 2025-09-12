package com.yesi.api_exercise.service;

import com.yesi.api_exercise.dto.request.BookingRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;

public interface BookingService {
     BookingResponseDTO makeReservationHotel(BookingRequestDTO bookingRequestDTO);
}
