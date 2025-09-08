package com.yesi.api_exercise.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.yesi.api_exercise.model.Flight;

@Repository
public class FlightRepository {

    // Para crear los datos en memoria de vueloss
    private List<Flight> flights;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FlightRepository() {
        this.flights = loadFlights();
    }
    
    // Metodo para obtener todos los vuelos
    public List<Flight> findAll() {
        return new ArrayList<>(this.flights);
    }

    // Meetodo privado para cargar la lista de vuelos
    private List<Flight> loadFlights() {
        return List.of(
            new Flight("BAPI-1235", "Buenos Aires", "Puerto Iguazú", "Economy", 6500.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("15/02/2022", dateFormatter)),
            new Flight("PIBA-1420", "Puerto Iguazú", "Bogotá", "Business", 43200.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("20/02/2022", dateFormatter)),
            new Flight("PIBA-1420", "Puerto Iguazú", "Bogotá", "Economy", 25735.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("21/02/2022", dateFormatter)),
            new Flight("BATU-5536", "Buenos Aires", "Tucumán", "Economy", 7320.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("17/02/2022", dateFormatter)),
            new Flight("TUPI-3369", "Tucumán", "Puerto Iguazú", "Business", 12530.0, LocalDate.parse("12/02/2022", dateFormatter), LocalDate.parse("23/02/2022", dateFormatter)),
            new Flight("TUPI-3369", "Tucumán", "Puerto Iguazú", "Economy", 5400.0, LocalDate.parse("02/01/2022", dateFormatter), LocalDate.parse("16/01/2022", dateFormatter)),
            new Flight("BOCA-4213", "Bogotá", "Cartagena", "Economy", 8000.0, LocalDate.parse("23/01/2022", dateFormatter), LocalDate.parse("05/02/2022", dateFormatter)),
            new Flight("CAME-0321", "Cartagena", "Medellín", "Economy", 7800.0, LocalDate.parse("23/01/2022", dateFormatter), LocalDate.parse("31/01/2022", dateFormatter)),
            new Flight("BOBA-6567", "Bogotá", "Buenos Aires", "Business", 57000.0, LocalDate.parse("15/02/2022", dateFormatter), LocalDate.parse("28/02/2022", dateFormatter)),
            new Flight("BOBA-6567", "Bogotá", "Buenos Aires", "Economy", 39860.0, LocalDate.parse("01/03/2022", dateFormatter), LocalDate.parse("14/03/2022", dateFormatter)),
            new Flight("BOME-4442", "Bogotá", "Medellín", "Economy", 11000.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("24/02/2022", dateFormatter)),
            new Flight("MEPI-9986", "Medellín", "Puerto Iguazú", "Business", 41640.0, LocalDate.parse("17/04/2022", dateFormatter), LocalDate.parse("02/05/2022", dateFormatter))
        );
    }
}
