package com.yesi.api_exercise.dto.request;

import com.yesi.api_exercise.dto.BookingDetailDTO;

public record BookingRequestDTO(
        String userName,
        BookingDetailDTO booking) {

}
