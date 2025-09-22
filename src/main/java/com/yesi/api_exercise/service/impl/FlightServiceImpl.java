package com.yesi.api_exercise.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.yesi.api_exercise.exception.PlaceException;
import com.yesi.api_exercise.exception.LocalDateException;
import com.yesi.api_exercise.service.FlightService;
import org.springframework.stereotype.Service;
import com.yesi.api_exercise.dto.response.FlightResponseDTO;
import com.yesi.api_exercise.mapper.FlightMapper;
import com.yesi.api_exercise.model.Flight;
import com.yesi.api_exercise.repository.FlightRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightResponseDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
                .map(flightMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightResponseDTO> findAllFlightsByDateAndPlaceAndOrigin(LocalDate departureDate, LocalDate returnDate,
            String destination, String origin) {
        if (flightRepository.existsByOrigin(origin)) {
            throw new PlaceException("El origen elegido no existe");
        }

        if (flightRepository.existsByDestination(destination)) {
            throw new PlaceException("El destino elegido no existe");
        }

        if (departureDate.isAfter(returnDate)) {
            throw new LocalDateException("La fecha de ida debe ser menor a la de vuelta.");
        }

        List<Flight> flights = flightRepository.findAll();

        return flights.stream()
                .filter(flight -> (flight.getDepartureDate().isEqual(departureDate)
                        || flight.getDepartureDate().isAfter(departureDate)) &&
                        (flight.getReturnDate().isEqual(returnDate) || flight.getReturnDate().isBefore(returnDate)) &&
                        flight.getDestination().equals(destination) && flight.getOrigin().equals(origin))
                .map(flightMapper::toResponseDTO)
                .toList();
    }

}
