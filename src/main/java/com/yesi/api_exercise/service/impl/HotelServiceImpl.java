package com.yesi.api_exercise.service.impl;


import com.yesi.api_exercise.dto.response.HotelResponseDTO;

import com.yesi.api_exercise.exception.LocalDateException;
import com.yesi.api_exercise.exception.PlaceException;
import com.yesi.api_exercise.mapper.HotelMapper;
import com.yesi.api_exercise.model.Hotel;
import com.yesi.api_exercise.repository.HotelRepository;
import com.yesi.api_exercise.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<HotelResponseDTO> findAllHotelsByDateAndPlace(LocalDate availableFrom, LocalDate availableTo, String place) {
        if (availableFrom.isAfter(availableTo)) {
            throw new LocalDateException("La fecha de entrada debe ser menor a la de salida.");
        }

        if (availableTo.isBefore(availableFrom)) {
            throw new LocalDateException("La fecha de salida debe ser mayor a la de entrada.");
        }

        if (!hotelRepository.existsByPlace(place)) {
            throw new PlaceException("El destino elegido no existe");
        }

        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .filter(hotel -> (hotel.getAvailableFrom().isEqual(availableFrom) || hotel.getAvailableFrom().isBefore(availableFrom)) &&
                        (hotel.getAvailableTo().isEqual(availableTo) || hotel.getAvailableTo().isAfter(availableTo)) &&
                        hotel.getPlace().equals(place))
                .map(hotelMapper::toResponseDTO)
                .toList();

    }

}