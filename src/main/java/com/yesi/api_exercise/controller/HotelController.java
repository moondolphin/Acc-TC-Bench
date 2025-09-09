package com.yesi.api_exercise.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.yesi.api_exercise.dto.HotelResponseDTO;
import com.yesi.api_exercise.service.HotelService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HotelController {

    private final HotelService hotelService;
    
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelResponseDTO>> findAllHotels(){
        return ResponseEntity.ok(hotelService.findAllHotels());
    } 
    
}
