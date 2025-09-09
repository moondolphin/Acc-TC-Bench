package com.yesi.api_exercise.service;

import java.util.List;
import com.yesi.api_exercise.dto.HotelResponseDTO;

public interface HotelService {
       public List<HotelResponseDTO> findAllHotels();
}
