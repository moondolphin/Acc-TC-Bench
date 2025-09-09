package com.yesi.api_exercise.service;

import com.yesi.api_exercise.dto.HotelResponseDTO;
import com.yesi.api_exercise.mapper.HotelMapper;
import com.yesi.api_exercise.model.Hotel;
import com.yesi.api_exercise.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
// En HotelServiceImpl.java
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public List<HotelResponseDTO> findAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                     .map(hotelMapper::toResponseDTO)
                     .collect(Collectors.toList());
    }
}