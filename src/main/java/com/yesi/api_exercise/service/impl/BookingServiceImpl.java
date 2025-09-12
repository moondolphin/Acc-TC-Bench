package com.yesi.api_exercise.service.impl;

import org.springframework.stereotype.Service;
import com.yesi.api_exercise.dto.request.BookingRequestDTO;
import com.yesi.api_exercise.dto.response.BookingResponseDTO;
import com.yesi.api_exercise.mapper.BookingMapper;
import com.yesi.api_exercise.model.Booking;
import com.yesi.api_exercise.repository.BookingRepository;
import com.yesi.api_exercise.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingResponseDTO makeReservationHotel(BookingRequestDTO bookingRequestDTO) {
        log.info("Iniciando proceso de reserva para el usuario: ",
         bookingRequestDTO.userName() ,  " Con destino a: ", bookingRequestDTO.booking().destination());

        Booking booking = bookingMapper.toEntity(bookingRequestDTO);
        Booking save = bookingRepository.save(booking);
        log.debug("Reserva de hotel creada exitosamente con ID: ", save.getId());

        return bookingMapper.toResponseDTO(save, bookingRequestDTO);
    }
}
