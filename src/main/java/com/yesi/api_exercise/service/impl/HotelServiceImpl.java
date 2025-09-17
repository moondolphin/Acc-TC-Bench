package com.yesi.api_exercise.service.impl;

import com.yesi.api_exercise.dto.request.BookingRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;
import com.yesi.api_exercise.dto.response.HotelResponseDTO;
import com.yesi.api_exercise.mapper.BookingMapper;
import com.yesi.api_exercise.mapper.HotelMapper;
import com.yesi.api_exercise.model.Booking;
import com.yesi.api_exercise.model.Hotel;
import com.yesi.api_exercise.repository.BookingRepository;
import com.yesi.api_exercise.repository.HotelRepository;
import com.yesi.api_exercise.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<HotelResponseDTO> findAllHotelsByDateAndPlace(LocalDate availableFrom, LocalDate availableTo, String place) {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .filter(hotel -> hotel.getAvailableFrom().isBefore(availableFrom) &&
                        hotel.getAvailableTo().isAfter(availableTo) &&
                        hotel.getPlace().equals(place))
                .map(hotelMapper::toResponseDTO)
                .toList();

    }

}