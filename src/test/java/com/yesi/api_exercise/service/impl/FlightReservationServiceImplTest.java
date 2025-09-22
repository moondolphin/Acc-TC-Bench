package com.yesi.api_exercise.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.yesi.api_exercise.dto.FlightReservationDTO;
import com.yesi.api_exercise.dto.request.FlightReservationRequestDTO;
import com.yesi.api_exercise.dto.response.FlightReservationResponseDTO;
import com.yesi.api_exercise.exception.PlaceException;
import com.yesi.api_exercise.mapper.FlightReservationMapper;
import com.yesi.api_exercise.model.FlightReservation;
import com.yesi.api_exercise.repository.FlightRepository;
import com.yesi.api_exercise.repository.FlightReservationRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class FlightReservationServiceImplTest {
   

    // @Mock crea una version "simulada" de nuestras dependencias
    @Mock
    private FlightReservationRepository flightReservationRepository;
    @Mock
    private FlightRepository flightRepository;
    @Mock
    private FlightReservationMapper flightReservationMapper;

    // @InjectMocks crea una instancia real de BookingServiceImpl
    @InjectMocks
    private FlightReservationServiceImpl flightReservationService;

    
    @Test
    void makeFlightReservation_WhenDestinationExists_ShouldReturnFlightReservationResponse() {
        log.info("Ingresamos al test de reservación de vuelo caso exito");
        LocalDate dateFrom = LocalDate.of(2025, 9, 20); 
        LocalDate dateTo = LocalDate.of(2025, 9, 28); 


        // 1. GIVEN (Arrange - Preparación)
        // Creamos un DTO de prueba para la petición
        FlightReservationDTO flightReservationDTO = new FlightReservationDTO(dateFrom, dateTo, "Bogotá","Buenos Aires", "BIPA03", 1, "Economy" , null , null);
        FlightReservationRequestDTO flightReservationRequestDTO = new FlightReservationRequestDTO("testUser", flightReservationDTO);
        
     
        // Creamos los objetos que los mocks deben devolver
        FlightReservation flightReservationEntity = new FlightReservation(); 
        FlightReservationResponseDTO expectedResponse = new FlightReservationResponseDTO("BIPA03", "Bogotá", "Buenos Aires", "Economy", 1, dateFrom, dateTo); 

        // Definimos el comportamiento de los mocks
        
        when(flightRepository.existsByOrigin("Bogotá")).thenReturn(true);
        when(flightRepository.existsByDestination("Buenos Aires")).thenReturn(true);
        when(flightReservationMapper.toEntity(flightReservationRequestDTO)).thenReturn(flightReservationEntity);
        when(flightReservationRepository.save(flightReservationEntity)).thenReturn(flightReservationEntity);
        when(flightReservationMapper.toResponseDTO(flightReservationEntity, flightReservationRequestDTO)).thenReturn(expectedResponse);

        // 2. WHEN (Act - Accion)
        // Ejecutamos el metodo que queremos probar
        FlightReservationResponseDTO actualResponse = flightReservationService.makeFlightReservation(flightReservationRequestDTO);

        // 3. THEN (Assert - Verificacion)
        // Comprobamos que el resultado
        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);
        log.info("actual response: ", actualResponse.destination());

        verify(flightRepository, times(1)).existsByDestination("Buenos Aires");
        verify(flightReservationRepository, times(1)).save(flightReservationEntity);
        
        log.info("expected response: {}", expectedResponse.destination());
        log.info("actual response: {}", actualResponse.destination());
    }

    
    @Test
    void makeReservationHotel_WhenDestinationDoesNotExist_ShouldThrowPlaceException() {

         log.info("Ingresamos al test de reservación de vuelo caso no existe destino");
        LocalDate dateFrom = LocalDate.of(2025, 9, 20); 
        LocalDate dateTo = LocalDate.of(2025, 9, 28); 

        // 1. GIVEN (Arrange - Preparacion)
        FlightReservationDTO flightReservationDTO = new FlightReservationDTO(dateFrom, dateTo, "Bogotá","Buenos Aires", "BIPA03", 1, "Economy" , null , null);
        FlightReservationRequestDTO requestDTO = new FlightReservationRequestDTO("testUser", flightReservationDTO);

        // Definimos el comportamiento clave del mock: el origen o destino NO existe
        
        when(flightRepository.existsByOrigin("Bogotá")).thenReturn(true);
        when(flightRepository.existsByDestination("Tokio")).thenReturn(false);

        // 2. WHEN & 3. THEN (Accion y Verificacion)
        PlaceException exceptionThrown = assertThrows(PlaceException.class, () -> {
            flightReservationService.makeFlightReservation(requestDTO);
        });

        assertEquals("Destination not found", exceptionThrown.getMessage());
        log.info("Message: {}", exceptionThrown.getMessage());

        verify(flightReservationRepository, never()).save(any(FlightReservation.class)); 
    }
 
}
