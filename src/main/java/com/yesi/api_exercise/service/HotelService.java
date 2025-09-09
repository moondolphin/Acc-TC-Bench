package com.yesi.api_exercise.service;

import java.time.LocalDate;
import java.util.List;


import com.yesi.api_exercise.dto.HotelResponseDTO;

public interface HotelService {
       List<HotelResponseDTO> findAllHotels();
       List<HotelResponseDTO> findAllHotelsByDateAndPlace(String availableFrom, String availableTo, String place);
}