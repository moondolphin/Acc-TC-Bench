package com.yesi.api_exercise.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yesi.api_exercise.dto.response.HotelResponseDTO;
import com.yesi.api_exercise.service.HotelService;

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

    @GetMapping("/hotels1")
    public ResponseEntity<List<HotelResponseDTO>> findAllHotelsByDateAndPlace(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate availableFrom,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate availableTo,
            @RequestParam String place) {
        return ResponseEntity.ok(hotelService.findAllHotelsByDateAndPlace(availableFrom, availableTo, place));
    }

}
