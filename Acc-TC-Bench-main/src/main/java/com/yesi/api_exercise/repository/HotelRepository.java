package com.yesi.api_exercise.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.yesi.api_exercise.dto.HotelResponseDTO;

@Repository
public class HotelRepository {

    // Para crear los datos en memoria de hoteles
    private List<HotelResponseDTO> hotels;

    // Formatea las fechas en texto dd/MM/yyyy
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public HotelRepository() {
        this.hotels = loadHotels(); // Para cargar los datos al crear el repositorio
    }

    // Metodo para obtener todos los hoteles
    public List<HotelResponseDTO> findAll() {
        return new ArrayList<>(this.hotels);
    }

    // Metodo privado para cargar la lista de hoteles con todos los datos de Hotel
    private List<HotelResponseDTO> loadHotels() {
        return List.of(
            new HotelResponseDTO("CH-0002", "Cataratas Hotel", "Puerto Iguazú", "Doble", 6300.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("20/03/2022", dateFormatter), false),
            new HotelResponseDTO("CH-0003", "Cataratas Hotel 2", "Puerto Iguazú", "Triple", 8200.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("23/03/2022", dateFormatter), false),
            new HotelResponseDTO("HB-0001", "Hotel Bristol", "Buenos Aires", "Single", 5435.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("19/03/2022", dateFormatter), false),
            new HotelResponseDTO("BH-0002", "Hotel Bristol 2", "Buenos Aires", "Doble", 7200.0, LocalDate.parse("12/02/2022", dateFormatter), LocalDate.parse("17/04/2022", dateFormatter), false),
            new HotelResponseDTO("SH-0002", "Sheraton", "Tucumán", "Doble", 5790.0, LocalDate.parse("17/04/2022", dateFormatter), LocalDate.parse("23/05/2022", dateFormatter), false),
            new HotelResponseDTO("SH-0001", "Sheraton 2", "Tucumán", "Single", 4150.0, LocalDate.parse("02/01/2022", dateFormatter), LocalDate.parse("19/02/2022", dateFormatter), false),
            new HotelResponseDTO("SE-0001", "Selina", "Bogotá", "Single", 3900.0, LocalDate.parse("23/01/2022", dateFormatter), LocalDate.parse("23/11/2022", dateFormatter), false),
            new HotelResponseDTO("SE-0002", "Selina 2", "Bogotá", "Doble", 5840.0, LocalDate.parse("23/01/2022", dateFormatter), LocalDate.parse("15/10/2022", dateFormatter), false),
            new HotelResponseDTO("EC-0003", "El Campín", "Bogotá", "Triple", 7020.0, LocalDate.parse("15/02/2022", dateFormatter), LocalDate.parse("27/03/2022", dateFormatter), false),
            new HotelResponseDTO("CP-0004", "Central Plaza", "Medellín", "Múltiple", 8600.0, LocalDate.parse("01/03/2022", dateFormatter), LocalDate.parse("17/04/2022", dateFormatter), false),
            new HotelResponseDTO("CP-0002", "Central Plaza 2", "Medellín", "Doble", 6400.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("20/03/2022", dateFormatter), false),
            new HotelResponseDTO("BG-0004", "Bocagrande", "Cartagena", "Múltiple", 9370.0, LocalDate.parse("17/04/2022", dateFormatter), LocalDate.parse("12/06/2022", dateFormatter), false)
        );
    }
}