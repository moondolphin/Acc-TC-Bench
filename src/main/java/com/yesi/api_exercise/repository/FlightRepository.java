package com.yesi.api_exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yesi.api_exercise.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
    
}
    
    
