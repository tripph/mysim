package com.tripphill.mysim.Services;

import com.tripphill.mysim.Models.Airports.Airport;
import com.tripphill.mysim.Repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AirportService {
    private final AirportRepository airportRepository;
    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Cacheable("airports")
    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

}
