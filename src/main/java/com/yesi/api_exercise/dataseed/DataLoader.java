package com.yesi.api_exercise.dataseed;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.yesi.api_exercise.repository.FlightRepository;
import com.yesi.api_exercise.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yesi.api_exercise.model.Flight;
import com.yesi.api_exercise.model.Hotel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner{

    // Formatea las fechas en texto dd/MM/yyyy
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final HotelRepository hotelRepository;

    private final FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {
        loadHotels();
        loadFlights();
    }

    private void loadHotels() {
        List<Hotel> hotelList =  List.of(
                Hotel.builder().codeHotel("CH-0002").name("Cataratas Hotel").place("Puerto Iguazú").roomType("Doble").pricePerNight(6300.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("20/03/2022", dateFormatter)).isBooked(false).build(),
                Hotel.builder().codeHotel("CH-0003").name("Cataratas Hotel 2").place("Puerto Iguazú").roomType("Triple").pricePerNight(8200.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("19/03/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("HB-0001").name("Hotel Bristol").place("Buenos Aires").roomType("Single").pricePerNight(5300.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("23/03/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("HB-0001").name("Hotel Bristol").place("Buenos Aires").roomType("Single").pricePerNight(5300.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("23/03/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("BH-0002").name("Sheraton").place("Buenos Aires").roomType("Doble").pricePerNight(7300.0).availableFrom(LocalDate.parse("12/03/2022", dateFormatter)).availableTo(LocalDate.parse("28/03/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("SH-0002").name("Sheraton 2").place("Tucumán").roomType("Doble").pricePerNight(5200.0).availableFrom(LocalDate.parse("13/04/2022", dateFormatter)).availableTo(LocalDate.parse("23/05/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("SH-0001").name("Selina").place("Tucumán").roomType("Single").pricePerNight(8300.0).availableFrom(LocalDate.parse("23/04/2022", dateFormatter)).availableTo(LocalDate.parse("23/05/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("SH-0001").name("Selina 2").place("Bogotá").roomType("Single").pricePerNight(5300.0).availableFrom(LocalDate.parse("22/02/2022", dateFormatter)).availableTo(LocalDate.parse("16/04/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("EC-0003").name("El Campín").place("Bogotá").roomType("Triple").pricePerNight(5300.0).availableFrom(LocalDate.parse("22/02/2022", dateFormatter)).availableTo(LocalDate.parse("16/04/2022", dateFormatter)).isBooked(true).build()
        );
        hotelRepository.saveAll(hotelList);
    }

    private void loadFlights(){
        List<Flight> flightList = List.of(
            Flight.builder().flightNumber("BAPI-1235").origin("Buenos Aires").destination("Puerto Iguazú").seatType("Economy").price(6500.0).departureDate(LocalDate.parse("10/02/2022", dateFormatter)).returnDate(LocalDate.parse("15/02/2022", dateFormatter)).build()
            // Flight.builder().flightNumber(null).origin(null).destination().seatType().price().departureDate().returnDate().build(),
            // Flight.builder().flightNumber(null).origin(null).destination().seatType().price().departureDate().returnDate().build(),
            // Flight.builder().flightNumber(null).origin(null).destination().seatType().price().departureDate().returnDate().build(),
            );
            flightRepository.saveAll(flightList);  
    }
}