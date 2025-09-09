package com.yesi.api_exercise.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yesi.api_exercise.dto.HotelResponseDTO;
import com.yesi.api_exercise.model.Hotel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HotelData implements CommandLineRunner{

    // Formatea las fechas en texto dd/MM/yyyy
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final HotelRepository hotelRepository;


    // Metodo privado para cargar la lista de hoteles con todos los datos de Hotel
    private void loadHotels() {
        List<Hotel> hotelList =  List.of
        
        (    Hotel.builder().codeHotel("CH-0002").name("Cataratas Hotel").place("Puerto Iguazú").roomType("Doble").pricePerNight(6300.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("20/03/2022", dateFormatter)).isBooked(false).build(), 
             Hotel.builder().codeHotel("CH-0003").name("Cataratas Hotel 2").place("Puerto Iguazú").roomType("Triple").pricePerNight(8200.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("19/03/2022", dateFormatter)).isBooked(true).build(), 
             Hotel.builder().codeHotel("HB-0001").name("Hotel Bristol").place("Buenos Aires").roomType("Single").pricePerNight(5300.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("23/03/2022", dateFormatter)).isBooked(true).build()
    
            //new Hotel("BH-0002", "Hotel Bristol 2", "Buenos Aires", "Doble", 7200.0, LocalDate.parse("12/02/2022", dateFormatter), LocalDate.parse("17/04/2022", dateFormatter), false),
            //new Hotel("SH-0002", "Sheraton", "Tucumán", "Doble", 5790.0, LocalDate.parse("17/04/2022", dateFormatter), LocalDate.parse("23/05/2022", dateFormatter), false),
            //new Hotel("SH-0001", "Sheraton 2", "Tucumán", "Single", 4150.0, LocalDate.parse("02/01/2022", dateFormatter), LocalDate.parse("19/02/2022", dateFormatter), false),
            //new Hotel("SE-0001", "Selina", "Bogotá", "Single", 3900.0, LocalDate.parse("23/01/2022", dateFormatter), LocalDate.parse("23/11/2022", dateFormatter), false),
            //new Hotel("SE-0002", "Selina 2", "Bogotá", "Doble", 5840.0, LocalDate.parse("23/01/2022", dateFormatter), LocalDate.parse("15/10/2022", dateFormatter), false),
            //new Hotel("EC-0003", "El Campín", "Bogotá", "Triple", 7020.0, LocalDate.parse("15/02/2022", dateFormatter), LocalDate.parse("27/03/2022", dateFormatter), false),
            //new Hotel("CP-0004", "Central Plaza", "Medellín", "Múltiple", 8600.0, LocalDate.parse("01/03/2022", dateFormatter), LocalDate.parse("17/04/2022", dateFormatter), false),
            //new Hotel("CP-0002", "Central Plaza 2", "Medellín", "Doble", 6400.0, LocalDate.parse("10/02/2022", dateFormatter), LocalDate.parse("20/03/2022", dateFormatter), false),
           // new Hotel("BG-0004", "Bocagrande", "Cartagena", "Múltiple", 9370.0, LocalDate.parse("17/04/2022", dateFormatter), LocalDate.parse("12/06/2022", dateFormatter), false)
        );
        hotelRepository.saveAll(hotelList);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        loadHotels();
       // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}