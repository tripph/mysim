package com.tripphill.mysim.Repositories;

import com.tripphill.mysim.Models.Airports.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AirportRepository extends CrudRepository<Airport, String> {
    public List<Airport> findAll();
}

