package com.yesi.api_exercise.repository;

import com.yesi.api_exercise.model.Booking;
import com.yesi.api_exercise.model.FlightReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightReservationRepository extends JpaRepository<FlightReservation, Integer> {

}
