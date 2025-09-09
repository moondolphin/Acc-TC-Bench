package com.yesi.api_exercise.service;

import com.yesi.api_exercise.dto.HotelResponseDTO;
import com.yesi.api_exercise.mapper.HotelMapper;
import com.yesi.api_exercise.model.Hotel;
import com.yesi.api_exercise.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
// En HotelServiceImpl.java
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public List<HotelResponseDTO> findAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                     .map(hotelMapper::toResponseDTO)
                     .collect(Collectors.toList());
    }

   @Override
    public List<HotelResponseDTO> findAllHotelsByDateAndPlace(String availableFrom, String availableTo, String place){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().filter(hotel -> 
            hotel.getAvailableFrom().isBefore(LocalDate.parse(availableFrom, dateFormatter)) &&
            hotel.getAvailableTo().isAfter(LocalDate.parse(availableTo, dateFormatter)) &&
            hotel.getPlace().equals(place)).map(hotelMapper::toResponseDTO)
            .toList();
    
    }
}