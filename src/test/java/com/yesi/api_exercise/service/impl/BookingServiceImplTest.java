package com.yesi.api_exercise.service.impl;
import com.yesi.api_exercise.dto.BookingDetailDTO;
import com.yesi.api_exercise.dto.request.BookingRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;
import com.yesi.api_exercise.exception.PlaceException;
import com.yesi.api_exercise.mapper.BookingMapper;
import com.yesi.api_exercise.model.Booking;
import com.yesi.api_exercise.repository.BookingRepository;
import com.yesi.api_exercise.repository.HotelRepository;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

@Slf4j
// Anotación para activar Mockito con JUnit 5
@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    // @Mock crea una version "simulada" de nuestras dependencias
    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private HotelRepository hotelRepository;
    @Mock
    private BookingMapper bookingMapper;

    // @InjectMocks crea una instancia real de BookingServiceImpl
    @InjectMocks
    private BookingServiceImpl bookingService;

    
    @Test
    void makeReservationHotel_WhenDestinationExists_ShouldReturnBookingResponse() {
        log.info("Ingresamos al test de reservación de hotel caso exito");
        LocalDate dateFrom = LocalDate.of(2025, 9, 20); 
        LocalDate dateTo = LocalDate.of(2025, 9, 28); 


        // 1. GIVEN (Arrange - Preparación)
        // Creamos un DTO de prueba para la petición
        BookingDetailDTO bookingDetail = new BookingDetailDTO(dateFrom, dateTo, "Puerto Iguazú", "BIPA-03", 1, "SINGLE" , null , null);
        BookingRequestDTO requestDTO = new BookingRequestDTO("testUser", bookingDetail);
        
     
        // Creamos los objetos que los mocks deben devolver
        Booking bookingEntity = new Booking(); 
        BookingResponseDTO expectedResponse = new BookingResponseDTO("BIPA-03", "Puerto Iguazú", "SINGLE", dateFrom, dateTo); 

        // Definimos el comportamiento de los mocks
        when(hotelRepository.existsByPlace("Puerto Iguazú")).thenReturn(true);
        when(bookingMapper.toEntity(requestDTO)).thenReturn(bookingEntity);
        when(bookingRepository.save(bookingEntity)).thenReturn(bookingEntity);
        when(bookingMapper.toResponseDTO(bookingEntity, requestDTO)).thenReturn(expectedResponse);

        // 2. WHEN (Act - Accion)
        // Ejecutamos el metodo que queremos probar
        BookingResponseDTO actualResponse = bookingService.makeReservationHotel(requestDTO);

        // 3. THEN (Assert - Verificacion)
        // Comprobamos que el resultado
        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);
        log.info("actual response: ", actualResponse.destination());

        verify(hotelRepository, times(1)).existsByPlace("Puerto Iguazú");
        verify(bookingRepository, times(1)).save(bookingEntity);
        
        log.info("expected response: {}", expectedResponse.destination());
        log.info("actual response: {}", actualResponse.destination());
    }

    
    @Test
    void makeReservationHotel_WhenDestinationDoesNotExist_ShouldThrowPlaceException() {

         log.info("Ingresamos al test de reservación de hotel caso no existe destino");
        LocalDate dateFrom = LocalDate.of(2025, 9, 20); 
        LocalDate dateTo = LocalDate.of(2025, 9, 28); 

        // 1. GIVEN (Arrange - Preparacion)
        BookingDetailDTO bookingDetail = new BookingDetailDTO(dateFrom, dateTo, "Tokio", "BIPA-03", 1, "SINGLE" , null , null);
        BookingRequestDTO requestDTO = new BookingRequestDTO("testUser", bookingDetail);

        // Definimos el comportamiento clave del mock: el destino NO existe
        when(hotelRepository.existsByPlace("Tokio")).thenReturn(false);

        // 2. WHEN & 3. THEN (Accion y Verificacion)
        PlaceException exceptionThrown = assertThrows(PlaceException.class, () -> {
            bookingService.makeReservationHotel(requestDTO);
        });

        assertEquals("Destino no existe", exceptionThrown.getMessage());

        verify(bookingRepository, never()).save(any(Booking.class));
    }
}