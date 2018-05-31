package com.tripphill.mysim.Services;

import com.tripphill.mysim.Models.Flights.FlightDTO;
import com.tripphill.mysim.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getAllFlightDTOs() {
        return this.flightRepository.findAll()
                .stream()
                .map(FlightDTO::new)
                .collect(Collectors.toList());
    }
}
