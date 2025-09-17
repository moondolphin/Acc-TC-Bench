package com.yesi.api_exercise.service;

import java.time.LocalDate;
import java.util.List;


import com.yesi.api_exercise.dto.response.HotelResponseDTO;

public interface HotelService {
       List<HotelResponseDTO> findAllHotels();
       List<HotelResponseDTO> findAllHotelsByDateAndPlace(LocalDate availableFrom, LocalDate availableTo, String place);
}