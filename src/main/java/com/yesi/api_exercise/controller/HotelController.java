package com.yesi.api_exercise.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yesi.api_exercise.dto.response.HotelResponseDTO;
import com.yesi.api_exercise.service.HotelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelResponseDTO>> findAllHotels() {
        return ResponseEntity.ok(hotelService.findAllHotels());
    }

    @GetMapping("/hotels?dateFrom={availableFrom}&dateTo={availableTo}&destination={place}")
    public ResponseEntity<List<HotelResponseDTO>> findAllHotelsByDateAndPlace(@Valid @RequestParam String availableFrom,
            @RequestParam String availableTo,
            @RequestParam String place) {
        return ResponseEntity.ok(hotelService.findAllHotelsByDateAndPlace(availableFrom, availableTo, place));
    }

}
