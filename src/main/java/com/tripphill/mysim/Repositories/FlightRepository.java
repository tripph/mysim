package com.tripphill.mysim.Repositories;

import com.tripphill.mysim.Models.Flights.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    public List<Flight> findAll();
}
