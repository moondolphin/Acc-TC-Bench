package com.yesi.api_exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yesi.api_exercise.dto.request.BookingRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;
import com.yesi.api_exercise.service.BookingService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<?> makeBookingHotel(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
    try {
        BookingResponseDTO response = bookingService.makeReservationHotel(bookingRequestDTO);
        return ResponseEntity.ok(response);
    } catch (IllegalArgumentException e) {
        // Captura el error del service y devuelve un 400 Bad Request con el mensaje
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        // Captura errores inesperados y devuelve un 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Unexpected error: " + e.getMessage());
    }
}


}
