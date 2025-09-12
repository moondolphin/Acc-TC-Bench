package com.yesi.api_exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yesi.api_exercise.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
