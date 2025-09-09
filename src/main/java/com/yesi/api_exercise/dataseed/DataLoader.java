package com.yesi.api_exercise.dataseed;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.yesi.api_exercise.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yesi.api_exercise.model.Hotel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner{

    // Formatea las fechas en texto dd/MM/yyyy
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        loadHotels();
    }

    private void loadHotels() {
        List<Hotel> hotelList =  List.of(
                Hotel.builder().codeHotel("CH-0002").name("Cataratas Hotel").place("Puerto Iguazú").roomType("Doble").pricePerNight(6300.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("20/03/2022", dateFormatter)).isBooked(false).build(),
                Hotel.builder().codeHotel("CH-0003").name("Cataratas Hotel 2").place("Puerto Iguazú").roomType("Triple").pricePerNight(8200.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("19/03/2022", dateFormatter)).isBooked(true).build(),
                Hotel.builder().codeHotel("HB-0001").name("Hotel Bristol").place("Buenos Aires").roomType("Single").pricePerNight(5300.0).availableFrom(LocalDate.parse("10/02/2022", dateFormatter)).availableTo(LocalDate.parse("23/03/2022", dateFormatter)).isBooked(true).build()
        );

        hotelRepository.saveAll(hotelList);
    }
}